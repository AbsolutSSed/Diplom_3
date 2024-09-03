import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;
import util.TestUtilities;

public class ConstructorSectionTest {
    WebDriver driver;
    TestUtilities testUtilities = new TestUtilities();

    @Before
    public void setUp() {
        driver = testUtilities.actionsBeforeTest();
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
        //Тут не требуется вызов методов класса TestUtilities
        driver.quit();
    }
}
