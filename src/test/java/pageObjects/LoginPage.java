package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailTxt = By.id("Email");
    By passwordTxt = By.id("Password");
    By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public boolean sendKeysToEmail(String email){
        return sendKeysToElement(emailTxt,email);
    }
    public boolean sendKeysToPassword(String password){
        return sendKeysToElement(passwordTxt,password);
    }
    public boolean clickLoginButton(){
        return clickElement(loginButton);
    }
}
