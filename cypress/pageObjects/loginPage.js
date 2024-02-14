class loginPage{

    elements = { 
         emailTextField :()=> cy.get('#Email'),
         passwordTextField : () => cy.get('#Password'),
         loginButton : () => cy.get('form > .buttons > .button-1'),
         logOutLink : () => cy.get('.ico-logout')
,             }

     
  enterLoginDetails(email, password){
     this.elements.emailTextField().type(email);
     this.elements.passwordTextField().type(password);
  }
  clickOnLoginButton(){
    this.elements.loginButton().click()
    this.elements.logOutLink().should('exist')
  }

  }
  
  export default loginPage;