class shoppingCartPage{

    webLocator ={ 
        
    
       ComputerCategory: '.mobile > :nth-child(1) > [href="/computers"]',
       SubCategory:':nth-child(1) > .sub-category-item > .title > a',
       AddToCart: ':nth-child(2) > .product-item > .details > .add-info > .buttons > .product-box-add-to-cart-button',
       Notification: '.bar-notification',
       GoToCart: '.cart-label',
       CartQuantity:'.qty-input',
       RemoveFromCart:'.remove-from-cart',
       Product :'.product-name',
       cartData:'.no-data',
       CartItem:'.cart-item',
       EmptyCartMessage: 'Your Shopping Cart is empty!'
    
        
        
    };


    addToCart(){

    cy.get(this.webLocator.ComputerCategory).click({ force: true });
    cy.get(this.webLocator.SubCategory).click()
    cy.get(this.webLocator.AddToCart).click();

        
    }

   cartUpdated(){

   cy.get(this.webLocator.Notification).should('be.visible').and('contain.text', 'The product has been added to your shopping cart');
   cy.get(this.webLocator.GoToCart).trigger('mouseover')
   cy.get(this.webLocator.GoToCart).contains('Shopping cart').click();

   }
   VerifyCart(){
    
    cy.get(this.webLocator.Product).should('have.text', 'Digital Storm VANQUISH 3 Custom Performance PC');
 }
   CartQuantity(){

    cy.get(this.webLocator.CartQuantity).first().clear().type('3');
    cy.get(this.webLocator.RemoveFromCart).eq(1).click(); 
   }
CartEmpty(){

   cy.get(this.webLocator.CartItem).should('have.length', 0);
   cy.contains(this.webLocator.EmptyCartMessage).should('exist');
   
}

}


export default new shoppingCartPage();

