package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailInputField = By.xpath("//input[@name='name']");
    private By passwordInputField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    private By passwordRecoveryButton = By.xpath("//a[text()='Восстановить пароль']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");

    public void clickOnRegisterButton() {
        WebElement registerElement = driver.findElement(registerButton);
        registerElement.click();
    }
}
