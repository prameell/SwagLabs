package stepdefinitions;

import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;
import pom.ProductsPage;
import utils.TestData;
import webdriver.WebDriverManager;

import java.io.IOException;

public class StepDefinitions_Product extends WebDriverManager {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.loginPage();
    }

    @When("user apply the filter by price low to high from dropdown")
    public void user_apply_the_filter_by_price_low_to_high_from_dropdown_from_dropdown() throws IOException {
        productsPage.verifyWithFilter();
    }

    @Then("price low to high should be selected and sorted")
    public void price_low_to_high_should_be_selected_and_sorted() {
        productsPage.filtersAppliedAsc();
    }

    @When("user apply the filter by price high to low from dropdown")
    public void user_apply_the_filter_by_price_high_to_low_from_dropdown() {
        productsPage.verifyWithFilterPriceHighToLow();
    }

    @Then("price high to low should be selected and sorted")
    public void price_high_to_low_should_be_selected_and_sorted() {
        productsPage.filtersAppliedDes();
    }

    @Then("user apply the filter by Name Z to A from dropdown")
    public void user_apply_the_filter_by_name_z_to_a_from_dropdown() {
        productsPage.verifyWithFilterZtoA();
    }

    @Then("Name Z to A should be selected and sorted")
    public void name_z_to_a_should_be_selected_and_sorted() {
        productsPage.filtersAppliedZToA();
    }

    @And("user add the product")
    public void userAddTheProduct() {
        productsPage.addProduct();
    }

    @Then("product should be added and cart page is displayed")
    public void product_should_be_added_and_cart_page_is_displayed() {
        productsPage.productAdded();
    }

    @Then("user should see the products displayed using below data {string}")
    public void user_should_see_the_products_displayed_using_below_data(String productsName) {
        productsPage.seeProducts(productsName);
    }

    @Then("user should see the products displayed {string}")
    public void user_should_see_the_products_displayed(String testCaseId) {
        TestData.readTestData(testCaseId);
       productsPage.visibleProducts();
    }


}