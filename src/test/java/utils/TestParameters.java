package utils;

public class TestParameters {
    private static ThreadLocal<String> browser = new ThreadLocal<>();
    private static ThreadLocal<String> gridURL = new ThreadLocal<>();

    public static void setBrowser(String browserName) {
        browser.set(browserName);
    }

    public static String getBrowser() {
        return browser.get();
    }

    public static void removeBrowser() {
        browser.remove();
    }

    public static void setGridURL(String browserName) {
        gridURL.set(browserName);
    }

    public static String getGridURL() {
        return gridURL.get();
    }

    public static void removeGridURL() {
        gridURL.remove();
    }

}