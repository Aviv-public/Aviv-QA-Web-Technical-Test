import homePage from '../../pages/homePage';
import productPage from '../../pages/productPage';
import shoppingCartPage from '../../pages/shoppingCartPage'
import productData from '../fixtures/productData.json'
describe('Verify Cart Functionality', () => {

    beforeEach(() => {
        homePage.openUrl();
    });
  
    it('should add product to cart and verify the cart', () => { 
        homePage.goToBooksCatagories()
        productPage.addMultipleProductInCartAndVerifyCount()
        homePage.goToShoppingCart()
        shoppingCartPage.modifyCartValueAndVerifyQuantity(productData)
        shoppingCartPage.removeProductFromCart(productData)
        shoppingCartPage.empatyCart(productData)
        shoppingCartPage.verifyEmptyCartValue()
    });
    
});