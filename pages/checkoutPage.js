class checkOutPage {
    weblocator = {
        billingCountryDropedown: '#BillingNewAddress_CountryId',
        billingStateDropeDown: '#BillingNewAddress_StateProvinceId',
        billingCityInput: '#BillingNewAddress_City',
        billingAddressInput: '#BillingNewAddress_Address1',
        billingPostalCodeInput: '#BillingNewAddress_ZipPostalCode',
        billingPhoneNumberInput: '#BillingNewAddress_PhoneNumber',
        billingContinueBtn: '#billing-buttons-container > .new-address-next-step-button',
        bilingEditBtn: "#billing-buttons-container > button",
        shippingMethodContinueBtn: '#shipping-method-buttons-container > .button-1',
        paymentMethodContinueBtn: '#payment-method-buttons-container > .button-1',
        paymentInfoContinueBtn: '#payment-info-buttons-container > .button-1',
        confirmBtn: '#confirm-order-buttons-container > .button-1',
        confirmationMsg: '.section > .title'
    }

    UpdateBillingAddress(CountryValue, State, City, Address, PostalCode, PhoneNumber) {

        cy.get(this.weblocator.billingCountryDropedown, { force: true }).select(CountryValue);
        cy.get(this.weblocator.billingStateDropeDown).select(State)
        cy.get(this.weblocator.billingCityInput).type(City)
        cy.get(this.weblocator.billingAddressInput).type(Address)
        cy.get(this.weblocator.billingPostalCodeInput).type(PostalCode)
        cy.get(this.weblocator.billingPhoneNumberInput).type(PhoneNumber)
        cy.get(this.weblocator.billingContinueBtn).click()

    }

    paymentAndConfirmOrder(ConfirmationMsg) {
        cy.get(this.weblocator.shippingMethodContinueBtn).click()
        cy.get(this.weblocator.paymentMethodContinueBtn).should('be.visible').click();
        cy.get(this.weblocator.paymentInfoContinueBtn).should('be.visible').click();
        cy.get(this.weblocator.confirmBtn).click()
        cy.get(this.weblocator.confirmationMsg).should('contain.text', ConfirmationMsg)
    }

}

export default new checkOutPage();
