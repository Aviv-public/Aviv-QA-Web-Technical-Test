package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    private final By firstNameTxt = By.id("FirstName");
    private final By lastNameTxt = By.id("LastName");
    private final By emailTxt = By.id("Email");
    private final By companyName = By.id("Company");
    private final By passwordTxt = By.id("Password");
    private final By confirmPasswordTxt = By.id("ConfirmPassword");
    private final By buttonRegister = By.id("register-button");
    private final By firstNameIsRequiredValidationMessage = By.id("FirstName-error");
    private final By lastNameIsRequiredValidationMessage = By.id("LastName-error");
    private final By emailIsRequiredValidationMessage = (By.id("Email-error"));

    By passwordIsRequiredValidationMessage = By.id("Password-error");
    By confirmPasswordIsRequiredValidationMessage = By.id("ConfirmPassword-error");



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
    public String getEmailIsRequiredValidationMessage(){
        return getElementText(emailIsRequiredValidationMessage);
    }
    public String getPasswordIsRequiredValidationMessage(){
        return getElementText(passwordIsRequiredValidationMessage);
    }
    public String getConfirmPasswordIsRequiredValidationMessage(){
        return getElementText(confirmPasswordIsRequiredValidationMessage);
    }

}
