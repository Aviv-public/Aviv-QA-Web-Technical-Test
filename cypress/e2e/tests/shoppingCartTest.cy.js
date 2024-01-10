import shoppingCartPage from '../../pages/shoppingCartPage'

import signUpPage from '../../pages/signUpPage'

describe('Verify Cart Functionality', () => {

    beforeEach(() => {
        signUpPage.openUrl();
    });
  
    it('adds to cart and verify the cart', () => { 

        shoppingCartPage.addToCart();
        shoppingCartPage.cartUpdated();
        shoppingCartPage.VerifyCart(); 
        shoppingCartPage.CartQuantity();
        shoppingCartPage.CartEmpty();

    });




});