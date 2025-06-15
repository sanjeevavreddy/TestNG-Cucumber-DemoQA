package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;


public class FillFormDef extends BasePage {


    @Given("user launch the url")
    public void userLaunchTheUrl() {
        fillFormPage().userLaunchTheUrl();
    }

    @Then("user enter First and last name as {string} and {string}")
    public void userEnterFirstAndLastNameAsAnd(String firstName, String LastName) {
        fillFormPage().userEnterFirstName(firstName);
        fillFormPage().userEnterName(LastName);
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("user should see the success message")
    public void user_should_see_the_success_message() {
        // Write code here that turns the phrase above into concrete actions
    }

}
