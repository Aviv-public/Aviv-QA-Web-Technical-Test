class RegisterPage {
    fillRegistrationForm(userDetails) {
      cy.get(`#gender-${userDetails.gender}`).check();
      cy.get("#FirstName").type(userDetails.firstName);
      cy.get("#LastName").type(userDetails.lastName);
      cy.get('select[name="DateOfBirthDay"]').select(userDetails.birthDay);
      cy.get('select[name="DateOfBirthMonth"]').select(userDetails.birthMonth);
      cy.get('select[name="DateOfBirthYear"]').select(userDetails.birthYear);
      cy.get("#Email").type(userDetails.email);
      cy.get("#Password").type(userDetails.password);
      cy.get("#ConfirmPassword").type(userDetails.password);
      cy.get("#register-button").click();
    }
  
    validateNoRegistration(regitrationValidation) {
      cy.get('.field-validation-error[data-valmsg-for="Email"]')
        .invoke("text")
        .should("include", regitrationValidation.wrongEmail);
  
      cy.get('.field-validation-error[data-valmsg-for="Password"]')
        .invoke("text")
        .should("include", regitrationValidation.passwordRules);
    }
  }

  export default RegisterPage;