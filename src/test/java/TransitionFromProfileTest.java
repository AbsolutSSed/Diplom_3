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

import static org.junit.Assert.assertTrue;

public class TransitionFromProfileTest {
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
            assertTrue("После перехода на главную страницу - не видно кнопки - оформить заказ", mainPage.makeOrderButtonIsVisible());
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
            assertTrue("После перехода на главную страницу - не видно кнопки - оформить заказ", mainPage.makeOrderButtonIsVisible());
        }
    @After
    public void tearDown() {
            driver.quit();
        }
}
