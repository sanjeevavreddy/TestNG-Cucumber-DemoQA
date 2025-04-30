package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillFormDef {
    public WebDriver driver = DriverManager.driver.get();

    @Then("user enter First and last name as {string} and {string}")
    public void userEnterFirstAndLastNameAsAnd(String firstName, String LastName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(LastName);
    }

    @Given("user launch the url")
    public void userLaunchTheUrl() {
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
