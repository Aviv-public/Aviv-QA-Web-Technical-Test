import signUpPage from "../../pages/signUpPage"
import logindata from "../../fixtures/loginData.json"
import userLoginCheckoutPage from "../../pages/userLoginCheckoutPage"


describe('User Login and checkout process', () => {
    
    beforeEach(() => {
        signUpPage.openUrl();
    });
  
it('Login With User and add to Cart',() => {

    userLoginCheckoutPage.LoginWithUser(logindata.Email,logindata.Password)
    userLoginCheckoutPage.AddtoCart();
    userLoginCheckoutPage.UpdateShippingAddress(logindata.CountryValue,logindata.City,logindata.State,logindata.Address,logindata.PostalCode,logindata.PhoneNumber);
    userLoginCheckoutPage.ShippingMethod(logindata.ConfirmationMsg);
 

   })

});