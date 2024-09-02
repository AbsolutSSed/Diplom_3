package page_object;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By nameInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInputField = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By invalidPasswordNotification = By.xpath("//p[text()='Некорректный пароль']");
    private final By logInButton = By.xpath("//*/div/p/a[text()='Войти']");
    @Step("Заполнение поля - имя")
    public void setNameInputField(String username) {
        WebElement nameField = driver.findElement(nameInputField);
        nameField.sendKeys(username);
    }
    @Step("Заполнение поля - email")
    public void setEmailInputField(String email) {
        WebElement emailField = driver.findElement(emailInputField);
        emailField.sendKeys(email);
    }
    @Step("Заполнение поля - пароль")
    public void setPasswordInputField(String password) {
        WebElement passwordField = driver.findElement(passwordInputField);
        passwordField.sendKeys(password);
    }
    @Step("Нажать на кнопку - зарегистрироваться")
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Получить ссылку после регистрации")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    @Step("Проверить наличие ошибки")
    public void checkPasswordErrorIsDisplayed() {
        driver.findElement(invalidPasswordNotification).isDisplayed();
    }
    @Step("Ожидаемый URL после регистрации")
    public void waitForUrlToBe(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Step("Нажать на кнопку - войти")
    public void clickOnLogInButton(){
        driver.findElement(logInButton).click();
    }
}
