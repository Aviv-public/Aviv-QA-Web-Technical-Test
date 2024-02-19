package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.SharedContext;

import static org.testng.AssertJUnit.assertTrue;

public class VerifyExistingUserLogInAndCheckoutFunctionalityIT extends BaseClass {

    @Test(dependsOnMethods = "shouldVerifyProductCheckoutFunctionality_whenNewUserSignup")
    public void shouldVerifyProductCheckoutFunctionality_whenExistingUserLogIn(){
        WebDriver driver = getDriver();

        //Click on the "Register" link
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to confirm 'nopCommerce' logo",homePage.confirmNopCommerceLogoIsVisible());
        //Log in with the newly created user credentials.
        assertTrue("unable to click on 'Log in' link",homePage.clickLoginLink());

        LoginPage loginPage = new LoginPage(driver);
        String email = SharedContext.getGeneratedEmail();
        String password = SharedContext.getGeneratedPassword();
        assertTrue("unable to enter text in 'Email:' field",loginPage.sendKeysToEmail(email));
        assertTrue("unable to enter text in 'Password:' field",loginPage.sendKeysToPassword(password));
        assertTrue("unable to click on 'LOG IN' button",loginPage.clickLoginButton());

        //Search and Add a product to the shopping cart
        assertTrue("unable to enter text in 'Search store' placeholder",homePage.sendKeysToSearchStorePlaceholder("Asus N551JK-XO076H Laptop"));
        assertTrue("unable to click on first element in Search store placeholder",homePage.clickFirstElementInSearchStorePlaceholder());

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        assertTrue("unable to click on 'ADD TO CART' button",productDetailsPage.clickAddToCartButton());

        String productAddedToShippingCartExpectedSuccessMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(productDetailsPage.getProductAddedToShippingCartSuccessMessage(),productAddedToShippingCartExpectedSuccessMessage,"unable to verify product added to shipping card success message");
        assertTrue("unable to click on 'Shopping cart' link",productDetailsPage.clickShoppingCartLink());

        //Proceed to the checkout process
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertTrue("unable to confirm 'Shopping cart' page title",shoppingCartPage.confirmShoppingCartPageTitleIsVisible());
        assertTrue("unable to click term of service checkbox",shoppingCartPage.checkTermOfServiceCheckbox());
        assertTrue("unable to click 'CHECKOUT' button",shoppingCartPage.clickCheckoutButton());

        //Verify that the checkout process includes the following steps: Cart, Address,Shipping, Payment
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue("unable to confirm 'Checkout' page title",checkoutPage.confirmCheckoutPageTitleIsVisible());
        assertTrue("unable to confirm 'Billing address' header",checkoutPage.confirmBillingAddressHeaderIsVisible());
        assertTrue("unable to confirm 'Shipping address' header",checkoutPage.confirmShippingAddressHeaderIsVisible());
        assertTrue("unable to confirm 'Shipping method' header",checkoutPage.confirmShippingMethodHeaderIsVisible());
        assertTrue("unable to confirm 'Payment method' header",checkoutPage.confirmPaymentMethodHeaderIsVisible());
        assertTrue("unable to confirm 'Payment information' header",checkoutPage.confirmPaymentInformationHeaderIsVisible());
        assertTrue("unable to confirm 'Confirm order' header",checkoutPage.confirmConfirmOrderHeaderIsVisible());

        //Fill in valid shipping information
        assertTrue("unable to click on Billing 'CONTINUE' button",checkoutPage.clickBillingContinueButton());

        //Choose a shipping method
        assertTrue("unable to click on Shipping 'Next Day Air' radio button",checkoutPage.clickNextDayAirShippingMethodRadioButton());
        assertTrue("unable to click on Shipping 'CONTINUE' button",checkoutPage.clickShippingContinueButton());

        //Select a payment method
        assertTrue("unable to click on Payment method 'Check / Money Order' radio button",checkoutPage.clickCheckMoneyOrderRadioButton());
        assertTrue("unable to click on Payment Method 'CONTINUE' button",checkoutPage.clickPaymentMethodContinueButton());

        //Payment information
        assertTrue("unable to click on Payment Information 'CONTINUE' button",checkoutPage.clickPaymentInfoContinueButton());

        //Complete the purchase
        assertTrue("unable to click on 'CONFIRM, button",checkoutPage.clickConfirmButton());

        //Verify that the purchase is successful, and the user receives a confirmation.
        OrderCompletedPage orderCompletedPage = new OrderCompletedPage(driver);
        assertTrue("unable to confirm order completed page title",orderCompletedPage.confirmOrderCompletedPageTitleIsVisible());
        assertTrue("unable to verify 'Your order has been successfully processed!' success message",orderCompletedPage.confirmOrderProcessedSuccessMessageIsVisible());
        assertTrue("unable to verify 'ORDER NUMBER:XXXX' message",orderCompletedPage.confirmOrderNumberTitleIsVisible());
    }
}
