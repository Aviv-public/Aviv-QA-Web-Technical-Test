class userLoginCheckoutPage{

webLocator={

            Login:'.ico-login',
            Email:'#Email',
            Password:'#Password',
            LoginButton:'.login-button',
            Product:':nth-child(3) > .product-item > .details > .add-info > .buttons > .product-box-add-to-cart-button',
            Cart:'.cart-label',
            CheckOutButton:'.checkout-button',
            TermsOfService:'#termsofservice',
            CheckOut:'#checkout',
            BillingCountry:'#BillingNewAddress_CountryId',
            BillingCity:'#BillingNewAddress_City',
            BillingState:'#BillingNewAddress_StateProvinceId',
            BillingNewAddress:'#BillingNewAddress_Address1',
            BillingPostalAddress:'#BillingNewAddress_ZipPostalCode',
            BillingPhoneNumber:'#BillingNewAddress_PhoneNumber',
            ContinueButton:'#billing-buttons-container > .new-address-next-step-button',
            ShippingMethod:'[data-value="Ground"]',
            Cntinue:'#shipping-method-buttons-container > .button-1',
            PaymentMethod:'#payment-method-list',
            continue:'#shipping-method-buttons-container > .button-1',
            cntn:'#payment-method-buttons-container > .button-1',
            CNTN:'#payment-info-buttons-container > .button-1',
            Confirm:'#confirm-order-buttons-container > .button-1',
            ConfirmationMsg:'.section > .title'
            
            
}

LoginWithUser(Email,Password){
    cy.get(this.webLocator.Login).click()
    cy.get(this.webLocator.Email).type(Email)
    cy.get(this.webLocator.Password).type(Password)
    cy.get(this.webLocator.LoginButton).click() 
}

    AddtoCart(){
        cy.get(this.webLocator.Product).first().click();
        cy.get(this.webLocator.Cart).click();
        cy.get(this.webLocator.TermsOfService).click();
        cy.get(this.webLocator.CheckOutButton).click()
        
    }

   UpdateShippingAddress(CountryValue,City, State,Address,PostalCode,PhoneNumber){

   
    cy.get(this.webLocator.BillingCountry, { force: true }).select(CountryValue);
    cy.get(this.webLocator.BillingCity).type(City)
    cy.get(this.webLocator.BillingState).select(State)
    cy.get(this.webLocator.BillingNewAddress).type(Address)
    cy.get(this.webLocator.BillingPostalAddress).type(PostalCode)
    cy.get(this.webLocator.BillingPhoneNumber).type(PhoneNumber)
    cy.get(this.webLocator.ContinueButton).click()
   }


ShippingMethod(ConfirmationMsg){

  
    cy.get(this.webLocator.Cntinue).click()
 
    cy.get(this.webLocator.continue).click({ force: true });
    cy.get(this.webLocator.cntn).should('be.visible').click();
    cy.get(this.webLocator.CNTN).should('be.visible').click();

    cy.get(this.webLocator.Confirm).click()
    cy.get(this.webLocator.ConfirmationMsg).should('contain.text', ConfirmationMsg)
}


}

export default new userLoginCheckoutPage();