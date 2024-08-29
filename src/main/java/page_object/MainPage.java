package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private By loginInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    private By bunButton = By.xpath("//span[text()='Булки']");
    private By saucesButton = By.xpath("//span[text()='Соусы']");
    private By fillingButton = By.xpath("//span[text()='Начинки']");

    public void clickOnPersonalAccountButton() {
        WebElement personalAccount = driver.findElement(personalAccountButton);
        personalAccount.click();
    }



}
