package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    By buttonRegister = By.id("register-button");
    By firstNameIsRequiredValidationMessage = By.id("FirstName-error");
    By lastNameIsRequiredValidationMessage = By.id("LastName-error");


    public boolean clickRegisterButton(){
        return clickElement(buttonRegister);
    }
    public String getFirstNameIsRequiredValidationMessage(){
        return getElementText(firstNameIsRequiredValidationMessage);
    }

    public String getLastNameIsRequiredValidationMessage(){
        return getElementText(lastNameIsRequiredValidationMessage);
    }

}
