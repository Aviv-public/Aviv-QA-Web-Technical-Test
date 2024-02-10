package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By companyName = By.id("companyName");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");

    By buttonRegister = By.id("register-button");
    By firstNameIsRequiredValidationMessage = By.id("FirstName-error");
    By lastNameIsRequiredValidationMessage = By.id("LastName-error");


    public boolean sendKeysToFirstName(){
        return sendKeysToElement(firstName, "Test");
    }
    public boolean sendKeysToLastName(){
        return sendKeysToElement(lastName, "User");
    }
    public boolean sendKeysToEmail(){
        return sendKeysToElement(email, "Test3@User.com");
    }
    public boolean sendKeysToCompanyName(){
        return sendKeysToElement(companyName, "Test Company");
    }
    public boolean sendKeysToPassword(){
        return sendKeysToElement(password, "Test1234");
    }
    public boolean sendKeysToConfirmPassword(){
        return sendKeysToElement(confirmPassword, "Test1234");
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
