package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

import static org.testng.AssertJUnit.assertFalse;
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

        addProductToCart("Asus N551JK-XO076H Laptop",2);
        addProductToCart("First Prize Pies",4);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        assertTrue("unable to click on 'Shopping cart' link",productDetailsPage.clickShoppingCartLink());

        //Proceed to the checkout process
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertTrue("unable to confirm 'Shopping cart' page title",shoppingCartPage.confirmShoppingCartPageTitleIsVisible());

        verifyProductQuantity("Asus N551JK-XO076H Laptop",2);
        verifyProductQuantity("First Prize Pies",4  );

        modifyProductQuantity("Asus N551JK-XO076H Laptop",5);
        modifyProductQuantity("First Prize Pies",5);

        verifyProductQuantity("Asus N551JK-XO076H Laptop",5);
        verifyProductQuantity("First Prize Pies",5);

        removeProductFromCartAndVerify("Asus N551JK-XO076H Laptop");

    }

    public void addProductToCart(String productName, int quantity ){
        HomePage homePage = new HomePage(driver);
        //Search and Add a product to the shopping cart
        assertTrue("unable to enter text in 'Search store' placeholder",homePage.sendKeysToSearchStorePlaceholder(productName));
        assertTrue("unable to click on first element in Search store placeholder",homePage.clickFirstElementInSearchStorePlaceholder());

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        assertTrue("unable to clear entered quantity text box", productDetailsPage.clearEnteredQuantityTextBox());

        assertTrue("unable to enter quantity in entered quantity text box", productDetailsPage.sendKeysToEnteredQuantityTextBox(quantity));

        assertTrue("unable to click on 'ADD TO CART' button",productDetailsPage.clickAddToCartButton());
        String productAddedToShippingCartExpectedSuccessMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(productDetailsPage.getProductAddedToShippingCartSuccessMessage(),productAddedToShippingCartExpectedSuccessMessage,"unable to verify product added to shipping card success message");
    }

    public void verifyProductQuantity(String productName, int expectedQuantity){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String quantityAsString = shoppingCartPage.getProductQuantityByGivenProductName(productName);
        int actualQuantity = Integer.parseInt(quantityAsString);
        // Verify the quantity
        Assert.assertEquals(actualQuantity, expectedQuantity,"Quantity mismatch for product: " + productName);
    }

    public void modifyProductQuantity(String productName, int newQuantity) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clearProductQuantity(productName);
        shoppingCartPage.sendKeysProductQuantity(productName,newQuantity);
        shoppingCartPage.clickUpdateShoppingCartButton();
    }
    public void removeProductFromCartAndVerify(String productName){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.click(productName);
        shoppingCartPage.clickUpdateShoppingCartButton();
        assertFalse("Product '" + productName + "' is still present in the cart after removal",shoppingCartPage.confirmProductNameLink(productName));
    }
}
