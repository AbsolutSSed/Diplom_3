package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By personalAccountButton = By.xpath("//*/nav/a/p[text()='Личный Кабинет']");
    private By loginInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    private By bunButton = By.xpath("//span[text()='Булки']");
    private By saucesButton = By.xpath("//span[text()='Соусы']");
    private By fillingButton = By.xpath("//span[text()='Начинки']");
    private By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public void waitForOverlayInvisible() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
    }
    @Step("Клик по кнопке - личный кабинет")
    public void clickOnPersonalAccountButton() {
        waitForOverlayInvisible();
        driver.findElement(personalAccountButton).click();
    }
    @Step("Клик по кнопке - войти в аккаунт")
    public void clickOnLoginAccountButton() {
        WebElement loginAccount = driver.findElement(loginInAccountButton);
        loginAccount.click();
    }
    @Step("Проверка наличия кнопки - оформить заказ")
    public boolean makeOrderButtonIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        return driver.findElement(makeOrderButton).isDisplayed();
    }
    @Step("Проверка наличия кнопки - войти в аккаунт на главной странице")
    public boolean logInAccountButtonIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(loginInAccountButton));
        return driver.findElement(loginInAccountButton).isDisplayed();
    }
}
