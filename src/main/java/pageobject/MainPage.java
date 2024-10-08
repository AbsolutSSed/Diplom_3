package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    private final By personalAccountButton = By.xpath("//*/nav/a/p[text()='Личный Кабинет']");
    private final By loginInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By bunCategory = By.xpath("//span[text()='Булки']");
    private final By saucesCategory = By.xpath("//span[text()='Соусы']");
    private final By fillingCategory = By.xpath("//span[text()='Начинки']");
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By selectedCategory = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

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
    @Step("Получить текст выбранного раздела")
    public String getTextSelectedCategory(){
        return driver.findElement(selectedCategory).getText();
    }
    @Step("Клик по категории - булки")
    public void clickOnBunCategory() {
        driver.findElement(bunCategory).click();
    }
    @Step("Клик по категории - начинки")
    public void clickOnFillingCategory() {
        driver.findElement(fillingCategory).click();
    }
    @Step("Клик по категории - начинки")
    public void clickOnSaucesCategory() {
        driver.findElement(saucesCategory).click();
    }
}
