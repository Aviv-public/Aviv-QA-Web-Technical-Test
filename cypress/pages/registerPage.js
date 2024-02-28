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
  firstNameError = "#FirstName-error";
  lastNameError = "#LastName-error";
  emailError = "#Email-error";
  passwordError = "#Password-error";
  confirmPasswordError = "#ConfirmPassword-error";
  emailExistsError = "div.message-error";
  passwordDontMatchError = "#ConfirmPassword-error";

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
  clickRegisterButton() {
    cy.get(this.registerButton).click();
  }
  navigateToRegisterPage() {
    cy.get(this.registerLink).click();
  }
  validateTheRequiredFieldsOnEmptyForm() {
    cy.get(this.firstNameError)
      .should("be.visible")
      .should("have.text", "First name is required.");
    cy.get(this.lastNameError).should("have.text", "Last name is required.");
    cy.get(this.emailError).should("have.text", "Email is required.");
    cy.get(this.passwordError).should("have.text", "Password is required.");
    cy.get(this.confirmPasswordError).should(
      "have.text",
      "Password is required."
    );
  }
  validateEmailAlreadyExists() {
    cy.get(this.emailExistsError).should(
      "include.text",
      "The specified email already exists"
    );
  }
  validatePasswordDontMatchMessage() {
    cy.get(this.passwordDontMatchError).should(
      "have.text",
      "The password and confirmation password do not match."
    );
  }
}
export default Register;
