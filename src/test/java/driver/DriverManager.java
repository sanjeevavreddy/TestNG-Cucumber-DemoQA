package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.time.Duration;

public class DriverManager {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<String> browser = new ThreadLocal<>() ;

    public static void initiateDriver() {
            if (browser.get().equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());

            } else if (browser.get().equals("safari")) {
                driver.set(new SafariDriver());
            }
            else
            {
                Assert.fail(browser.get() + " provided is not valid");
            }
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public static void quitDriver(){
        driver.get().quit();
    }

}
