package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\main\\resources\\TestCases",
        glue = "stepdefinitions",
        tags = "@regression",
        plugin = {"pretty", "html:target\\Report\\report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

