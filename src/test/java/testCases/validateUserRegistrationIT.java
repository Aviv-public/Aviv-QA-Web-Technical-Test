package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class validateUserRegistrationIT extends BaseClass {

    @Test
    public void shouldVerifyUserRegistration_whenUserClickRegisterButton(){
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on Register Link",homePage.clickRegisterLink());

        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("Unable to enter test in 'First Name' field", registrationPage.sendKeysToFirstName(RandomDataGenerator.randomString()));
        assertTrue("Unable to enter test in 'Last Name' field", registrationPage.sendKeysToLastName(RandomDataGenerator.randomString()));
        String email = RandomDataGenerator.randomAlphaNumeric()+".com";
        assertTrue("Unable to enter test in 'Email' field", registrationPage.sendKeysToEmail(email));
        //registerPage.scrollToCompanyName();
        assertTrue("Unable to enter test in 'Company Name' field", registrationPage.sendKeysToCompanyName());
        String password = RandomDataGenerator.randomString();
        assertTrue("Unable to enter test in 'Password' field", registrationPage.sendKeysToPassword(password));
        assertTrue("Unable to enter test in 'Confirm Password' field", registrationPage.sendKeysToConfirmPassword(password));
        assertTrue("Unable to click on 'Register' button", registrationPage.clickRegisterButton());

        RegistrationResultPage registrationResultPage = new RegistrationResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registrationResultPage.getRegisterResultText(),registerResulExpectedMessage,"Unable to verify Register Result message");

        homePage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysToEmail(email);
        loginPage.sendKeysToPassword(password);
        loginPage.clickLoginButton();

        homePage.clickSearchBox("Asus N551JK-XO076H Laptop");
        homePage.clickFirstElement();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickAddToCardButton();
        //productDetailsPage.confirmSuccessMessage();
        productDetailsPage.clickShoppingCartLink();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.confirmPageTitle();
        shoppingCartPage.clickTermOfServiceButton();
        shoppingCartPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.confirmPageTitle();
        checkoutPage.confirmBillingAddressTitle();
        String countryName="Germany";
        checkoutPage.selectCountryDropDownValueByText(countryName);
        String city = "Berlin";
        checkoutPage.sendKeysToCityTxt(city);
        checkoutPage.sendKeysToAddress1Txt(RandomDataGenerator.randomString());
        checkoutPage.sendKeysZipPostalCodeTxt("12345");
        checkoutPage.sendKeysPhoneNumberTxt("1234567890");
        checkoutPage.clickBillingContinueButton();
        checkoutPage.clickShippingContinueButton();
        checkoutPage.clickPaymentMethodContinueButton();
        checkoutPage.clickPaymentInfoContinueButton();
        assertTrue("unable to click on 'CONFIRM, button",checkoutPage.clickConfirmButton());
    }
}
