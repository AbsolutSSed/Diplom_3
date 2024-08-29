import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;
import user.generator.UserDataGenerator;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegisterTest {
    WebDriver driver;
    String username;
    String userEmail;
    String userPassword;
    boolean isSuccess;
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
                {userDataGenerator.generateUserName(),userDataGenerator.generateUserEmail(),userDataGenerator.generateUserPassword(10,16),true},
                {userDataGenerator.generateUserName(),userDataGenerator.generateUserEmail(),userDataGenerator.generateUserPassword(0,5),false}

    };
   }
    @Before
    public void setup() {
        // TODO: 29.08.2024 Сделать if на яндекс браузер
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Регистрация пользователя при переходе по кнопке - личный кабинет")
    public void RegisterTest() {
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
            String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
            registerPage.waitForUrlToBe(expectedUrl);
            String actualUrl = registerPage.getCurrentUrl();
            assertTrue("Произошла ошибка - ожидаемый URL после регистрации : " + expectedUrl + " актуальный: " + actualUrl, expectedUrl.equals(actualUrl));
        }
        else {
            registerPage.checkPasswordErrorIsDisplayed();
        }
    }
    @After
    public void tearDown() {
            driver.quit();
    }
}
