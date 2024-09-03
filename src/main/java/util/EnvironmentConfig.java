package util;
public class EnvironmentConfig {
    private static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    public String getMainPageUrl() {
        return MAIN_PAGE;
    }
    public String getLoginPageUrl() {
        return LOGIN_PAGE;
    }
}