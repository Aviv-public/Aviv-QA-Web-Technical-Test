const { test, expect } = require("@playwright/test")
const { POManager } = require('../pageobjects/POManager')
const dataset = JSON.parse(JSON.stringify(require('../utils/userSignupAndPlaceOrder.json')))

for(const data of dataset){
test(`user signup and complete the checkout - shipping address different from billing address - CC Payment for ${data.useremail}`, async ({ page }) => {
    const poManager = new POManager(page)
    const landingPage = poManager.getlandingPage()
    const loginPage = poManager.getloginpage()
    const departmentPage = poManager.getdepartmentpage()
    const shoppingCartPage = poManager.getshoppingcartpage()
    const checkoutPage = poManager.getcheckoutpage()
    const orderInformationPage = poManager.getorderinformationpage()
    await landingPage.goTo()
    const userstate = await landingPage.checkUserUponRegistrationAndValidLogin(data.useremail)
    await landingPage.clickLoginLink()
    await loginPage.loginuser(data.useremail)
    await departmentPage.clickOnSubcategoryAndAddToCart(data.category, data.subCategory, data.productName)
    await expect(await departmentPage.productAdditionSuccessMsg()).toHaveText(data.productAdditionSuccessActual)
    await departmentPage.clickOnShoppingCart()
    await shoppingCartPage.productDetailsFromCartPage(data.productName)
    await shoppingCartPage.updateCartWithProductDetails()
    await shoppingCartPage.cartTotal()
    await shoppingCartPage.acceptTnC()
    await shoppingCartPage.goToCheckout()
    await checkoutPage.enterBillingAndShippingDetails(userstate,data.country, data.state, data.city, data.address, data.zipcode, data.phonenumber)
    await checkoutPage.selectShippingMethod(data.shippingMethod)
    await checkoutPage.selectPaymentMethodAndEnterCCDetails(data.cardType, data.cardHolderName, data.cardNumber, data.cardExpiryMonth, data.cardExpiryYear, data.cardCVv)
    await checkoutPage.confirmOrder()
    expect(await orderInformationPage.orderPlacedSuccessMsg()).toEqual(data.orderPlacedSuccessMsg)
    expect(await orderInformationPage.getOrder()).toEqual(await orderInformationPage.openAndValidationOrder(await orderInformationPage.getOrder()))
})
}