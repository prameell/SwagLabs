package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;
import utils.ExtentReporter;
import webdriver.WebDriverManager;

import java.io.IOException;

public class Hooks {

    public static Scenario scenario;
    CommonMethods methods = new CommonMethods();
    WebDriverManager driverManager = new WebDriverManager();

    @Before
    public void initSce(Scenario sce) {
        driverManager.initBrowser("chrome");
        Hooks.scenario = sce;
        ExtentReporter.initReport();
        ExtentReporter.initTest(sce.getName());
    }

    @After
    public void tearDown(Scenario s) throws IOException {
        if (s.isFailed()) {
            s.attach(CommonMethods.takeScreenShot(), "image/png", Hooks.scenario.getName());
        }
         ExtentReporter.endReport();
        WebDriverManager.getDriver().close();
    }
}
