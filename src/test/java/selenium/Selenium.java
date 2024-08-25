package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Selenium {

    //    static WebDriver driver;
//     static String browserName = "firefox";
//
    public static void main(String[] args) throws InterruptedException {
//
//        if("chrome".equals(browserName)){
//            driver= new ChromeDriver();
//            driver.get("https://www.saucedemo.com/");
//        }
//
//        else if("edge".equals(browserName)){
//            driver= new EdgeDriver();
//            driver.get("https://www.saucedemo.com/");
//        }
//
//        else if("firefox".equals(browserName)){
//            driver= new FirefoxDriver();
//            driver.get("https://www.saucedemo.com/");
//        }

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        //   chromeDriver.get("https://thinking-tester-contact-list.herokuapp.com/");
//       chromeDriver.findElement(By.id("email")).sendKeys("chukki2024@gmail.com");
//        chromeDriver.findElement(By.id("password")).sendKeys("Cheshvika@21");
//      chromeDriver.findElement(By.id("submit")).click();
//      Thread.sleep(2000);
//      // chromeDriver.findElement(By.id("signup")).click();
//      //  chromeDriver.findElement(By.className("logout")).click();----------
//       //chromeDriver.findElement(By.linkText("Add a New Contact")).click();
//        //chromeDriver.findElement(By.partialLinkText("Contact")).click();
//        chromeDriver.findElement(By.xpath("//button[@id='add-contact']")).click();

        chromeDriver.get("https://www.saucedemo.com/");
        chromeDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        chromeDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        chromeDriver.findElement(By.id("login-button")).click();
        //chromeDriver.findElement(By.linkText("Sauce Labs Backpack")).click();
        //Thread.sleep(3000);
        //chromeDriver.findElement(By.partialLinkText("Sauce")).click(); //if multiples are there then 1st one will be printed from the order
        //chromeDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();// Absolute XPath
        //chromeDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();  //Partial direct xpath
        //chromeDriver.findElement(By.xpath("//a[@id='item_4_title_link']/ancestor::div[@class='inventory_item_description']/div[@class='pricebar']/child::button")).click(); //Partial dynamic xpath
        //chromeDriver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click(); //partial dynamic xpath by using text method
        // chromeDriver.findElement(By.xpath(" ")).click(); //partial dynamic xpath by using contains method

        //  Select sel = new Select(chromeDriver.findElement(By.xpath("//select[@class='product_sort_container']")));
        //sel.selectByIndex(3);
        //sel.selectByValue("lohi");
        //sel.selectByVisibleText("Price (low to high)");

        //If other than select any html tag used we can use findElements
//      List<WebElement> dropDown =chromeDriver.findElements(By.xpath("//select[@class='product_sort_container']/option")); // webelement is a returntype for findElement
//      for(WebElement ele: dropDown){
//          if(ele.getText().equals("Price (high to low)")){
//              ele.click();
//
//          }
//      }

        //  chromeDriver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
//        chromeDriver.findElement(By.xpath("//button[text()='Add to cart'][1]")).click(); // it is also working here but to check match in th inspect we have to put (//button....) and this is same as above
        //chromeDriver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();


        /* validating the exact selected item added in the cart */
        // String expectedResult = chromeDriver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).getText(); //parent to child
//        String expectedResult = chromeDriver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText(); // directly, above line and this line is same
//     if(expectedResult.equals("Sauce Labs Backpack"))
//         System.out.println("pass");
//     else System.out.println("fail");

        /* task -- validating the 4 items added in the cart with findElements method */


        List<WebElement> e = chromeDriver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        int a = 0; // a=1, then we have put 5 in if block
        for (WebElement b : e) {
            b.click();
            a++;
            if (a == 4)
                break;
        }
        if(a==4) System.out.println("4 times are clicked i.e,, add to cart button clicked");

        chromeDriver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();


        List<WebElement> v = chromeDriver.findElements(By.xpath("//div[@class='cart_item']"));
        int b = 0;

        for (WebElement t : v) {
            String s = t.getText();

            if (s.contains("Sauce Labs Backpack") || s.contains("Sauce Labs Bike Light") ||
                    s.contains("Sauce Labs Bolt T-Shirt") || s.contains("Sauce Labs Fleece Jacket"))
                b++;

            if (b == 4)
                break;

        }

        if (b == 4)
            System.out.println("4 items are available in the cart");
        else
            System.out.println("4 items are not added in the cart");

//        List<WebElement> v = chromeDriver.findElements(By.xpath("//div[@class='cart_item']"));
//        int b = 0;
//
//        for (WebElement t : v) {
//            String s = t.getText();

//            if (s.equals("Sauce Labs Backpack") || s.equals("Sauce Labs Bike Light") ||
//                    s.equals("Sauce Labs Bolt T-Shirt") || s.equals("Sauce Labs Fleece Jacket"))
//                b++;

//            if (b == 4)
//                break;
//        }
//        if (b == 4)
//            System.out.println("4 items are available in the cart");
//         else
//            System.out.println("4 items are not added in the cart");
//

    }
}


