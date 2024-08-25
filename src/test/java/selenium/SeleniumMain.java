package selenium;

import pom.CheckOutPage;
import pom.LoginPage;
import pom.ProductsPage;
import utils.TestData;
import webdriver.WebDriverManager;

import java.io.IOException;


public class SeleniumMain {

    static String browserName = "chrome";
    static WebDriverManager driverManager = new WebDriverManager();

    public static void main(String[] args) throws IOException {

        driverManager.initBrowser(browserName);

        // LoginPage loginPage = new LoginPage(driverManager.getDriver());   //0ne way --- driver has to be passed
        LoginPage loginPage = new LoginPage(); //2nd way -- creating constructor in one class and can be extends with other pom's, so no need to pass any driver here
        ProductsPage productsPage = new ProductsPage();
        CheckOutPage checkOutPage = new CheckOutPage();
        loginPage.loginToPage();
        loginPage.validateHomePage();
       // productsPage.selectDropDown();
        productsPage.verifyWithFilter();
        productsPage.addProduct();
        TestData.readTestData("TC001");
        checkOutPage.enterCheckOutDetails();


    }
}