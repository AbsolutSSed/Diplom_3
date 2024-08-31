package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By logOutButton = By.xpath("//*/li[3]/button[text()='Выход']");
    private By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    public void clickOnLogOutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        driver.findElement(logOutButton).click();
    }
    public void clickOnLogo() {
        driver.findElement(logoButton).click();
    }
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}
