package pom;

import org.openqa.selenium.support.PageFactory;
import webdriver.WebDriverManager;

public class InitElements {

    public InitElements(){
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }
}
