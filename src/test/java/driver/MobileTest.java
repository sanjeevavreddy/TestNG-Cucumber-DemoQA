package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MobileTest {
    public static void main(String[] args) throws MalformedURLException {
        String USERNAME = "aveejnasv_5UznbDiG4wq";
        String ACCESS_KEY = "XgW3RWoQ1gMtNY2qwypa";
        String BS_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

        Map<String, Object> browserstackOptions = new HashMap<>();

        browserstackOptions.put("deviceName", "Google Pixel 7");
        browserstackOptions.put("osVersion", "13.0");
        browserstackOptions.put("projectName", "Appium Java Project");
        browserstackOptions.put("buildName", "Build 1");
        browserstackOptions.put("sessionName", "Calculator Test");


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setCapability("bstack:options", browserstackOptions);


        AndroidDriver driver = new AndroidDriver(new URL(BS_URL), options);

        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Play Store']"));

        Actions action = new Actions(driver);
        action.moveToElement(ele);
        action.click().perform();


        driver.quit();
    }
}
