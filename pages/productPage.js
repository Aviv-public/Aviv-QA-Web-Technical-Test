import homePage from "./homePage"

class productPage{

    verifyCartQuantity(quantity) {
        cy.get(homePage.webLocator.cartQuantity).should("have.text", `(${quantity})`)
    }

    addMultipleProductInCartAndVerifyCount() {
        cy.get(homePage.webLocator.addToCardBtns).each(($el, index, $list) => {
            this.verifyCartQuantity(index)
            cy.wait(2)
            cy.wrap($el).click();
            this.verifyCartQuantity(index + 1)  
        })
       
    }

}
export default new productPage();
