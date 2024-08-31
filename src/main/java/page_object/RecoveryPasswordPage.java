package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private WebDriver driver;
    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By logInButton = By.xpath("//*/div/p/a[text()='Войти']");

    @Step("Нажать кнопку - войти")
    public void clickOnLogInButton() {
        driver.findElement(logInButton).click();
    }

}
