class HomePage {
    visit() {
        cy.visit(Cypress.env("baseUrl"));
    }

    clickOnRegisterButton() {
        cy.get(".ico-register").click();
    }

    validateRegistration(validation) {
        cy.get(".result").should("have.text", validation.registration);
        cy.url().should("include", validation.homePageUrl);
    }

    clickOnLoginButton(){
        cy.get(".ico-login").click();
    }

    clickOnLogOut() {
        cy.get(".ico-logout").click();
    }

    addProduct() {
        cy.get(
            ":nth-child(1) > .product-item > .details > .add-info > .buttons > .product-box-add-to-cart-button"
        ).click();
    }

    clickOnShoppingCart() {
        cy.get(".ico-cart").click();
    }

    navigateToProductListing() {
        cy.contains("Books").click({ force: true });
    }
    
}

export default HomePage;
