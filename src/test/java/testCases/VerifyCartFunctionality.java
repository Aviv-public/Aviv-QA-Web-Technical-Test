package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class VerifyCartFunctionality extends BaseClass {

    @Test
    public void shouldVerifyCartFunctionality_whenUserAddModifyRemoveProductFromCart(){

        //Click on the "Register" link
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to confirm 'nopCommerce' logo",homePage.confirmNopCommerceLogoIsVisible());
        assertTrue("unable to click on 'Register' Link",homePage.clickRegisterLink());

        //Fill in valid information for a new user (First Name, Last Name, Email Address, Password, Confirm Password)
        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue("unable to enter text in 'First Name:' field", registrationPage.sendKeysToFirstName(RandomDataGenerator.randomFirstName()));
        assertTrue("unable to enter text in 'Last Name:' field", registrationPage.sendKeysToLastName(RandomDataGenerator.randomLastName()));
        String email = RandomDataGenerator.randomEmail();
        assertTrue("unable to enter text in 'Email:' field", registrationPage.sendKeysToEmail(email));
        assertTrue("unable to enter text in 'Company Name:' field", registrationPage.sendKeysToCompanyName());
        String password = RandomDataGenerator.randomPassword();
        assertTrue("unable to enter text in 'Password:' field", registrationPage.sendKeysToPassword(password));
        assertTrue("unable to enter text in 'Confirm Password:' field", registrationPage.sendKeysToConfirmPassword(password));
        assertTrue("unable to click on 'REGISTER' button", registrationPage.clickRegisterButton());

        //Verify that the user is successfully registered and redirected to the homepage.
        RegistrationResultPage registrationResultPage = new RegistrationResultPage(driver);
        String registerResulExpectedMessage = "Your registration completed";
        Assert.assertEquals(registrationResultPage.getRegisterResultText(),registerResulExpectedMessage,"unable to verify Register Result message");

        //Log in with the newly created user credentials.
        assertTrue("unable to click on 'Log in' link",homePage.clickLoginLink());

        LoginPage loginPage = new LoginPage(driver);
        assertTrue("unable to enter text in 'Email:' field",loginPage.sendKeysToEmail(email));
        assertTrue("unable to enter text in 'Password:' field",loginPage.sendKeysToPassword(password));
        assertTrue("unable to click on 'LOG IN' button",loginPage.clickLoginButton());

        //Add multiple products to the shopping cart.
        String productName1 = "Asus N551JK-XO076H Laptop";
        int quantity1 = 2;
        homePage.searchAndSelectFirstElementInSearchStorePlaceholder(productName1);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addProductToCart(quantity1);

        String productName2 = "First Prize Pies";
        int quantity2 = 4;
        homePage.searchAndSelectFirstElementInSearchStorePlaceholder(productName2);
        productDetailsPage.addProductToCart(quantity2);

        assertTrue("unable to click on 'Shopping cart' link",productDetailsPage.clickShoppingCartLink());

        //Proceed to the checkout process
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertTrue("unable to confirm 'Shopping cart' page title",shoppingCartPage.confirmShoppingCartPageTitleIsVisible());

        //Verify that the correct products and quantities are displayed in the shopping cart.
        shoppingCartPage.verifyProductQuantity(productName1,quantity1);
        shoppingCartPage.verifyProductQuantity(productName2,quantity2);

        //Modify the quantity of a product.
        int newQuantity = 5;
        shoppingCartPage.modifyProductQuantity(productName1,newQuantity);
        shoppingCartPage.modifyProductQuantity(productName2,newQuantity);

        //Verify that the correct products and quantities are displayed in the shopping cart.
        shoppingCartPage.verifyProductQuantity(productName1,newQuantity);
        shoppingCartPage.verifyProductQuantity(productName2,newQuantity);

        //Remove a product from the cart and verify that the cart is updated accordingly.
        shoppingCartPage.removeProductFromCartAndVerify(productName1);
    }
}
