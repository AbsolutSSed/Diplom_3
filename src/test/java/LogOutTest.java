import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;
import user.User;
import user.manager.UserManager;
import util.BrowserConfig;

public class LogOutTest {
    WebDriver driver;
    String email;
    String password;

    @Before
    public void setUp() {
        String browser = BrowserConfig.getBrowser();
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
        }
        driver.get("https://stellarburgers.nomoreparties.site/");
        UserManager userManager = new UserManager();
        User user = userManager.createUserData();
        userManager.createNewUser(user);
        email = user.getEmail();
        password = user.getPassword();
    }
    @Test
    @DisplayName("Выход из личного кабинета по кнопке - выход")
    public void logOutUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickOnPersonalAccountButton();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLogInButton();
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnLogOutButton();
        loginPage.logInButtonIsVisible();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}