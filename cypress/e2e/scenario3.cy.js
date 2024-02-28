import Register from "../pages/registerPage";
import Cart from "../pages/addToCart";
import Login from "../pages/loginPage";
const login = new Login();
const cart = new Cart();
const register = new Register();
describe("Scenario 3 - Existing user login and checkout", () => {
  let signUpData;
  
  before(() => {
    cy.fixture("users").then((data) => {
      signUpData = data;
      cy.visit("https://demo.nopcommerce.com/");
      register.registerNewUser({...signUpData.newUser});

    });
});

it("Should login with existing credentials and checkout", () => {
    //add product to cart
    login.login(signUpData.validUser.email,signUpData.validUser.password );
    cart.addToCart("Build your own computer");
    cart.AddRamHDDToComputer();
    cart.VerifyAddToCartSuccess();
    cart.goToCart();
    cart.checkTermsAndConditions();
    cart.SelectBillingAddressFromAddBook();
    cart.selectShippingMethodAndContinue();
    cart.payByCard();
    cart.enterCardDetails();
    cart.confirmOrder();
    cart.verifySuccessfulPurchase();
  });
});