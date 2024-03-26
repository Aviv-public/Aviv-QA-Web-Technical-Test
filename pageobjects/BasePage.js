const base = require('@playwright/test');
const {LoginPage} =  require('../pageobjects/LoginPage')
const {LandingPage} =  require('../pageobjects/LandingPage')
const {CheckoutPage} =  require('../pageobjects/CheckoutPage')
const {DepartmentPage} =  require('../pageobjects/DepartmentPage')
const {OrderInformationPage} =  require('../pageobjects/OrderInformationPage')
const {RegistrationPage} =  require('../pageobjects/RegistrationPage')
const {ShoppingCartPage} =  require('../pageobjects/ShoppingCartPage')

exports.test = base.test.extend({
    landingPage: async({page},use) =>{
        await use(new LandingPage(page))
    },
    loginPage: async({page},use) =>{
        await use(new LoginPage(page))
    },
    checkoutPage: async({page},use) =>{
        await use(new CheckoutPage(page))
    },
    departmentPage: async({page},use)=>{
        await use(new DepartmentPage(page))
    },
    orderInformationPage: async({page},use) =>{
        await use(new OrderInformationPage(page))
    },
    registrationPage: async({page}, use) =>{
        await use(new RegistrationPage(page))
    },
    shoppingCartPage: async ({page}, use)=>{
        await use(new ShoppingCartPage(page))
    }
})
exports.expect = base.expect