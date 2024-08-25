package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.CartPage;
import pom.CheckOutPage;
import pom.LoginPage;
import pom.ProductsPage;
import webdriver.WebDriverManager;

import java.io.IOException;

public class StepDefinitions_Cart extends WebDriverManager {

    CheckOutPage outPage = new CheckOutPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @Then("user should see the added product")
    public void user_should_see_the_added_product() {
        cartPage.seeProductInCart();
    }

    @When("user click the continue shopping button")
    public void user_click_the_continue_shopping_button() throws IOException {
        cartPage.continuing();
    }

//    @When("user click the checkout button with empty cart")
//    public void user_click_the_checkout_button_with_empty_cart() {
//        cartPage.checkOutEmpty();
//    }

    @Then("checkoutPage should be displayed")
    public void checkout_page_should_be_displayed() {
        cartPage.validateCheckOut();
    }

    @When("user click the checkout button")
    public void user_click_the_checkout_button() {
        cartPage.checkOut();
    }

    @Then("user click the remove button and cart page should be empty")
    public void user_click_the_remove_button_and_cart_page_should_be_empty(){
        cartPage.remove();
    }

    }
