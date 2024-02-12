package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class verifyRegistrationPageValidationMessagesIT extends BaseClass {

    @Test
    public void shouldVerifyFieldValidationMessageOnRegistrationPageWithBlankFields_whenUserClickRegisterButton() {

        HomePage homePage = new HomePage(driver);
        assertTrue("unable to confirm 'nopCommerce' logo",homePage.confirmNopCommerceLogoIsVisible());
        assertTrue("unable to click on 'Register' Link", homePage.clickRegisterLink());

        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("unable to confirm 'Register' page title",registrationPage.confirmRegistrationPageTitleIsVisible());
        assertTrue("unable to click on 'REGISTER' button", registrationPage.clickRegisterButton());

        String firstNameIsRequiredExpectedMessage = "First name is required.";
        Assert.assertEquals(registrationPage.getFirstNameIsRequiredValidationMessage(), firstNameIsRequiredExpectedMessage, "Unable to verify 'First name:' validation message");

        String lastNameIsRequiredExpectedMessage = "Last name is required.";
        Assert.assertEquals(registrationPage.getLastNameIsRequiredValidationMessage(), lastNameIsRequiredExpectedMessage, "Unable to verify 'Last name:' validation message");

        String emailIsRequiredExpectedMessage = "Email is required.";
        Assert.assertEquals(registrationPage.getEmailIsRequiredValidationMessage(),emailIsRequiredExpectedMessage,"Unable to verify 'Email:' validation message");

        String passwordIsRequiredExpectedMessage = "Password is required.";
        Assert.assertEquals(registrationPage.getPasswordIsRequiredValidationMessage(),passwordIsRequiredExpectedMessage,"Unable to verify 'Password:' validation message");
        Assert.assertEquals(registrationPage.getConfirmPasswordIsRequiredValidationMessage(),passwordIsRequiredExpectedMessage,"Unable to verify 'Confirm password:' validation message");
    }

    @Test
    public void shouldVerifyPasswordFieldValidationMessageOnRegistrationPage_whenUserMismatchedPassword() {

        HomePage homePage = new HomePage(driver);
        assertTrue("unable to confirm 'nopCommerce' logo",homePage.confirmNopCommerceLogoIsVisible());
        assertTrue("unable to click on 'Register' Link", homePage.clickRegisterLink());

        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("unable to confirm 'Register' page title",registrationPage.confirmRegistrationPageTitleIsVisible());
        assertTrue("unable to enter text in 'First Name:' field", registrationPage.sendKeysToFirstName(RandomDataGenerator.randomFirstName()));
        assertTrue("unable to enter text in 'Last Name:' field", registrationPage.sendKeysToLastName(RandomDataGenerator.randomLastName()));
        String email = RandomDataGenerator.randomEmail();
        assertTrue("unable to enter text in 'Email:' field", registrationPage.sendKeysToEmail(email));
        assertTrue("unable to enter text in 'Company Name:' field", registrationPage.sendKeysToCompanyName());

        assertTrue("unable to enter text in 'Password:' field", registrationPage.sendKeysToPassword(RandomDataGenerator.randomPassword()));
        assertTrue("unable to enter text in 'Confirm Password:' field", registrationPage.sendKeysToConfirmPassword(RandomDataGenerator.randomPassword()));

        assertTrue("unable to click on 'REGISTER' button", registrationPage.clickRegisterButton());

        String passwordExpectedMessage = "The password and confirmation password do not match.";
        Assert.assertEquals(registrationPage.getConfirmPasswordIsRequiredValidationMessage(), passwordExpectedMessage,"Unable to verify 'Confirm password:' validation message");
    }
}
