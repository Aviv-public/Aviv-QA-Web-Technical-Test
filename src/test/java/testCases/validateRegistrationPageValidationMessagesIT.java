package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

import static org.testng.AssertJUnit.assertTrue;

public class validateRegistrationPageValidationMessagesIT extends BaseClass {

    @Test
    public void shouldVerifyFieldValidationMessageOnRegisterPageWithBlankFields_whenUserClickRegisterButton(){

        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on Register Link",homePage.clickRegisterLink());

        RegisterPage registerPage = new RegisterPage(driver);
        assertTrue("unable to click on Register button",registerPage.clickRegisterButton());

        String firstNameIsRequiredExpectedMessage = "First name is required.";
        Assert.assertEquals(registerPage.getFirstNameIsRequiredValidationMessage(),firstNameIsRequiredExpectedMessage,"Unable to verify validation message");

        String lastNameIsRequiredExpectedMessage = "Last name is required.";
        Assert.assertEquals(registerPage.getLastNameIsRequiredValidationMessage(),lastNameIsRequiredExpectedMessage,"Unable to verify validation message");

    }
}
