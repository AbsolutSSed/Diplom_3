package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By logOutButton = By.xpath("//button[text()='Выход']");
    private By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
}
