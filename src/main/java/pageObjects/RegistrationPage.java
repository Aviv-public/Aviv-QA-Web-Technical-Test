package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    private final By REGISTRATION_PAGE_TITLE = By.xpath("//h1[normalize-space()='Register']");
    private final By FIRST_NAME_TEXT_BOX = By.id("FirstName");
    private final By LAST_NAME_TEXT_BOX = By.id("LastName");
    private final By EMAIL_TEXT_BOX = By.id("Email");
    private final By COMPANY_NAME_TEXT_BOX = By.id("Company");
    private final By PASSWORD_TEXT_BOX = By.id("Password");
    private final By CONFIRM_PASSWORD_TEXT_BOX = By.id("ConfirmPassword");
    private final By REGISTER_BUTTON = By.id("register-button");
    private final By FIRST_NAME_IS_REQUIRED_VALIDATION_MESSAGE = By.id("FirstName-error");
    private final By LAST_NAME_IS_REQUIRED_VALIDATION_MESSAGE = By.id("LastName-error");
    private final By EMAIL_IS_REQUIRED_VALIDATION_MESSAGE = (By.id("Email-error"));
    private final By PASSWORD_IS_REQUIRED_VALIDATION_MESSAGE = By.id("Password-error");
    private final By CONFIRM_PASSWORD_IS_REQUIRED_VALIDATION_MESSAGE = By.id("ConfirmPassword-error");

    public boolean confirmRegistrationPageTitleIsVisible(){
        return confirmElementIsVisible(REGISTRATION_PAGE_TITLE);
    }
    public boolean sendKeysToFirstName(String firstName){
        return sendKeysToElement(FIRST_NAME_TEXT_BOX, firstName);
    }
    public boolean sendKeysToLastName(String lastName){
        return sendKeysToElement(LAST_NAME_TEXT_BOX, lastName);
    }
    public boolean sendKeysToEmail(String email){
        return sendKeysToElement(EMAIL_TEXT_BOX, email);
    }
    public boolean sendKeysToCompanyName(){
        return sendKeysToElement(COMPANY_NAME_TEXT_BOX, "Test Company");
    }
    public boolean sendKeysToPassword(String password){
        return sendKeysToElement(PASSWORD_TEXT_BOX, password);
    }
    public boolean sendKeysToConfirmPassword(String confirmPassword){
        return sendKeysToElement(CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
    }
    public boolean clickRegisterButton(){
        return clickElement(REGISTER_BUTTON);
    }
    public String getFirstNameIsRequiredValidationMessage(){
        return getElementText(FIRST_NAME_IS_REQUIRED_VALIDATION_MESSAGE);
    }

    public String getLastNameIsRequiredValidationMessage(){
        return getElementText(LAST_NAME_IS_REQUIRED_VALIDATION_MESSAGE);
    }
    public String getEmailIsRequiredValidationMessage(){
        return getElementText(EMAIL_IS_REQUIRED_VALIDATION_MESSAGE);
    }
    public String getPasswordIsRequiredValidationMessage(){
        return getElementText(PASSWORD_IS_REQUIRED_VALIDATION_MESSAGE);
    }
    public String getConfirmPasswordIsRequiredValidationMessage(){
        return getElementText(CONFIRM_PASSWORD_IS_REQUIRED_VALIDATION_MESSAGE);
    }

}
