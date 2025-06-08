package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import utils.Log;


public class FillFormDef extends BasePage{


    @Given("user launch the url")
    public void userLaunchTheUrl() {
        fillFormPage().userLaunchTheUrl();
    }

    @Then("user enter First and last name as {string} and {string}")
    public void userEnterFirstAndLastNameAsAnd(String firstName, String LastName) {
        Log.info("Entering username and password");
        fillFormPage().userEnterFirstName(firstName);
        fillFormPage().userEnterName(LastName);
    }

}
