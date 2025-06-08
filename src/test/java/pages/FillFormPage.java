package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.Locators;

public class FillFormPage {

    Locators locators = new Locators();
    private WebDriver driver;

    public FillFormPage() {
        this.driver = DriverManager.getDriver();

    }

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
