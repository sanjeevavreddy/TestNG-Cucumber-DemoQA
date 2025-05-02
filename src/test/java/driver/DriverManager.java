package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.time.Duration;

public class DriverManager {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<String> browser = new ThreadLocal<>();

    public static void initiateDriver(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        } else if (browser.equals("safari")) {
            driver.set(new SafariDriver());
        } else {
            Assert.fail(browser + " provided is not valid");
        }
        DriverManager.browser.set(browser);

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void quitDriver() {
        driver.get().quit();
    }
}
