class homePage{

    elements = { 
         
         registrationLink : ()=> cy.get('.ico-register'),  
         loginLink : () => cy.get('.ico-login'),
         wishListLink : () => cy.get('.wishlist-label'),
         addToCartButton : () => cy.get(':nth-child(3) > .product-item > .details > .add-info > .buttons > .product-box-add-to-cart-button'),
         shoppingCartLink : () => cy.get('#topcartlink'),
         termsConditionscheckbox :()=> cy.get('#termsofservice'),
         checkOutButton:()=> cy.get('#checkout'),
         ElectronicsTab :()=> cy.get('img[alt="Picture for category Electronics"]'),
         OthersTab :()=> cy.get('img[alt="Picture for category Others"]'),
         productInfo:()=> cy.get('div.details > h2 > a'),
         addToCartButton : () => cy.get('.buttons > .product-box-add-to-cart-button'),
         cartQuantity: () =>cy.get('#topcartlink .cart-qty'),
         removeFromCart : ()=> cy.get(".remove-btn")
      }

     clickOnRegister (){
      this.elements.registrationLink().click();
     }
     clickOnLogin (){
        this.elements.loginLink().click();
     }
     clickOnWishList(){
        this.elements.wishListLink().click();
     }
     clickOnElectronics(){
      this.elements.ElectronicsTab().click();
      this.elements.OthersTab().click();
     }
     goToShoppingCart()
     {
      this.elements.shoppingCartLink().click();
     }
   }
  export default homePage;