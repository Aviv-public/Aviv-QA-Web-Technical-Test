package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
