import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import user.User;
import user.manager.UserManager;
import util.TestUtilities;

public class LoginTest extends TestUtilities {
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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginInMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickOnLoginAccountButton();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLogInButton();
        mainPage.makeOrderButtonIsVisible();
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginInPersonalAccountPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickOnPersonalAccountButton();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLogInButton();
        mainPage.makeOrderButtonIsVisible();
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginViaRegisterFormButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickOnPersonalAccountButton();
        loginPage.clickOnRegisterButton();
        registerPage.clickOnLogInButton();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLogInButton();
        mainPage.makeOrderButtonIsVisible();
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginThroughForgotPasswordForm() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        mainPage.clickOnLoginAccountButton();
        loginPage.clickOnRecoveryPasswordButton();
        recoveryPasswordPage.clickOnLogInButton();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLogInButton();
        mainPage.makeOrderButtonIsVisible();
    }
    @After
    public void tearDown() {
        testUtilities.actionsAfterTest(user);
    }
}
