    class signUpPage {
        openUrl(){

            cy.visit(Cypress.env('URL'));

        }

        weblocator ={

            Register: '.ico-register',
            Gender: '#gender-female',
            FirstName: '#FirstName',
            LastName: '#LastName',
            Email:'#Email',
            Password:'#Password',
            ConfirmPassword:'#ConfirmPassword',
            RegisterButton:'#register-button',
            Result:'.result',
            Continue:'.buttons > .button-1',
            Header:'.header-logo > a > img',
            Login:'.ico-login',
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
    clickRegister(){

        
            cy.get(this.weblocator.Register).click()
            cy.get(this.weblocator.Gender).click()
    }

    EnterDetails(FirstName,LastName,Email, Password, ConfirmPassword){

        cy.get(this.weblocator.FirstName).type(FirstName)
        cy.get(this.weblocator.LastName).type(LastName)
        cy.get(this.weblocator.Email).type(Email)
        cy.get(this.weblocator.Password).type(Password)
        cy.get(this.weblocator.ConfirmPassword).type(ConfirmPassword)

    }
    ClickFinalRegisteration(){
        cy.get(this.weblocator.RegisterButton).click()
        cy.get(this.weblocator.Result).should('contain.text','Your registration completed')
        cy.get(this.weblocator.Continue).click()

    }
    ValidateHeader(){
        cy.get(this.weblocator.Header).should('be.visible')
    }

    LoginWithUser(Email,Password){
        cy.get(this.weblocator.Login).click()
        cy.get(this.weblocator.Email).type(Email)
        cy.get(this.weblocator.Password).type(Password)
        cy.get(this.weblocator.LoginButton).click() 
    }

        AddtoCart(){
            cy.get(this.weblocator.Product).first().click();
            cy.get(this.weblocator.Cart).click();
            cy.get(this.weblocator.TermsOfService).click();
            cy.get(this.weblocator.CheckOutButton).click()
            
        }

       UpdateShippingAddress(CountryValue,City, State,Address,PostalCode,PhoneNumber){

       
        cy.get(this.weblocator.BillingCountry, { force: true }).select(CountryValue);
        cy.get(this.weblocator.BillingCity).type(City)
        cy.get(this.weblocator.BillingState).select(State)
        cy.get(this.weblocator.BillingNewAddress).type(Address)
        cy.get(this.weblocator.BillingPostalAddress).type(PostalCode)
        cy.get(this.weblocator.BillingPhoneNumber).type(PhoneNumber)
        cy.get(this.weblocator.ContinueButton).click()
       }
    
    
    ShippingMethod(ConfirmationMsg){

      
        cy.get(this.weblocator.Cntinue).click()
     
        cy.get(this.weblocator.continue).click({ force: true });
        cy.get(this.weblocator.cntn).should('be.visible').click();
        cy.get(this.weblocator.CNTN).should('be.visible').click();

        cy.get(this.weblocator.Confirm).click()
        cy.get(this.weblocator.ConfirmationMsg).should('contain.text', ConfirmationMsg)
    }



  
}

    export default new signUpPage();
    