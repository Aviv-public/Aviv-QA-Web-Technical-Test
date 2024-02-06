import homePage from "./homePage";

class loginPage {

    webLocator = {
        emailInput: '#Email',
        passwordInput: '#Password',
        loginButton: '.login-button',
    }

    loginWithValidUser(Email, Password) {
        homePage.clickLoginTab()
        cy.get(this.webLocator.emailInput).type(Email)
        cy.get(this.webLocator.passwordInput).type(Password)
        cy.get(this.webLocator.loginButton).click()
        cy.wait(3)
    }

}

export default new loginPage();