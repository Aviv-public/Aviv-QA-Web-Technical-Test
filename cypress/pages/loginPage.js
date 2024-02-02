class LoginPage {
    performLogin(user) {
        cy.get("#Email").type(user.email);
        cy.get("#Password").type(user.password);
        cy.get(".login-button").click();
    }
}

export default LoginPage;