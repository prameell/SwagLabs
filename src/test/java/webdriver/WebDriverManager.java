package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigManager;

import java.time.Duration;

//import static com.selenium.SeleniumMain.ndriver;

public class WebDriverManager {

     static public WebDriver driver;

    public void initBrowser(String browserName) {

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if ("edge".equals(browserName)) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if ("firefox".equals(browserName)) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.get(ConfigManager.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(ConfigManager.getProperty("URL")+" launched");
    }
        public static WebDriver getDriver(){
            return driver;
        }

        public void closeCurrentBrowser(){
            driver.close();
        }

        public void closeAllBrowsers(){
            driver.quit();
        }
    }




