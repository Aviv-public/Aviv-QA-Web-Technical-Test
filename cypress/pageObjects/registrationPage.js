class registrationPage{

    elements = { 
         
         genderMaleRadioButton : () => cy.get('#gender-male'),
         genderFemaleRadioButton : () => cy.get('#gender-female'),
         firstNameTextField : () => cy.get('#FirstName'),
         lastNameTextField : () => cy.get('#LastName'),
         dateOfDOBDropDown :()=> cy.get('[name="DateOfBirthDay"]'),
         monthOfDOBDropDown :()=> cy.get('[name="DateOfBirthMonth"]'),
         yearOfDOBDropDown : ()=> cy.get('[name="DateOfBirthYear"]'),
         emailTextButton : () => cy.get('#Email'),
         companyNameTextField : () => cy.get('#Company'),
         newsLetterCheckBox : ()=> cy.get('#Newsletter'),
         passwordField : () => cy.get('#Password'),
         confirmpasswordField : () => cy.get('#ConfirmPassword'),
         registerButton : () => cy.get('#register-button'),
         successMessage : () => cy.get('.result'),
         errorMessage : () => cy.get('.message-error.validation-summary-errors'),
         fNameErrorMessage : () => cy.get('#FirstName-error'),
         lNameErrorMessage : () => cy.get('#LastName-error'),
         emailErrorMessage : () => cy.get('#Email-error'),
         passwordErrorMessage : () => cy.get('#Password-error'),

     }

     enterPersonalDetails(gender, fName, lName, dayInDOB, monthInDOB, yearInDOB, email, companyName, newsLetter , password){
        if(gender=="Male"){
            this.elements.genderMaleRadioButton().click();
        }           
        else
        {
        this.elements.genderFemaleRadioButton().click();
        }
        this.elements.firstNameTextField().type(fName);
        this.elements.lastNameTextField().type(lName);
        this.elements.dateOfDOBDropDown().select(dayInDOB);
        this.elements.monthOfDOBDropDown().select(monthInDOB);
        this.elements.yearOfDOBDropDown().select(yearInDOB);
        this.elements.emailTextButton().type(email)
        this.elements.companyNameTextField().type(companyName);
        if(newsLetter=="True"){
        this.elements.newsLetterCheckBox().check();
        }
        else{
        this.elements.newsLetterCheckBox().uncheck();
        }
        this.elements.passwordField().type(password)
        this.elements.confirmpasswordField().type(password)
     }

     clickOnRegisterButton(){
        this.elements.registerButton().click();
         this.elements.successMessage().should('be.visible')
     }

     enterInvalidRegistrationDetails(email, password){
        this.elements.emailTextButton().type(email);
        this.elements.passwordField().type(password);
        this.elements.confirmpasswordField().type(password);
     }
     clickOnRegisterButtonForInvalidData(){
        this.elements.registerButton().click();
         this.elements.fNameErrorMessage().should('be.visible')
         this.elements.lNameErrorMessage().should('be.visible')
         this.elements.emailErrorMessage().should('be.visible')
         this.elements.passwordErrorMessage().should('be.visible')
     }
    


  }
  
  export default registrationPage;