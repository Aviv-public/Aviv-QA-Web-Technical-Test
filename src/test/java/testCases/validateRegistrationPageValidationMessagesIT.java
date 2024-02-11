package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

import static org.testng.AssertJUnit.assertTrue;

public class validateRegistrationPageValidationMessagesIT extends BaseClass {

    @Test
    public void shouldVerifyFieldValidationMessageOnRegisterPageWithBlankFields_whenUserClickRegisterButton(){

        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on 'Register' Link",homePage.clickRegisterLink());

        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("unable to click on 'Register' button", registrationPage.clickRegisterButton());

        String firstNameIsRequiredExpectedMessage = "First name is required.";
        Assert.assertEquals(registrationPage.getFirstNameIsRequiredValidationMessage(),firstNameIsRequiredExpectedMessage,"Unable to verify validation message");

        String lastNameIsRequiredExpectedMessage = "Last name is required.";
        Assert.assertEquals(registrationPage.getLastNameIsRequiredValidationMessage(),lastNameIsRequiredExpectedMessage,"Unable to verify validation message");

    }
}
