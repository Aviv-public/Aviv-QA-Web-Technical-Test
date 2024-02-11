package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    By firstNameTxt = By.id("FirstName");
    By lastNameTxt = By.id("LastName");
    By emailTxt = By.id("Email");
    By companyName = By.id("Company");
    By passwordTxt = By.id("Password");
    By confirmPasswordTxt = By.id("ConfirmPassword");

    By buttonRegister = By.id("register-button");
    By firstNameIsRequiredValidationMessage = By.id("FirstName-error");
    By lastNameIsRequiredValidationMessage = By.id("LastName-error");


    public boolean sendKeysToFirstName(String firstName){
        return sendKeysToElement(firstNameTxt, firstName);
    }
    public boolean sendKeysToLastName(String lastName){
        return sendKeysToElement(lastNameTxt, lastName);
    }
    public boolean sendKeysToEmail(String email){
        return sendKeysToElement(emailTxt, email);
    }
    public boolean sendKeysToCompanyName(){
        return sendKeysToElement(companyName, "Test Company");
    }
    public boolean sendKeysToPassword(String password){
        return sendKeysToElement(passwordTxt, password);
    }
    public boolean sendKeysToConfirmPassword(String confirmPassword){
        return sendKeysToElement(confirmPasswordTxt, confirmPassword);
    }
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
