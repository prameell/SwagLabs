package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ConfigManager;
import utils.ExtentReporter;
import utils.TestData;

import java.io.IOException;

public class LoginPage extends InitElements {

    @FindBy(id = "user-name")
    public WebElement userNameTxt;
    @FindBy(name = "password")
    public WebElement passwordTxt;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    public WebElement inventoryItem;

    CommonMethods methods = new CommonMethods();

    /** Config **/
    public void loginPage(){
        methods.sendTextToElement(userNameTxt, ConfigManager.getProperty("USERNAME"));
        methods.sendTextToElement(passwordTxt, ConfigManager.getProperty("PASSWORD"));
        methods.clickElement(loginBtn); }

   /** TestData **/
    public void loginToPage() {
        methods.sendTextToElement(userNameTxt, TestData.getData("UserName"));
        methods.sendTextToElement(passwordTxt, TestData.getData("Password"));
        methods.clickElement(loginBtn);
    }

    /** without TestData **/
    public void loginP(String user, String pwd){
        methods.sendTextToElement(userNameTxt, user);
        methods.sendTextToElement(passwordTxt, pwd);
        methods.clickElement(loginBtn);
    }

    public void validateHomePage() throws IOException {
        Assert.assertEquals(inventoryItem.getText(), "Sauce Labs Backpack");
        ExtentReporter.log(Status.PASS, "homepage should be displayed");
    }

}


