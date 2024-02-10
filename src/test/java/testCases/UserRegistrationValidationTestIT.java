package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.RegisterResultPage;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class UserRegistrationValidationTestIT extends BaseClass {

    @Test
    public void shouldVerifyUserRegistration_whenUserClickRegisterButton(){
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on Register Link",homePage.clickRegisterLink());

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.sendKeysToFirstName(RandomDataGenerator.randomString());
        registerPage.sendKeysToLastName(RandomDataGenerator.randomString());
        registerPage.sendKeysToEmail(RandomDataGenerator.randomAlphaNumeric()+".com");
        registerPage.sendKeysToCompanyName();
        String password = RandomDataGenerator.randomString();
        registerPage.sendKeysToPassword(password);
        registerPage.sendKeysToConfirmPassword(password);
        registerPage.clickRegisterButton();

        RegisterResultPage registerResultPage = new RegisterResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registerResultPage.getRegisterResultText(),registerResulExpectedMessage,"Unable to verify Register Result message");
            }

}
