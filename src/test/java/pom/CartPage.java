package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ExtentReporter;

import java.util.List;

public class CartPage extends InitElements {

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    public WebElement productInCart;
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public WebElement removeBtn;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkOutBtn;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement title;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    public WebElement continueBtn;

    CommonMethods methods = new CommonMethods();

    public void seeProductInCart() {
        Assert.assertEquals(productInCart.getText(), "Sauce Labs Backpack");
        ExtentReporter.log(Status.PASS, "added product is in the cart");
    }

    public void continuing() {
        methods.clickElement(continueBtn);
    }

    public void checkOut() {
        methods.clickElement(checkOutBtn);
        ExtentReporter.log(Status.PASS, "checkout with product");
    }

    public void validateCheckOut() {
        Assert.assertEquals(title.getText(), "Checkout: Your Information");
        ExtentReporter.log(Status.PASS, "checkout page displayed");
    }

    public void remove() {
        methods.clickElement(removeBtn);
        ExtentReporter.log(Status.PASS, "cart page is empty now");
    }


}
