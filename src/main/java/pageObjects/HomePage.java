package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    By linkRegister = By.xpath("//a[normalize-space()='Register']");

    By linkLogin = By.linkText("Log in");
    By searchTxt = By.id("small-searchterms");
    By firstElement = By.xpath("(//li[@class='ui-menu-item'])[1]");




    public boolean clickRegisterLink(){
        return clickElement(linkRegister);
    }

    public boolean clickLoginLink(){
        return clickElement(linkLogin);
    }
    public boolean clickSearchBox(String laptop){
        return sendKeysToElement(searchTxt,laptop);
    }
    public boolean clickFirstElement(){
        return clickElement(firstElement);
    }
}
