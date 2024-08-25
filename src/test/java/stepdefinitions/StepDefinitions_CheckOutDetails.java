package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CartPage;
import pom.CheckOutOverview;
import pom.CheckOutPage;
import utils.TestData;
import webdriver.WebDriverManager;

import java.io.IOException;

public class StepDefinitions_CheckOutDetails extends WebDriverManager {

    CheckOutPage checkOutPage = new CheckOutPage();
    CheckOutOverview overview = new CheckOutOverview();

    @When("user enters valid details {string}")
    public void user_enters_valid_details(String testCaseID) throws IOException {
        TestData.readTestData(testCaseID);
        checkOutPage.enterCheckOutDetails();
    }

    @When("user click the continue button")
    public void user_click_the_continue_button() {
        checkOutPage.checkOutContinue();
    }

    @Then("checkout overview page should be displayed")
    public void checkout_overview_page_should_be_displayed() {
        checkOutPage.validateCheckOutOverview();
    }

    @When("user click the cancel button")
    public void user_click_the_cancel_button() {
           checkOutPage.cancel();
    }

    @Then("your cart page should be displayed")
    public void your_cart_page_should_be_displayed() {
           checkOutPage.backToCart();
    }
}
