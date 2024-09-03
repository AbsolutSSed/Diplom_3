package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailInputField = By.xpath("//input[@name='name']");
    private final By passwordInputField = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By passwordRecoveryButton = By.xpath("//a[text()='Восстановить пароль']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    @Step("Нажать на кнопку - зарегистрироваться")
    public void clickOnRegisterButton() {
        WebElement registerElement = driver.findElement(registerButton);
        registerElement.click();
    }
    @Step("Ввод email пользователя")
    public void setEmailInputField(String email) {
        WebElement emailInput = driver.findElement(emailInputField);
        emailInput.sendKeys(email);
    }
    @Step("Ввод пароля пользователя")
    public void setPasswordInputField(String password){
        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.sendKeys(password);
    }
    @Step("Нажать на кнопку - войти")
    public void clickOnLogInButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Нажать кнопку - восстановить пароль")
    public void clickOnRecoveryPasswordButton() {
        driver.findElement(passwordRecoveryButton).click();
    }
    @Step("Проверка наличия кнопки - войти в аккаунт")
    public boolean logInButtonIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).isDisplayed();
    }

}
