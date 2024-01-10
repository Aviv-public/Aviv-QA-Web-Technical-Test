class invalidSignUpPage {
    

     webLocator ={ 
        
            RegisterLink: '.ico-register',
            FirstName: '#FirstName',
            LastName: '#LastName',
            Email: '#Email',
            Password: '#Password',
            ConfirmPasswrd: '#ConfirmPassword',
            RegisterButton: '#register-button',
            ErrorMessage: '#ConfirmPassword-error'
           
            
        };
    

    

    fillInvalidRegistrationForm(FirstName,LastName,Email, Password,ConfirmPasswrd) {
        cy.get(this.webLocator.FirstName).type(FirstName);
        cy.get(this.webLocator.LastName).type(LastName);
        cy.get(this.webLocator.Email).type(Email);
        cy.get(this.webLocator.Password).type(Password);
        cy.get(this.webLocator.ConfirmPasswrd).type(ConfirmPasswrd);
        cy.get(this.webLocator.RegisterButton).click();
    }

    getErrorMessages() {
        cy.get(this.webLocator.ErrorMessage).should('contain', 'The password and confirmation password do not match.');
    }
}

export default new invalidSignUpPage();