import Register from "../pages/registerPage";
import Login from "../pages/loginPage";
import Cart from "../pages/addToCart";
import { faker } from "@faker-js/faker";
const register = new Register();
const login = new Login();
const cart = new Cart();

describe("Scenario 1 - User Signup And Checkout", () => {
  let password = faker.internet.password();
  let email = faker.internet.email();

  it("should register the user and purchase the article successfully", () => {
    cy.visit("https://demo.nopcommerce.com/");
    register.registerNewUser({
      firstName: faker.name.firstName(),
      lastName: faker.name.lastName(),
      email: email,
      password: password,
      confirmPassword: password,
    });
    register.verifyLogin();
    register.redirectToHomePage();
    login.login(email, password);

    cart.addToCart("Build your own computer");
    cart.AddRamHDDToComputer();
    cart.VerifyAddToCartSuccess();
    cart.goToCart();

    cart.checkTermsAndConditions();
    cart.enterBillingDetails({
      country: "Germany",
      city: "Berlin",
      streetAddress: faker.location.streetAddress(),
      zipcode: faker.location.zipCode(),
      phoneNumber: faker.phone.number(),
    });
    cart.selectShippingMethodAndContinue();
    cart.payByCard();
    cart.enterCardDetails();
    cart.confirmOrder();
    cart.verifySuccessfulPurchase();
  });
});