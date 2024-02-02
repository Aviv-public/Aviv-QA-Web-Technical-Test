class ProductListingPage {
    addMultipleProducts() {
        cy.get(".product-item .product-box-add-to-cart-button").each(
            ($el, index, $list) => {
                cy.get("#topcartlink .cart-qty").should("have.text", `(${index})`);
                cy.wrap($el).click();
                cy.get("#topcartlink .cart-qty").should("have.text", `(${index + 1})`);
            }
        );
    }
}

export default ProductListingPage;
