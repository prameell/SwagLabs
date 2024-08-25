package pom;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ExtentReporter;
import utils.TestData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends InitElements {

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement filterByDropDown;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> inventoryPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    public List<WebElement> inventoryItems;

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    public WebElement productBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cartLink;
    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    public WebElement productInCart;

    CommonMethods methods = new CommonMethods();

    public void verifyWithFilter() throws IOException {
        methods.selectValueFromDropDown(filterByDropDown, "Price (low to high)");
        ExtentReporter.log(Status.PASS, "filter applied");

    }

    public void verifyWithFilterPriceHighToLow() {
        methods.selectValueFromDropDown(filterByDropDown, "Price (high to low)");
        ExtentReporter.log(Status.PASS, "filter applied");
    }

    public void verifyWithFilterZtoA() {
        methods.selectValueFromDropDown(filterByDropDown, "Name (Z to A)");
        ExtentReporter.log(Status.PASS, "filter applied");
    }


    public void filtersAppliedAsc() {
        List<String> priceDetails = new ArrayList<>();   //to get all values and stores in the list
        for (WebElement ele : inventoryPrice) {
            String e = ele.getText();
            priceDetails.add(e);
        }

        boolean isSorted = true;
        for (int i = 0; i < priceDetails.size() - 1; i++) {
            double currentPrice = Double.parseDouble(priceDetails.get(i).replace("$", ""));
            double nextPrice = Double.parseDouble(priceDetails.get(i + 1).replace("$", ""));
            if (currentPrice > nextPrice) {
                isSorted = false;
                break;
            }
        }
        if (isSorted)
            ExtentReporter.log(Status.PASS, "sorted in ascending order");
        else
            ExtentReporter.log(Status.FAIL, "not sorted in ascending order");
    }

    public void filtersAppliedDes() {
        List<String> priceDetails = new ArrayList<>();   //to get all values and stores in the list
        for (WebElement ele : inventoryPrice) {
            String e = ele.getText();
            priceDetails.add(e);
        }

        boolean isSorted = true;
        for (int i = 0; i < priceDetails.size() - 1; i++) {
            double currentPrice = Double.parseDouble(priceDetails.get(i).replace("$", ""));
            double nextPrice = Double.parseDouble(priceDetails.get(i + 1).replace("$", ""));
            if (nextPrice > currentPrice) {
                isSorted = false;
                break;
            }
        }
        if (isSorted)
            ExtentReporter.log(Status.PASS, "sorted in descending order");
        else
            ExtentReporter.log(Status.FAIL, "not sorted in descending order");
    }


    public void filtersAppliedZToA() {
        List<String> productNameDetails = new ArrayList<>();   //to get all values and stores in the list
        for (WebElement ele : inventoryItems) {
            String e = ele.getText();
            productNameDetails.add(e);
        }

        boolean isSorted = true;
        for (int i = 0; i < productNameDetails.size() - 1; i++) {
            String currentProductName = productNameDetails.get(i);
            String nextProductName = productNameDetails.get(i + 1);
            if (currentProductName.compareTo(nextProductName) < 0) {
                isSorted = false;
                break;
            }
        }
        if (isSorted)
            ExtentReporter.log(Status.PASS, "sorted in Z to A order");
        else
            ExtentReporter.log(Status.FAIL, "not sorted in Z to A order");
    }

    public void addProduct() {
        methods.clickElement(productBtn);
        ExtentReporter.log(Status.PASS, "product added");
    }

    public void productAdded() {
        methods.clickElement(cartLink);
        Assert.assertEquals(productInCart.getText(), "Sauce Labs Backpack");
        ExtentReporter.log(Status.PASS, "product added and cart page is displayed");
    }

    public void seeProducts(String productNames) {
        Assert.assertTrue(productNames.contains("Sauce Labs Backpack") ||
                productNames.contains("Sauce Labs Bike Light") ||
                productNames.contains("Sauce Labs Bolt T-Shirt") ||
                productNames.contains("Sauce Labs Fleece Jacket") ||
                productNames.contains("Sauce Labs Onesie") ||
                productNames.contains("Test.allTheThings() T-Shirt (Red)"));
        ExtentReporter.log(Status.PASS, "user should be able to see all products");
    }

public void visibleProducts(){
    String a = TestData.getData("ProductNames");
    Assert.assertTrue(a.contains ("Sauce Labs Backpack") ||
            a.contains("Sauce Labs Bike Light") ||
            a.contains("Sauce Labs Bolt T-Shirt") ||
            a.contains("Sauce Labs Fleece Jacket") ||
            a.contains("Sauce Labs Onesie") ||
            a.contains("Test.allTheThings() T-Shirt (Red)"));
    ExtentReporter.log(Status.PASS, "user should be able to see products");
}

}




