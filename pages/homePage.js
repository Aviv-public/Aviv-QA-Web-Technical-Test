class homePage {
    openUrl() {
        cy.visit(Cypress.env('URL'));
    }

    webLocator = {
        registerTab: '.ico-register',
        loginTab: '.ico-login',
        headerLogo: '.header-logo > a > img',
        booksCatagories: `.top-menu.notmobile [href='/books']`,
        addToCardBtns: '.button-2.product-box-add-to-cart-button',
        shoppingCart: '.cart-label',
        cartQuantity: '#topcartlink .cart-qty',
    }

    goToBooksCatagories() {
        cy.get(this.webLocator.booksCatagories).click({ force: true });
    }

    clickRigesterTab() {
        cy.get(this.webLocator.registerTab).click()
    }

    clickLoginTab() {
        cy.get(this.webLocator.loginTab).click()
    }

    goToShoppingCart() {
        cy.get(this.webLocator.shoppingCart).click({ force: true })
    }

    validateHeader() {
        cy.get(this.webLocator.headerLogo).should('be.visible')
    }

    clickAddToCardBtn() {
        cy.get(this.webLocator.addToCardBtns).eq(2).should('be.visible').click({ force: true });
    }

    addProductInCart() {
        this.clickAddToCardBtn()
    }
  
}
export default new homePage();
