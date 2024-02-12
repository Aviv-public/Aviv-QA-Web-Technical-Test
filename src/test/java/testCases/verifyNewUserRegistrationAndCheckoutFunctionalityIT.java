package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class verifyNewUserRegistrationAndCheckoutFunctionalityIT extends BaseClass {

    @Test
    public void shouldVerifyProductCheckoutFunctionality_whenNewUserSignup(){
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on 'Register' Link",homePage.clickRegisterLink());

        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("unable to enter text in 'First Name:' field", registrationPage.sendKeysToFirstName(RandomDataGenerator.randomString()));
        assertTrue("unable to enter text in 'Last Name:' field", registrationPage.sendKeysToLastName(RandomDataGenerator.randomString()));
        String email = RandomDataGenerator.randomAlphaNumeric()+".com";
        assertTrue("unable to enter text in 'Email:' field", registrationPage.sendKeysToEmail(email));
        //registerPage.scrollToCompanyName();
        assertTrue("unable to enter text in 'Company Name:' field", registrationPage.sendKeysToCompanyName());
        String password = RandomDataGenerator.randomString();
        assertTrue("unable to enter text in 'Password:' field", registrationPage.sendKeysToPassword(password));
        assertTrue("unable to enter text in 'Confirm Password:' field", registrationPage.sendKeysToConfirmPassword(password));
        assertTrue("unable to click on 'REGISTER' button", registrationPage.clickRegisterButton());

        RegistrationResultPage registrationResultPage = new RegistrationResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registrationResultPage.getRegisterResultText(),registerResulExpectedMessage,"unable to verify Register Result message");

        assertTrue("unable to click on 'Log in' link",homePage.clickLoginLink());

        LoginPage loginPage = new LoginPage(driver);
        assertTrue("unable to enter text in 'Email:' field",loginPage.sendKeysToEmail(email));
        assertTrue("unable to enter text in 'Password:' field",loginPage.sendKeysToPassword(password));
        assertTrue("unable to click on 'LOG IN' button",loginPage.clickLoginButton());

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
