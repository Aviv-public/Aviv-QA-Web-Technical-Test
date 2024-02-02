import HomePage from "../../../pages/homePage";
import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegisterPage from "../../../pages/registerPage";
import LoginPage from "../../../pages/loginPage";
import ProductDetailsPage from "../../../pages/productDetailsPage";
import ShoppingCartPage from "../../../pages/shoppingCartPage";
import CheckoutPage from "../../../pages/checkoutPage";
import ProductListingPage from "../../../pages/productListingPage";

const homePage = new HomePage();
const registerPage = new RegisterPage();
const loginPage = new LoginPage();
const productDetailsPage = new ProductDetailsPage();
const shoppingCartPage = new ShoppingCartPage();
const checkoutPage = new CheckoutPage();
const productListingPage = new ProductListingPage();

Given("Navigate to the website", () => {
  homePage.visit();
});

When("Click on the Register link", () => {
  homePage.clickOnRegisterButton();
});

When("Fill in valid information for a new user", () => {
  cy.fixture("userDetails").then((users) => {
    registerPage.fillRegistrationForm(users.validUser);
  });
});

When("Fill in invalid information for a new user", () => {
  cy.fixture("userDetails").then((users) => {
    registerPage.fillRegistrationForm(users.invalidUser);
  });
});

Then(
  "Verify the user is not registered, and an appropriate error message is displayed",
  () => {
    cy.fixture("validation").then((validators) => {
      registerPage.validateNoRegistration(validators.registrationValidation);
    });
  }
);

Then("Verify successful registration and redirection to the homepage", () => {
  cy.fixture("validation").then((validators) => {
    homePage.validateRegistration(validators.validations);
  });
});

When("Log in with valid user credentials", () => {
  homePage.clickOnLoginButton();
  cy.fixture("userDetails").then((users) => {
    loginPage.performLogin(users.validUser);
  });
});

When("Add a product to the shopping cart", () => {
  homePage.addProduct();
  cy.fixture("productDetails").then((product) => {
    productDetailsPage.updateDetails(product.productDetails);
    productDetailsPage.addtocart();
  });
});

When("Proceed to the checkout process", () => {
  homePage.clickOnShoppingCart();
  shoppingCartPage.agreeAndContinueCheckout();
});

When(
  "Verify the checkout process steps: Cart, Address, Shipping, Payment",
  () => {
    checkoutPage.validateProcessStep();
  }
);

When("Fill in valid shipping information", () => {
  cy.fixture("checkoutDetails").then((checkout) => {
    checkoutPage.fillAddress(checkout.address);
  });
});

When("Choose a shipping method", () => {
  checkoutPage.selectShippingOption();
});

When("Select a payment method", () => {
  checkoutPage.selectPaymentOption();
});

When("Complete the purchase", () => {
  checkoutPage.validateAndProceedFromPaymentInfo();
  checkoutPage.confirmCheckoutOrder();
});

When("Verify successful purchase and user confirmation", () => {
  cy.fixture("validation").then((validators) => {
    checkoutPage.validateOrderPlacement(validators.checkoutValidation);
  });
});

When("Add multiple products to the shopping cart", () => {
  homePage.navigateToProductListing();
  productListingPage.addMultipleProducts();
});

Then("Verify correct products and quantities in the shopping cart", () => {
  homePage.clickOnShoppingCart();
  cy.fixture("validation").then((validators) => {
    shoppingCartPage.validateProductAndQuantity(validators);
  });
});

When("Modify the quantity of a product", () => {
  cy.fixture("validation").then((validators) => {
    shoppingCartPage.modifyQuantityOfTheProduct(validators);
  });
});

When("Remove a product from the cart", () => {
  cy.fixture("validation").then((validators) => {
    shoppingCartPage.removeProductFromCart(validators);
  });
});

Then("Verify the cart is updated accordingly", () => {
  cy.fixture("validation").then((validators) => {
    shoppingCartPage.validateCart(validators);
  });
})

Then("Logout from portal", () => {
    homePage.clickOnLogOut();
})