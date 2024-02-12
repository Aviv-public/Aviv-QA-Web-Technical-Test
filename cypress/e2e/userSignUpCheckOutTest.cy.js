import homePage from "../../pages/homePage";
import userRegistrationPage from "../../pages/userRegistrationPage"
import loginPage from "../../pages/loginPage"
import shoppingCartPage from "../../pages/shoppingCartPage"
import checkoutPage from "../../pages/checkoutPage";
import signUpData from "../fixtures/signUpData.json"
import checkoutData from "../fixtures/checkoutData.json"


describe('User registration and Checkout product', () => {


    beforeEach(() => {
        homePage.openUrl();
    });

    it('should register a new user and checkout product', () => {

        cy.generateRandomData('loginData');
        homePage.clickRigesterTab()

        // Use the generated data in your test if needed
        cy.fixture("loginData").then((loginData) => {
            userRegistrationPage.EnterDetails(signUpData.FirstName, signUpData.LastName, loginData.Email, signUpData.Password, signUpData.ConfirmPassword)
            userRegistrationPage.verifyRegistrationSuccesfulMsg(signUpData.RegistrationSuccessMessage)
            homePage.validateHeader()
            loginPage.loginWithValidUser(loginData.Email, signUpData.Password)
        });
        homePage.clickAddToCardBtn()
        homePage.goToShoppingCart()
        shoppingCartPage.clickTermsOfServiceCheckbox()
        shoppingCartPage.clickCheckOutButton()
        checkoutPage.updateBillingAddress(checkoutData.CountryValue, checkoutData.State, checkoutData.City, checkoutData.Address, checkoutData.PostalCode, checkoutData.PhoneNumber);
        checkoutPage.paymentAndConfirmOrder(checkoutData.ConfirmationMsg);

    })
    it('should display error messages for invalid registration', () => {
        homePage.clickRigesterTab();
        userRegistrationPage.EnterDetails(signUpData.FirstName, signUpData.LastName, signUpData.Email, signUpData.Password, signUpData.invalidConfirmedPassword);
        userRegistrationPage.verifyConfirmPasswordErrorMsg(signUpData.ConfirmedPasswordErrorMessage);
    })

    it('Login With User and add to Cart', () => {

        cy.fixture("loginData").then((loginData) => {
            loginPage.loginWithValidUser(loginData.Email, signUpData.Password)
        });

        homePage.clickAddToCardBtn()
        homePage.goToShoppingCart()
        shoppingCartPage.clickTermsOfServiceCheckbox()
        shoppingCartPage.clickCheckOutButton()
        //checkoutPage.updateBillingAddress(checkoutData.CountryValue, checkoutData.State, checkoutData.City, checkoutData.Address, checkoutData.PostalCode, checkoutData.PhoneNumber);
        checkoutPage.clickBillingContinueBtn()
        checkoutPage.paymentAndConfirmOrder(checkoutData.ConfirmationMsg);

    })


})