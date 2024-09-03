package util;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import user.User;
import user.manager.UserManager;

public class TestUtilities {
    WebDriver driver;
    UserManager userManager = new UserManager();
    EnvironmentConfig environmentConfig = new EnvironmentConfig();

    public WebDriver actionsBeforeTest() {
        String browser = BrowserConfig.getBrowser();
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
        }
        driver.get(environmentConfig.getMainPageUrl());
        return driver;
    }

    public void actionsAfterTest(User user) {
        String accessToken = userManager.userLoginAndExtractToken(user);
        userManager.deleteUser(accessToken);
        driver.quit();
    }
}