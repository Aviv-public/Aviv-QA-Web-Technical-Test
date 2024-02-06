import homePage from "./homePage";
class shoppingCartPage {

   webLocator = {

      termsOfServiceCheckbox: '#termsofservice',
      checkOutBtn: '#checkout',
      eachProductQuantity: '.qty-input',
      removeFromCartBtn: 'td.remove-from-cart',
      productName: '.product-name',
      emptyCartMessage: 'Your Shopping Cart is empty!',
      updateShoppingCartBtn: '#updatecart'

   };


   clickTermsOfServiceCheckbox() {
      cy.get(this.webLocator.termsOfServiceCheckbox).click()
   }

   clickCheckOutButton() {
      cy.get(this.webLocator.checkOutBtn).click()
   }


   modifyCartValueAndVerifyQuantity(product) {
      let expectedcartvalue = 0
      product.productDetails.forEach((product) => {
         cy.log(product.name)
         cy.contains(this.webLocator.productName, product.name).should("exist")
         cy.contains(this.webLocator.productName, product.name)
            .closest('tr')
            .find('td.quantity .qty-input')
            .clear()
            .type(product.newquantity)
         expectedcartvalue = expectedcartvalue + product.newquantity;
      })
      cy.log(expectedcartvalue)
      cy.get(this.webLocator.updateShoppingCartBtn).click()
      cy.get(homePage.webLocator.cartQuantity).should("have.text", `(${expectedcartvalue})`)
   }

   removeProductFromCart(productData) {
      productData.productDetails.forEach((product) => {
         cy.contains(this.webLocator.productName, product.name).should("exist")
         if (product.remove) {
            cy.contains(this.webLocator.productName, product.name)
               .closest('tr')
               .find('td.remove-from-cart > button')
               .click({ force: true })
            cy.wait(2)
         }
      })
   }

   empatyCart(productData) {
      productData.productDetails.forEach((product) => {
         cy.contains(this.webLocator.productName, product.name).should("exist")
         cy.contains(this.webLocator.productName, product.name)
            .closest('tr')
            .find('td.remove-from-cart > button')
            .click()
         cy.wait(2)
      })
   }

   verifyEmptyCartValue() {
      cy.get(homePage.webLocator.cartQuantity).should("have.text", `(${0})`)
   }

}

export default new shoppingCartPage();

