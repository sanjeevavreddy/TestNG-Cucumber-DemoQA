package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import steps.FillForm;

import java.io.IOException;


public class FillFormDef {

    FillForm fillForm = new FillForm();

    public FillFormDef(){
    }


    @Given("user launch the url")
    public void userLaunchTheUrl() {
        fillForm.userLaunchTheUrl();
    }

    @Then("user enter First and last name as {string} and {string}")
    public void userEnterFirstAndLastNameAsAnd(String firstName, String LastName) {
        fillForm.userEnterFirstName(firstName);
        fillForm.userEnterName(LastName);
    }

}
