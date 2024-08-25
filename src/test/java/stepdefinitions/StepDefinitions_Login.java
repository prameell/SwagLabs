package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import org.testng.Assert;
import io.cucumber.java.en.When;
import pom.LoginPage;
import utils.TestData;
import webdriver.WebDriverManager;

import java.io.IOException;

public class StepDefinitions_Login extends WebDriverManager {

    LoginPage loginPage = new LoginPage();

    @When("user enters valid credentials {string}")
    public void user_enters_valid_credentials(String testCaseID) {
        TestData.readTestData(testCaseID);
        loginPage.loginToPage();
    }

    @Then("products page should be displayed")
    public void products_page_should_be_displayed() throws IOException {
        loginPage.validateHomePage();
    }

    @When("user enters valid credentials {string} and {string}")
    public void user_enters_valid_credentials_and(String userName, String password) {
        loginPage.loginP(userName, password);
    }


//    @Given("user launch the application")
//    public void user_launch_the_application() {
//        driverManager.initBrowser(browserName);
//           }
//
//    @When("user enters valid credentials {string}")
//    public void user_enters_valid_credentials(String testCaseID) {
//        TestData.readTestData(testCaseID);
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToPage();
//    }
//
////    @When("user enters valid credentials")
////    public void user_enters_valid_credentials() {
////        LoginPage loginPage = new LoginPage();
////        loginPage.loginToPage();
////    }
//
//    @Then("homepage should be displayed")
//    public void homepage_should_be_displayed() throws IOException {
//        LoginPage loginPage =  new LoginPage();
//        loginPage.validateHomePage();
//       WebDriverManager.getDriver().close();
//    }
//


}
