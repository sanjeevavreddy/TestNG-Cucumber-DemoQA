package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<String> browser = new ThreadLocal<>();

    public static void initiateDriver(String browser, String gridURL) {
        if (gridURL.isEmpty()) {
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
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
            } else if (browser.equalsIgnoreCase("firefox")) {
                capabilities.setBrowserName("firefox");
            } else {
                Assert.fail(browser + " provided is not valid");
            }
            URL gridUrl;
            try {
                gridUrl = new URL(gridURL);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.set(new RemoteWebDriver(gridUrl, capabilities));
        }
        DriverManager.browser.set(browser);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void quitDriver() {
        driver.get().quit();
    }
}
