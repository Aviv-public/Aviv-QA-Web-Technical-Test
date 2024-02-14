class productDetailsPage {

   elements = {

      productInfo: () => cy.get('div.details > h2 > a'),
      addToCartButton: () => cy.get('.buttons > .product-box-add-to-cart-button'),
      cartQuantity: () => cy.get('#topcartlink .cart-qty'),
      removeFromCart: () => cy.get(".remove-btn"),
      productAddedMessage: () => cy.get('.content'),
      appSpinner: () => cy.get(".ajax-loading-block-window"),
      beatspeaker : () => cy.xpath("(//h2[@class='product-title']/a)[1]"),
      portableSpeaker : () => cy.xpath("(//h2[@class='product-title']/a)[2]"),
      addToCartButton1 : () => cy.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"),
      addToCartButton2 : () => cy.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]")
   }

   verifyCartQuantity(quantity) {
      this.elements.cartQuantity().should("have.text", `(${quantity})`)
   }

   addProductToCart() {
      this.elements.beatspeaker().invoke('text').as("beatsSpeaker");
      this.elements.portableSpeaker().invoke('text').as("portableSpeaker")
      this.elements.addToCartButton1().click()
      this.elements.appSpinner().should('not.be.visible');
      this.elements.addToCartButton2().click()
      this.elements.appSpinner().should('not.be.visible');
      this.verifyCartQuantity(2);
   }


   addProductToCartOld() {
      this.elements.productInfo().then($productDetails => {
         const numElements = $productDetails.length;
         for (let i = 1; i < 4; i++) {
            const randomIndex = Math.floor(Math.random() * numElements);
            this.elements.addToCartButton().then($addToCartDetails => {
               const randomElement = $addToCartDetails[randomIndex];
               cy.wrap(randomElement).click({ force: true });
               this.elements.appSpinner().should('not.be.visible');
               this.elements.productAddedMessage().should('exist')
            })
         }
      })
   }
}

export default productDetailsPage;