class CheckoutPage {

    constructor(page) {
        this.page = page
        this.billingcountrylist = page.locator('select#BillingNewAddress_CountryId')
        this.billingnewaddressstateprovince = page.locator('select#BillingNewAddress_StateProvinceId')
        this.billingnewaddresscity = page.locator('#BillingNewAddress_City')
        this.billingnewaddressaddress1 = page.locator('#BillingNewAddress_Address1')
        this.billingnewaddresszippostalcode = page.locator('#BillingNewAddress_ZipPostalCode')
        this.billingnewaddressphonenumber = page.locator('#BillingNewAddress_PhoneNumber')
        this.shippingcountrylist = page.locator('select#ShippingNewAddress_CountryId')
        this.shippingnewaddressstateprovince = page.locator('select#ShippingNewAddress_StateProvinceId')
        this.shippingnewaddresscity = page.locator('#ShippingNewAddress_City')
        this.shippingnewaddressaddress1 = page.locator('#ShippingNewAddress_Address1')
        this.shippingnewaddresszippostalcode = page.locator('#ShippingNewAddress_ZipPostalCode')
        this.shippingnewaddressphonenumber = page.locator('#ShippingNewAddress_PhoneNumber')
        this.shiptosameaddress = page.locator('#ShipToSameAddress')
        this.shippingmethod = page.locator('form#co-shipping-method-form')
        this.paymentmethod = page.locator('ul#payment-method-block')
        this.paymentinformation = page.locator('div.info')
        this.billingaddressselect = page.locator('select#billing-address-select')
        this.returningcustomer = page.locator('div.returning-wrapper')
        this.shippingaddressdropdown = page.locator('select#shipping-address-select')
        this.shippingaddressnextbutton = page.locator('div#shipping-buttons-container button.new-address-next-step-button')
        this.shiptosameaddrescheckbox = page.locator('input#ShipToSameAddress')
        this.shippingmethodform = page.locator('div#shipping-methods-form')
        this.paymentnextbutton = page.locator('button.payment-info-next-step-button')
        this.confirmordercontainer = page.locator('div#confirm-order-buttons-container')
    }

    async enterBillingAndShippingDetails(userstate, country, state, city, address, zipcode, phonenumber) {
        if (await userstate === 'new') {
            await this.enterBillingAndShippingAddressNewUser(country, state, city, address, zipcode, phonenumber)
        } if (await userstate === 'existing') {
            await this.enterBillingAndShippingAddressExistingUser(country, state, city, address, zipcode, phonenumber)
        }
    }

    async enterBillingAndShippingAddressNewUser(country, state, city, address, zipcode, phonenumber) {
        await this.shiptosameaddrescheckbox.isEnabled()
        await this.shiptosameaddrescheckbox.click()
        await this.billingcountrylist.selectOption(country)
        await this.billingnewaddressstateprovince.selectOption(state)
        await this.billingnewaddresscity.fill(city)
        await this.billingnewaddressaddress1.fill(address)
        await this.billingnewaddresszippostalcode.fill(zipcode)
        await this.billingnewaddressphonenumber.fill(phonenumber)
        await this.continue()
        await this.shippingaddressdropdown.selectOption('New Address')
        await this.shippingcountrylist.selectOption(country)
        await this.shippingnewaddressstateprovince.selectOption(state)
        await this.shippingnewaddresscity.fill(city)
        await this.shippingnewaddressaddress1.fill(address)
        await this.shippingnewaddresszippostalcode.fill(zipcode)
        await this.shippingnewaddressphonenumber.fill(phonenumber)
        await this.shippingaddressnextbutton.click()
    }
    async enterBillingAndShippingAddressExistingUser(country, state, city, address, zipcode, phonenumber) {
        await this.shiptosameaddrescheckbox.isEnabled()
        await this.shiptosameaddrescheckbox.click()
        await this.continue()
        await this.shippingaddressdropdown.selectOption('New Address')
        await this.shippingcountrylist.selectOption(country)
        await this.shippingnewaddressstateprovince.selectOption(state)
        await this.shippingnewaddresscity.fill(city)
        await this.shippingnewaddressaddress1.fill(address)
        await this.shippingnewaddresszippostalcode.fill(zipcode)
        await this.shippingnewaddressphonenumber.fill(phonenumber)
        await this.shippingaddressnextbutton.click()
    }
    async shipToSameAddress() {
        return await this.shiptosameaddrescheckbox.isChecked()
    }

    async shipTodifferentAddress() {
        await this.shiptosameaddrescheckbox.check()
    }

    async selectShippingMethod(shippingmethod) {
        if (await this.shippingmethodform.isEnabled()) {
            await this.shippingmethod.getByLabel(shippingmethod).check()
            await this.continue()
        }
    }

    async selectPaymentMethodAndEnterCCDetails(cardtype, holdername, cardnumber, expirationmonth, expirationyear, cvv) {
        if (await this.paymentmethod.isEnabled()) {
            await this.paymentmethod.getByLabel('Credit Card').check()
            await this.continue()
            await this.paymentinformation.locator('select#CreditCardType').selectOption(cardtype)
            await this.paymentinformation.locator('input#CardholderName').fill(holdername)
            await this.paymentinformation.locator('input#CardNumber').fill(cardnumber)
            await this.paymentinformation.locator('select#ExpireMonth').selectOption(expirationmonth)
            await this.paymentinformation.locator('select#ExpireYear').selectOption(expirationyear)
            await this.paymentinformation.locator('input#CardCode').fill(cvv)
            await this.continue()
        }
    }
    async selectPaymentMethodCheck() {
        if (await this.paymentmethod.isEnabled()) {
            await this.paymentmethod.getByLabel('Check / Money Order')
            await this.continue()
        }
        await this.paymentnextbutton.click()
    }

    async confirmOrder() {
        if (await this.confirmordercontainer.isEnabled()) {
            await this.confirmordercontainer.locator('button.confirm-order-next-step-button').click()
        }
    }
    async continue() {
        await this.page.getByRole("button", { name: 'Continue' }).click()
    }

}
module.exports = { CheckoutPage }