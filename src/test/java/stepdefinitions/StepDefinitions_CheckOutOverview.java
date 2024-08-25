package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CheckOutOverview;
import webdriver.WebDriverManager;

public class StepDefinitions_CheckOutOverview extends WebDriverManager {

    CheckOutOverview overview = new CheckOutOverview();

    @Then("user should see the order")
    public void user_should_see_the_order() {
         overview.checkOutOverview();
    }

    @When("user click the finish button")
    public void user_click_the_finish_button() {
         overview.finish();
    }

    @Then("complete page should be displayed")
    public void complete_page_should_be_displayed() {
       overview.validateCompletePage();
    }

    @When("user click the cancel button in the page")
    public void user_click_the_cancel_button_in_the_page() {
       overview.cancel();
            }

}
