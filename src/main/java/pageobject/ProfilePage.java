package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By logOutButton = By.xpath("//button[text()='Выход']");
    private final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    public void waitForOverlayInvisible() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
    }
    public void clickOnLogOutButton() {
        waitForOverlayInvisible();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logOutButton)).click();
    }
    public void clickOnLogo() {
        waitForOverlayInvisible();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logoButton)).click();

    }
    public void clickOnConstructorButton() {
        waitForOverlayInvisible();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(constructorButton)).click();
    }
}
