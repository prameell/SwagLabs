package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ExtentReporter;
import utils.TestData;

import java.io.IOException;

public class CheckOutPage extends InitElements {

    @FindBy(id = "first-name")
    public WebElement firstName;
    @FindBy(id = "last-name")
    public WebElement lastName;
    @FindBy(id = "postal-code")
    public WebElement postalCode;
    @FindBy(id = "checkout")
    public WebElement checkOutBtn;
    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    public WebElement text;

    @FindBy(id = "cancel")
    public WebElement cancelBtn;

    @FindBy(className = "title")
    public WebElement titleInCartPage;

    CommonMethods methods = new CommonMethods();

    public void enterCheckOutDetails() throws IOException {
        //methods.clickElement(checkOutBtn);
        methods.sendTextToElement(firstName, TestData.getData("FirstName"));          //get values from external source
        methods.sendTextToElement(lastName, TestData.getData("LastName"));
        methods.sendTextToElement(postalCode, TestData.getData("PostalCode"));
        //methods.clickElement(continueBtn);
        // ExtentReporter.log(Status.PASS, "checkout is completed");
        //methods.takeScreenShot();
    }

    public void checkOutContinue() {
        methods.clickElement(continueBtn);
        ExtentReporter.log(Status.PASS, "checkout is completed");
    }

    public void validateCheckOutOverview() {
        Assert.assertEquals(text.getText(), "Sauce Labs Backpack");
        ExtentReporter.log(Status.PASS, "CheckOverview page displayed");
    }

    public void cancel() {
        methods.clickElement(cancelBtn);
    }

    public void backToCart() {
        Assert.assertEquals(titleInCartPage.getText(), "Your Cart");
        ExtentReporter.log(Status.PASS, "back to cart page");
    }
}

