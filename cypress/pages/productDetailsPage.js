class ProductDetailPage{
    updateDetails(product) {
        cy.get("#product_attribute_2").select(product.RAM);
        cy.get("#product_attribute_3_7").check();
    }
    
    addtocart(){
        cy.get(".add-to-cart-button").click();
    }
}

export default ProductDetailPage;