package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ExtentReporter;

public class CheckOutOverview extends InitElements {

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small']")
    public WebElement backHomeBtn;

    @FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    public WebElement text;


    CommonMethods methods = new CommonMethods();

    public void finish() {
        methods.clickElement(finishBtn);
        ExtentReporter.log(Status.PASS, "finish button clicked");
    }

    public void validateCompletePage() {
        Assert.assertEquals(backHomeBtn.getText(), "Back Home");
        ExtentReporter.log(Status.PASS, "complete page displayed successfully");
    }

    public void cancel() {
        methods.clickElement(cancelBtn);
        ExtentReporter.log(Status.PASS, "cancel button clicked");
    }

    public void checkOutOverview() {
        Assert.assertEquals(text.getText(), "Sauce Labs Backpack");
        ExtentReporter.log(Status.PASS, "User able to see the order");
    }
}
