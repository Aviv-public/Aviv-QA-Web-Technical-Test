import signUpPage from "../../pages/signUpPage"
import signUpData from "../../fixtures/signUpData.json"


describe('Resgister with valid user credentials', () => {

    beforeEach(() => {
        signUpPage.openUrl();
    });
  
    it('Open website and register a user credentials', () => {
    
     signUpPage.clickRegister()

     signUpPage.EnterDetails(signUpData.FirstName, signUpData.LastName, signUpData.Email, signUpData.Password, signUpData.ConfirmPassword)
     signUpPage.ClickFinalRegisteration() 
     signUpPage.ValidateHeader() 
    
    });

     it('Login With User and add to Cart',() => {

     signUpPage.LoginWithUser(signUpData.Email,signUpData.Password)
     signUpPage.AddtoCart();
     signUpPage.UpdateShippingAddress(signUpData.CountryValue,signUpData.City,signUpData.State,signUpData.Address,signUpData.PostalCode,signUpData.PhoneNumber);
     signUpPage.ShippingMethod(signUpData.ConfirmationMsg);
  
 
    })
      }); 
      