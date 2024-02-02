class ShoppingCartPage {
    agreeAndContinueCheckout() {
      cy.get("#termsofservice").check();
      cy.get("#checkout").click();
    }
  
    validateProductAndQuantity(cartValidator) {
      // Validate product name
      cartValidator.productValidations.forEach((productValidation) => {
        // Validate product name
        cy.contains(".product-name", productValidation.productName).should(
          "exist"
        );
  
        // Use within to scope the search within the specific row
        cy.contains(".product-name", productValidation.productName)
          .parent("td")
          .parent("tr")
          .within(() => {
            // Use find to locate the quantity input within the row
            cy.get(".quantity input").should(
              "have.value",
              productValidation.productQuantity.toString()
            );
          });
      });
    }
  
    modifyQuantityOfTheProduct(product) {
      cy.contains(".product-name", product.productValidations[0].productName)
        .parent("td.product")
        .siblings("td.quantity")
        .find("input")
        .clear()
        .type(product.productValidations[0].updatedQuantity.toString());
  
      cy.get("#updatecart").click();
    }
  
    removeProductFromCart(product) {
      cy.contains(".product-name", product.productValidations[1].productName)
        .parents("tr")
        .find('.remove-from-cart input[type="checkbox"]')
        .check({ force: true });
  
      // Click the "Update shopping cart" button
  
      cy.get("#updatecart").click();
    }

    validateCart(products) {
        products.productValidations.forEach((product) => {
            if(!product.productRemoval){
                cy.contains('.product-name', product.productName)
                .parent('td.product')
                .siblings('td.quantity')
                .find('.qty-input')
                .should('have.value', product.updatedQuantity.toString());
            }
        });
    }
}
  
export default ShoppingCartPage;