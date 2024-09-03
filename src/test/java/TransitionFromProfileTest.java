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

import static org.junit.Assert.assertTrue;

public class TransitionFromProfileTest {
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
            testUtilities.actionsAfterTest(user);
        }
}
