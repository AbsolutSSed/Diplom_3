import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;
import user.User;
import user.manager.UserManager;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class TransitionTest {
        WebDriver driver;
        String browser;
        String email;
        String password;

        @Parameterized.Parameters
        public static Collection<String> browsers() {
            return Arrays.asList("chrome", "firefox");
        }

        public TransitionTest(String browser) {
            this.browser = browser;
        }

        @Before
        public void setUp() {
            switch (browser.toLowerCase()) {
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
        @DisplayName("Проверка перехода из личного кабинета по клику на конструктор")
        public void transitionFromCabinetToConstructor() {
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            ProfilePage profilePage = new ProfilePage(driver);
            mainPage.clickOnLoginAccountButton();
            loginPage.setEmailInputField(email);
            loginPage.setPasswordInputField(password);
            loginPage.clickOnLogInButton();
            mainPage.clickOnPersonalAccountButton();
            profilePage.clickOnConstructorButton();
        }
        @Test
        @DisplayName("Проверка перехода из личного кабинета по клику на лого сайта")
        public void transitionFromCabinetToLogo() {
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            ProfilePage profilePage = new ProfilePage(driver);
            mainPage.clickOnLoginAccountButton();
            loginPage.setEmailInputField(email);
            loginPage.setPasswordInputField(password);
            loginPage.clickOnLogInButton();
            mainPage.clickOnPersonalAccountButton();
            profilePage.clickOnLogo();
        }
    @After
    public void tearDown() {
            driver.quit();
        }
}
