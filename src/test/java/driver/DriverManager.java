package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<String> browser = new ThreadLocal<>();

    public static void initiateDriver(String browser, String grid) {
        if (grid.isEmpty()) {
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else {
                Assert.fail(browser + " provided is not valid");
            }
        } else {
            if (browser.equals("chrome")) {
                URL gridUrl = null;
                try {
                    gridUrl = new URL(grid);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                ChromeOptions options = new ChromeOptions();
                driver.set(new RemoteWebDriver(gridUrl, options));
            } else if (browser.equals("firefox")) {
                URL gridUrl = null;
                try {
                    gridUrl = new URL(grid);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                FirefoxOptions options = new FirefoxOptions();
                driver.set(new RemoteWebDriver(gridUrl, options));
            } else {
                Assert.fail(browser + " provided is not valid");
            }
        }
        DriverManager.browser.set(browser);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void quitDriver() {
        driver.get().quit();
    }
}
