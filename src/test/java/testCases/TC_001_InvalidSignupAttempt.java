package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_InvalidSignupAttempt extends BaseClass {

    @Test
    public void verify_invalid_signup(){

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

    }
}
