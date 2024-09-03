import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import user.User;
import user.manager.UserManager;
import util.BrowserConfig;
import util.TestUtilities;

public class LogOutTest {
    WebDriver driver;
    String email;
    String password;
    User user;
    TestUtilities testUtilities = new TestUtilities();

    @Before
    public void setUp() {
        driver = testUtilities.actionsBeforeTest();
        UserManager userManager = new UserManager();
        user = userManager.createUserData();
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
        testUtilities.actionsAfterTest(user);
    }
}