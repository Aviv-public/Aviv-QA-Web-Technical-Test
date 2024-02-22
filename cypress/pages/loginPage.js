import Register from "../pages/registerPage";
const register = new Register();
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
    Auth(email, password) {
        // Check for login error
        this.login(email, password);
        cy.url().then((currentUrl) => {
          if (currentUrl === "https://demo.nopcommerce.com/login?returnurl=%2F") {
            register.registerNewUser({
              firstName: "Ayesha",
              lastName: "Raheed",
              email: "ayesha@gmail.com",
              password: "ayeshamysis2",
              confirmPassword: "ayeshamysis2",
            });
    
            // Optionally, redirect to the home page after registration
            register.redirectToHomePage();
            this.login(email, password);
          } else {
            // No error message, continue with your logic
            cy.visit("https://demo.nopcommerce.com/");
          }
        });
      }
  }
  export default Login;