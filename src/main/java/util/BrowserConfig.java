package util;

public class BrowserConfig {
    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }
}
