const { test, expect } = require("@playwright/test")
const { POManager } = require('../pageobjects/POManager')
const {customtestinvaliduseremail} = require("../utils/test-base")
const {customtestregisterwithoutdata} = require("../utils/test-base")

customtestinvaliduseremail(`invalid email`, async ({ page,testDataForInvalidEmail }) => {

    const poManager = new POManager(page)
    const landingPage = poManager.getlandingPage()
    const registrationPage = poManager.getregistrationpage()
    await landingPage.goTo()
    await landingPage.clickRegistrationLink()
    await expect(await registrationPage.registerUserInvalidEmail(testDataForInvalidEmail.useremail)).toHaveText(testDataForInvalidEmail.registrationWrongEmail)
})

customtestregisterwithoutdata(`register without feeding any details`, async ({ page, registerwithoutdata}) => {

    const poManager = new POManager(page)
    const landingPage = poManager.getlandingPage()
    const registrationPage = poManager.getregistrationpage()
    await landingPage.goTo()
    await landingPage.clickRegistrationLink()
    let errListMsg = await registrationPage.clickRegisterWithoutEnteringDetails()
    expect(await errListMsg[0]).toEqual(registerwithoutdata.firstNameError)
    expect(await errListMsg[1]).toEqual(registerwithoutdata.lastNameError)
    expect(await errListMsg[2]).toEqual(registerwithoutdata.emailError)
    expect(await errListMsg[3]).toEqual(registerwithoutdata.pwderror)
    expect(await errListMsg[4]).toEqual(registerwithoutdata.confirmpwderror)
    
})