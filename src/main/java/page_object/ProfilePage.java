package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By logOutButton = By.xpath("//*/li[3]/button[text()='Выход']");
    private By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    public boolean isLogOutButtonVisible() {
        WebElement button = driver.findElement(logOutButton);
        return button.isDisplayed();
    }
}
