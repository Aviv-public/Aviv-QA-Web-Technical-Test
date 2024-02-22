class Register {
    registerLink = "a.ico-register";
    firstName = "input[id='FirstName']";
    lastName = "input[id='LastName']";
    email = "input[id='Email']";
    password = "input[id='Password']";
    confirmPassword = "input[id='ConfirmPassword']";
    registerButton = "button[id='register-button']";
    registerConfirmationMessage = "div[class='result']";
    continueButton = "a.register-continue-button";
  
    verifyLogin() {
      cy.get(this.registerConfirmationMessage).should(
        "have.text",
        "Your registration completed"
      );
    }
    redirectToHomePage() {
      cy.get(this.continueButton).click();
    }
    registerNewUser({ firstName, lastName, email, password, confirmPassword }) {
      cy.get(this.registerLink).click();
      cy.get(this.firstName).type(firstName);
      cy.get(this.lastName).type(lastName);
      cy.get(this.email).type(email);
      cy.get(this.password).type(password);
      cy.get(this.confirmPassword).type(confirmPassword);
      cy.get(this.registerButton).click();
    }
  }
  export default Register;
  