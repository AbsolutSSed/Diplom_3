import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.MainPage;
import util.BrowserConfig;

public class ConstructorSectionTest {
    WebDriver driver;

    @Before
    public void setUp() {
        String browser = BrowserConfig.getBrowser();
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
        }
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Проверка перехода к категории - булки")
    public void transitionToBunSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSaucesCategory();
        mainPage.clickOnBunCategory();
        Assert.assertEquals("Булки", mainPage.getTextSelectedCategory());
    }
    @Test
    @DisplayName("Проверка перехода к категории - соусы")
    public void transitionToSaucesSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSaucesCategory();
        Assert.assertEquals("Соусы", mainPage.getTextSelectedCategory());
    }
    @Test
    @DisplayName("Проверка перехода к категории - начинки")
    public void transitionToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnFillingCategory();
        Assert.assertEquals("Начинки", mainPage.getTextSelectedCategory());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
