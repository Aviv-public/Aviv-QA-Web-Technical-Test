class userRegistrationPage {
    openUrl() {
        cy.visit(Cypress.env('URL'));
    }

    weblocator = {
        genderRadio: '#gender-female',
        registerLink: '.ico-register',
        firstNameInput: '#FirstName',
        lastNameInput: '#LastName',
        dateDropeDown: `[name='DateOfBirthDay']`,
        monthDropeDown: `[name='DateOfBirthMonth']`,
        yearDropeDown: `[name='DateOfBirthYear']`,
        emailInput: '#Email',
        passwordInput: '#Password',
        confirmPasswordInput: '#ConfirmPassword',
        registerButton: '#register-button',
        successfullRegistratioMsg: '.result',
        continueBtn: '.buttons > .button-1',
        confirmedPasswordErrorMessage: '#ConfirmPassword-error'
    }


    EnterDetails(FirstName, LastName, Email, Password, ConfirmPassword) {
        cy.get(this.weblocator.genderRadio).click()
        cy.get(this.weblocator.firstNameInput).type(FirstName)
        cy.get(this.weblocator.lastNameInput).type(LastName)
        cy.get(this.weblocator.dateDropeDown).select
        cy.get(this.weblocator.monthDropeDown).select
        cy.get(this.weblocator.yearDropeDown).select
        cy.get(this.weblocator.emailInput).type(Email)
        cy.get(this.weblocator.passwordInput).type(Password)
        cy.get(this.weblocator.confirmPasswordInput).type(ConfirmPassword)
        cy.get(this.weblocator.registerButton).click()
    }
    verifyRegistrationSuccesfulMsg(regSuccMsg) {
        cy.get(this.weblocator.successfullRegistratioMsg).should('contain.text', regSuccMsg)
        cy.get(this.weblocator.continueBtn).click()
    }

    verifyConfirmPasswordErrorMsg(confirmPassErrMsg) {
        cy.get(this.weblocator.confirmedPasswordErrorMessage).should('contain.text', confirmPassErrMsg)
        cy.get(this.weblocator.continueBtn).click()
    }

    UpdateShippingAddress(CountryValue, City, State, Address, PostalCode, PhoneNumber) {

        cy.get(this.weblocator.BillingCountry, { force: true }).select(CountryValue);
        cy.get(this.weblocator.BillingCity).type(City)
        cy.get(this.weblocator.BillingState).select(State)
        cy.get(this.weblocator.BillingNewAddress).type(Address)
        cy.get(this.weblocator.BillingPostalAddress).type(PostalCode)
        cy.get(this.weblocator.BillingPhoneNumber).type(PhoneNumber)
        cy.get(this.weblocator.ContinueButton).click()
    }

    ShippingMethod(ConfirmationMsg) {

        cy.get(this.weblocator.Cntinue).click()
        cy.get(this.weblocator.continue).click({ force: true });
        cy.get(this.weblocator.cntn).should('be.visible').click();
        cy.get(this.weblocator.CNTN).should('be.visible').click();
        cy.get(this.weblocator.Confirm).click()
        cy.get(this.weblocator.ConfirmationMsg).should('contain.text', ConfirmationMsg)
    }

}

export default new userRegistrationPage();
