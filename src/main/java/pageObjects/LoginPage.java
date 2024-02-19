package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By EMAIL_TEXT_BOX = By.id("Email");
    private final By PASSWORD_TEXT_BOX = By.id("Password");
    private final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Log in']");

    public boolean sendKeysToEmail(String email){
        return sendKeysToElement(EMAIL_TEXT_BOX,email);
    }
    public boolean sendKeysToPassword(String password){
        return sendKeysToElement(PASSWORD_TEXT_BOX,password);
    }
    public boolean clickLoginButton(){
        return clickElement(LOGIN_BUTTON);
    }
}
