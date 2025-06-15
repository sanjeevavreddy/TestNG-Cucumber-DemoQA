package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.CommonFunctions;
import utils.Locators;

public class FillFormPage extends DriverManager {

    WebDriver driver;
    Locators locators = new Locators();
    CommonFunctions commonFunctions = new CommonFunctions();

    public FillFormPage() {
        this.driver = DriverManager.getDriver();
    }

    public void userEnterFirstName(String firstName) {
        commonFunctions.findElement(locators.getLocator("FirstName")).sendKeys(firstName);
    }

    public void userEnterName(String LastName) {
        commonFunctions.findElement(locators.getLocator("LastName")).sendKeys(LastName);
    }

    public void userLaunchTheUrl() {
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
