package utils;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static webdriver.WebDriverManager.getDriver;

public class CommonMethods {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    public void sendTextToElement(WebElement ele, String value) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.sendKeys(value);
            ExtentReporter.log(Status.INFO, value + " is entered");
            //Hooks.scenario.log(value +" is entered");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, "unable to enter a value " + e.getMessage());
            // Hooks.scenario.log("unable to enter a value "+e.getMessage());
        }
    }

    public void clickElement(WebElement ele) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.click();
            ExtentReporter.log(Status.INFO, ele + "clicked");
            //Hooks.scenario.log(ele+ "clicked");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, "unable to click element " + e.getMessage());
            //Hooks.scenario.log("unable to click element "+e.getMessage());
        }
    }


    /**
     * task
     **/
    public void presenceOfTitle(WebElement ele) {
        try {
            ele.getText();
            if (ele.getText().equals("Sauce Labs Backpack")) {
                //System.out.println(ele + " is validated");
                ExtentReporter.log(Status.PASS, ele + " is validated");
            } else {
                //System.out.println("not matched");
                ExtentReporter.log(Status.FAIL, ele + " is not validated");

            }
        } catch (Exception e) {
            //System.out.println("unable to find the presence of element " + e.getMessage());
            ExtentReporter.log(Status.INFO, "unable to find the element " + e.getMessage());
        }
    }

    public void selectValueFromDropDown(WebElement ele, String value) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ele));
            Select sel = new Select(ele);    //Select is a predefined class from support.ui
            sel.selectByVisibleText(value);
            //Hooks.scenario.log(value+" is selected from dropdown");
            ExtentReporter.log(Status.INFO, value + " is selected from dropdown");
        } catch (Exception e) {
            // Hooks.scenario.log("unable to select "+value+" "+e.getMessage());
            ExtentReporter.log(Status.FAIL, "unable to select " + value + " " + e.getMessage());
        }
    }

    /*Extent Report byte*/
    public static String takeScreenShot() throws IOException {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(ExtentReporter.reportPath + file.getName());
            FileUtils.copyFile(file, destFile);
            return file.getName();
        } catch (Exception e) {
            ExtentReporter.log(Status.INFO, "unable to take screenShot " + e.getMessage());
            return null;
        }
    }

    /*Hooks concept*/
//    public byte [] takeScreenShot() throws IOException {
//        try {
//
//            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
//            byte[] file = screenshot.getScreenshotAs(OutputType.BYTES);
//            return file;
//        }catch(Exception e){
//            Hooks.scenario.log("not getting screenshot "+e.getMessage());
//        }
//        return null;
//    }


//    public void takeScreenShot() throws IOException {
//        try {
//            String targetLoc = System.getProperty("user.dir") + "\\Reports\\";  //System.getProperty directly navigates SeleniumPractice (java project) sec & reports sec
//
//            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
//            File file = screenshot.getScreenshotAs(OutputType.FILE); //get the screenshot as file type and stores in file. paste this file into our location menas target location
//            File destFile = new File(targetLoc + file.getName()); //have to copy from file to destFile to do this we have a FileUtils package but we don't have in java so add dependency apache common.io
//            FileUtils.copyFile(file, destFile);
//            System.out.println("got screenshot");
//        }catch(Exception e){
//            System.out.println("not getting screenshot "+e.getMessage());
//        }
//        return null;
//    }

    public void fluentWait(WebElement e) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver());
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(6))
                .ignoring(NoSuchElementException.class);
        e.click();
    }
//    public static void explicitWait(){
//        WebDriverWait exwait = new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(30));
//        exwait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//    }

}
