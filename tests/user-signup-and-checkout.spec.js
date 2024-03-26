const { test, expect } = require('../pageobjects/BasePage');
const dataset = JSON.parse(JSON.stringify(require('../utils/userSignupAndPlaceOrder.json')))
var userstate
for (const data of dataset) {
    test.describe(`E2E Suite CC Payment for ${data.useremail}`, () => {
        test.beforeEach(async ({ landingPage, loginPage }) => {
            await landingPage.goTo()
            userstate = await landingPage.checkUserUponRegistrationAndValidLogin(data.useremail)
            await landingPage.clickLoginLink()
            await loginPage.loginuser(data.useremail)
        })

        test('Select the items on department page and go to shoping cart page', async ({ departmentPage, shoppingCartPage, checkoutPage, orderInformationPage }) => {
            await departmentPage.clickOnSubcategoryAndAddToCart(data.category, data.subCategory, data.productName, "1")
            await departmentPage.clickOnShoppingCart()
            await shoppingCartPage.productDetailsFromCartPage(data.productName, "1")
            //await shoppingCartPage.updateCartWithProductDetails()
            expect(await shoppingCartPage.cartTotal()).toBeTruthy()
            await shoppingCartPage.acceptTnC()
            await shoppingCartPage.goToCheckout()
            await checkoutPage.enterBillingAndShippingDetails(userstate, data.country, data.state, data.city, data.address, data.zipcode, data.phonenumber)
            await checkoutPage.selectShippingMethod(data.shippingMethod)
            await checkoutPage.selectPaymentMethodAndEnterCCDetails(data.cardType, data.cardHolderName, data.cardNumber, data.cardExpiryMonth, data.cardExpiryYear, data.cardCVv)
            await checkoutPage.confirmOrder()
            expect(await orderInformationPage.orderPlacedSuccessMsg()).toEqual(data.orderPlacedSuccessMsg)
            expect(await orderInformationPage.getOrder()).toEqual(await orderInformationPage.openAndValidationOrder(await orderInformationPage.getOrder()))

        })
    })
}