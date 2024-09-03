import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import user.User;
import user.generator.UserDataGenerator;
import util.TestUtilities;

import static org.junit.Assert.assertTrue;
@RunWith(Parameterized.class)
public class RegisterTest {
    WebDriver driver;
    String username;
    String userEmail;
    String userPassword;
    boolean isSuccess;
    TestUtilities testUtilities = new TestUtilities();
    public RegisterTest(String username,String userEmail,String userPassword,boolean isSuccess) {
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isSuccess = isSuccess;
    }
    @Parameterized.Parameters()
    public static Object[][] userDataInsert() {
        UserDataGenerator userDataGenerator = new UserDataGenerator();

        return new Object[][]{
                {userDataGenerator.generateUserName(),userDataGenerator.generateUserEmail(),userDataGenerator.generateUserPassword(10,16),true,},
                {userDataGenerator.generateUserName(),userDataGenerator.generateUserEmail(),userDataGenerator.generateUserPassword(1,5),false}
    };
   }
    @Before
    public void setup() {
        driver = testUtilities.actionsBeforeTest();
    }
    @Test
    @DisplayName("Регистрация пользователя при переходе по кнопке - личный кабинет")
    public void registerTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickOnPersonalAccountButton();
        loginPage.clickOnRegisterButton();
        registerPage.setNameInputField(username);
        registerPage.setEmailInputField(userEmail);
        registerPage.setPasswordInputField(userPassword);
        registerPage.clickOnRegisterButton();

        if (isSuccess) {
            assertTrue("Кнопка - войти, не видна", loginPage.logInButtonIsVisible());
        }
        else {
            registerPage.checkPasswordErrorIsDisplayed();
        }
    }
    @After
    public void tearDown() {
        //Эта конструкция применима только к этому тесту, т.к. пользователь создается в UI, а не посредством API
        if(isSuccess) {
            User user = new User(userEmail, userPassword, username);
            testUtilities.actionsAfterTest(user);
        }
        else {
            driver.quit();
        }
    }
}