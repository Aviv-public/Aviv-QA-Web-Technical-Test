import homePage from "../../pages/homePage";
import loginPage from "../../pages/loginPage";
import shoppingCartPage from "../../pages/shoppingCartPage";
import checkoutPage from "../../pages/checkoutPage"
import loginData from "../fixtures/loginData.json"
import checkoutData from "../fixtures/checkoutData.json"
describe('User Login and checkout product', () => {
    
    beforeEach(() => {
        homePage.openUrl();
    });
  
it('Login With User and add to Cart',() => {

    loginPage.loginWithValidUser(loginData.Email,loginData.Password)
    homePage.clickAddToCardBtn()
    homePage.goToShoppingCart()
    shoppingCartPage.clickTermsOfServiceCheckbox()
    shoppingCartPage.clickCheckOutButton()
    checkoutPage.UpdateBillingAddress(checkoutData.CountryValue, checkoutData.State, checkoutData.City,  checkoutData.Address, checkoutData.PostalCode, checkoutData.PhoneNumber);
    checkoutPage.paymentAndConfirmOrder(checkoutData.ConfirmationMsg);
 
   })

});