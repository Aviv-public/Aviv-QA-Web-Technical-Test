import homePage from '../../pageObjects/homePage'
import loginPage from '../../pageObjects/loginPage'
import registrationPage from '../../pageObjects/registrationPage';
import data from "../../fixtures/homePageData.json"
import emailData from "../../fixtures/randomEmail.json"
import productDetailsPage from '../../pageObjects/productDetailsPage';
import shoppingCartPage from '../../pageObjects/shoppingCartPage';

const homeObject = new homePage();
const regObject = new registrationPage();
const loginObj = new loginPage();
const shoppingCartObj = new shoppingCartPage();
const productDetailsObj = new productDetailsPage();

describe('Scenario 1: User Signup and Checkout', () => {

   it('User SignUp', () => {
      homeObject.clickOnRegister();
      cy.get('@email').then(($btn) => {
         regObject.enterPersonalDetails(data.gender, data.fName, data.lName, data.dayInDOB,
            data.monthInDOB, data.yearInDOB, $btn, data.companyName, data.newsLetter, data.password);
         const jsonData = { "email": $btn }
         cy.writeFile('cypress/fixtures/randomEmail.json', jsonData);
      })
      regObject.clickOnRegisterButton();
   })

   it('Check Out using newly created credentials', () => {
      homeObject.clickOnLogin();
      loginObj.enterLoginDetails(emailData.email, data.password);
      loginObj.clickOnLoginButton();
      homeObject.clickOnElectronics();
      productDetailsObj.addProductToCart();
      homeObject.goToShoppingCart();
      shoppingCartObj.clickOncheckOut();
      shoppingCartObj.enterBillingAddress(data.country, data.state, data.city, data.address, data.postalCode, data.phone);
   })

   it('Add Products To Cart', () => {
      homeObject.clickOnLogin();
      loginObj.enterLoginDetails(emailData.email, data.password);
      loginObj.clickOnLoginButton();
      homeObject.clickOnElectronics();
      productDetailsObj.addProductToCart();
      homeObject.goToShoppingCart();
      shoppingCartObj.removeItemsFromCart();
   })


})