package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.RegisterResultPage;
import testBase.BaseClass;

import static org.testng.AssertJUnit.assertTrue;

public class UserRegistrationValidationTestIT extends BaseClass {

    @Test
    public void shouldVerifyUserRegistration_whenUserClickRegisterButton(){
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on Register Link",homePage.clickRegisterLink());

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.sendKeysToFirstName();
        registerPage.sendKeysToLastName();
        registerPage.sendKeysToEmail();
        registerPage.sendKeysToCompanyName();
        registerPage.sendKeysToPassword();
        registerPage.sendKeysToConfirmPassword();
        registerPage.clickRegisterButton();

        RegisterResultPage registerResultPage = new RegisterResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registerResultPage.getRegisterResultText(),registerResulExpectedMessage,"Unable to verify Register Result message");
            }

}
