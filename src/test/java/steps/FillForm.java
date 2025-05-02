package steps;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Locators;

public class FillForm {

    WebDriver driver = DriverManager.driver.get();
    Locators locators = new Locators();

    public void userEnterFirstName(String firstName) {
        driver.findElement(locators.getLocator("FirstName")).sendKeys(firstName);
    }

    public void userEnterName(String LastName) {
        driver.findElement(locators.getLocator("LastName")).sendKeys(LastName);
    }

    public void userLaunchTheUrl() {
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
