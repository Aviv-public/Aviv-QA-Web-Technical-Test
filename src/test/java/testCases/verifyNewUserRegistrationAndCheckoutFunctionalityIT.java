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

        assertTrue("unable to enter text in 'Search store' placeholder",homePage.sendKeysToSearchStorePlaceholder("Asus N551JK-XO076H Laptop"));
        assertTrue("unable to click on first element in Search store placeholder",homePage.clickFirstElementInSearchStorePlaceholder());

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        assertTrue("unable to click on 'ADD TO CART' button",productDetailsPage.clickAddToCartButton());
        //assertTrue("Success Message",productDetailsPage.confirmSuccessMessage());
        //System.out.println(productDetailsPage.get());
        assertTrue("unable to click on 'Shopping cart' link",productDetailsPage.clickShoppingCartLink());

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertTrue("unable to confirm 'Shopping cart' page title",shoppingCartPage.confirmShoppingCartPageTitle());
        assertTrue("unable to click term of service checkbox",shoppingCartPage.clickTermOfServiceCheckbox());
        assertTrue("unable to click 'CHECKOUT' button",shoppingCartPage.clickCheckoutButton());

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue("unable to confirm 'Checkout' page title",checkoutPage.confirmCheckoutPageTitle());
        assertTrue("unable to confirm 'Billing address' header",checkoutPage.confirmBillingAddressHeader());
        String countryName="Germany";
        assertTrue("unable to select 'Germany' from 'Country:' dropdown",checkoutPage.selectCountryDropDownValueByText(countryName));
        String city = "Berlin";
        assertTrue("unable to enter text in 'City' field",checkoutPage.sendKeysToCityTxt(city));
        assertTrue("unable to enter text in 'Address 1:' field",checkoutPage.sendKeysToAddress1Txt(RandomDataGenerator.randomString()));
        assertTrue("unable to enter text in 'Zip / postal code:' field",checkoutPage.sendKeysZipPostalCodeTxt("12345"));
        assertTrue("unable to enter text in 'Phone number:' field",checkoutPage.sendKeysPhoneNumberTxt("1234567890"));
        assertTrue("unable to click on Billing 'CONTINUE' button",checkoutPage.clickBillingContinueButton());
        assertTrue("unable to click on Shipping 'CONTINUE' button",checkoutPage.clickShippingContinueButton());
        assertTrue("unable to click on Payment Method 'CONTINUE' button",checkoutPage.clickPaymentMethodContinueButton());
        assertTrue("unable to click on Payment Information 'CONTINUE' button",checkoutPage.clickPaymentInfoContinueButton());
        assertTrue("unable to click on 'CONFIRM, button",checkoutPage.clickConfirmButton());

        OrderCompletedPage orderCompletedPage = new OrderCompletedPage(driver);
        assertTrue("unable to confirm order completed page title",orderCompletedPage.confirmOrderCompletedPageTitle());
        assertTrue("unable to verify success message",orderCompletedPage.confirmOrderProcessedSuccessMessage());
    }
}
