const { LandingPage } = require('./LandingPage')
const { RegistrationPage } = require('./RegistrationPage')
const { LoginPage } = require('./LoginPage')
const { DepartmentPage } = require('./DepartmentPage')
const { ShoppingCartPage } = require('./ShoppingCartPage')
const { CheckoutPage } = require('./CheckoutPage')
const { OrderInformationPage } = require('./OrderInformationPage')


class POManager {

    constructor(page) {
        this.page = page
        this.LandingPage = new LandingPage(this.page)
        this.RegistrationPage = new RegistrationPage(this.page)
        this.LoginPage = new LoginPage(this.page)
        this.DepartmentPage = new DepartmentPage(this.page)
        this.ShoppingCartPage = new ShoppingCartPage(this.page)
        this.CheckoutPage = new CheckoutPage(this.page)
        this.OrderInformationPage = new OrderInformationPage(this.page)
    }

    getlandingPage() {
        return this.LandingPage
    }
    getregistrationpage() {
        return this.RegistrationPage
    }
    getloginpage() {
        return this.LoginPage
    }
    getdepartmentpage() {
        return this.DepartmentPage
    }
    getshoppingcartpage() {
        return this.ShoppingCartPage
    }
    getcheckoutpage() {
        return this.CheckoutPage
    }
    getorderinformationpage() {
        return this.OrderInformationPage
    }
}
module.exports = { POManager }