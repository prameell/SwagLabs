package stepdefinitions;

import io.cucumber.java.en.When;
import pom.CompletePage;
import webdriver.WebDriverManager;

public class StepDefinitions_Complete extends WebDriverManager {

    CompletePage page = new CompletePage();

    @When("user click the back home button")
    public void user_click_the_back_home_button() {
        page.backToHomePage();
    }

}
