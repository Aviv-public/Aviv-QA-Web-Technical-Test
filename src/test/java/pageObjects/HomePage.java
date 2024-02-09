package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    By linkRegister = By.xpath("//a[normalize-space()='Register']");


    public boolean clickRegisterLink(){
        return clickElement(linkRegister);
    }
}
