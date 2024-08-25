package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonMethods;
import utils.ExtentReporter;

public class CompletePage extends InitElements {

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small']")
    public WebElement backHomeBtn;

    CommonMethods methods = new CommonMethods();

    public void backToHomePage() {
        methods.clickElement(backHomeBtn);
        ExtentReporter.log(Status.PASS, "redirect to homepage or products page");
    }
}
