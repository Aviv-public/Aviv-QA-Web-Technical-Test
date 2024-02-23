import Login from "../pages/loginPage";
import Cart from "../pages/addToCart";

const login = new Login();
const cart = new Cart();

describe("Scenario 4 - verify cart functionality", () => {
  let productData;
  before(() => {
    cy.fixture("products").then((data) => {
      productData = data;
    });
    cy.visit("https://demo.nopcommerce.com/");
  });
  let email = "ayesha@gmail.com";
  let password = "ayeshamysis2";

  it("Should add multiple products and update cart accordingly", () => {
    login.Auth(email, password);
    cart.addToCart(productData[0].name);
    cart.VerifyAddToCartSuccess();
    cart.addToCart(productData[1].name);
    cart.AddRamHDDToComputer();
    cart.VerifyAddToCartSuccess();
    cart.goToCart();
    cart.modifyQuantityInCart(productData[0].name, productData[0].quantity);
    cart.modifyQuantityInCart(productData[1].name, productData[1].quantity);
    cart.clickUpdateCartButton();
    cart.verifyQuantityInShoppingCartLabel("5");
    cart.removeProductFromCart(productData[1].name);
    cart.verifyQuantityInShoppingCartLabel("4");
  });
});
