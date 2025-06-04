package steps;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locators;

import java.time.Duration;

public class FillForm {

    Locators locators = new Locators();
    public WebDriver driver(){
        return DriverManager.driver.get();
    }

    public void userEnterFirstName(String firstName) {
        driver().findElement(locators.getLocator("FirstName")).sendKeys(firstName);
    }

    public void userEnterName(String LastName) {
        driver().findElement(locators.getLocator("LastName")).sendKeys(LastName);
    }

    public void userLaunchTheUrl() {
        driver().get("https://demoqa.com/automation-practice-form");
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("sasa")));

    }
}
