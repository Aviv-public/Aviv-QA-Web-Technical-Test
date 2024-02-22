class Login {
    loginLink = "a.ico-login";
    email = "input[id='Email']";
    password = "input[id='Password']";
    loginButton = "button.login-button";
  
    login(email, password) {
      cy.get(this.loginLink).click();
      cy.get(this.email).type(email);
      cy.get(this.password).type(password);
      cy.get(this.loginButton).click();
    }
  }
  export default Login;