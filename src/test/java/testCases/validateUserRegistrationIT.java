package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.RegisterResultPage;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class validateUserRegistrationIT extends BaseClass {

    @Test
    public void shouldVerifyUserRegistration_whenUserClickRegisterButton(){
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on Register Link",homePage.clickRegisterLink());

        RegisterPage registerPage = new RegisterPage(driver);
        assertTrue("Unable to enter test in 'First Name' field",registerPage.sendKeysToFirstName(RandomDataGenerator.randomString()));
        assertTrue("Unable to enter test in 'Last Name' field",registerPage.sendKeysToLastName(RandomDataGenerator.randomString()));
        assertTrue("Unable to enter test in 'Email' field",registerPage.sendKeysToEmail(RandomDataGenerator.randomAlphaNumeric()+".com"));
        assertTrue("Unable to enter test in 'Company Name' field",registerPage.sendKeysToCompanyName());
        String password = RandomDataGenerator.randomString();
        assertTrue("Unable to enter test in 'Password' field", registerPage.sendKeysToPassword(password));
        assertTrue("Unable to enter test in 'Confirm Password' field",registerPage.sendKeysToConfirmPassword(password));
        assertTrue("Unable to click on 'Register' button",registerPage.clickRegisterButton());

        RegisterResultPage registerResultPage = new RegisterResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registerResultPage.getRegisterResultText(),registerResulExpectedMessage,"Unable to verify Register Result message");

    }
}
