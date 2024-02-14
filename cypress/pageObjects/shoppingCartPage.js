
class shoppingCartPage {
   elements = {
      countryTextField: () => cy.get('#BillingNewAddress_CountryId'),
      cityTextField: () => cy.get('#BillingNewAddress_City'),
      addressTextField: () => cy.get('#BillingNewAddress_Address1'),
      stateTextField: () => cy.get('#BillingNewAddress_StateProvinceId'),
      zipPostalCodeTextField: () => cy.get('#BillingNewAddress_ZipPostalCode'),
      phoneNumber: () => cy.get('#BillingNewAddress_PhoneNumber'),
      continueButton: () => cy.get('#billing-buttons-container > .new-address-next-step-button'),
      continueButtonForshippingMethod: () => cy.get('#shipping-method-buttons-container > .button-1'),
      continueButtonForPaymentMethod: () => cy.get('#payment-method-buttons-container > .button-1'),
      continueButtonForPaymentInfo: () => cy.get('#payment-info-buttons-container > .button-1'),
      confirmButton: () => cy.get('#confirm-order-buttons-container > .button-1'),
      successMessage: () => cy.get('.order-number > strong'),
      productAddedMessage: () => cy.get('.content'),
      termsConditionscheckbox: () => cy.get('#termsofservice'),
      checkOutButton: () => cy.get('#checkout'),
      ElectronicsTab: () => cy.get('img[alt="Picture for category Electronics"]'),
      OthersTab: () => cy.get('img[alt="Picture for category Others"]'),
      productInfo: () => cy.get('div.details > h2 > a'),
      addToCartButton: () => cy.get('.buttons > .product-box-add-to-cart-button'),
      cartQuantity: () => cy.get('#topcartlink .cart-qty'),
      removeFromCart: () => cy.get(".remove-btn", { timeout: 5000 }),
      appSpinner: () => cy.get(".ajax-loading-block-window"),
      assert1 : ()=> cy.xpath("(//td[@class='product']/a)[1]"),
      assert2 : ()=> cy.xpath("(//td[@class='product']/a)[2]")
   }

   verifyCartQuantity(quantity) {
      this.elements.cartQuantity().should("have.text", `(${quantity})`)
   }

   clickOncheckOut() {
      this.elements.termsConditionscheckbox().check();
      this.elements.checkOutButton().click();
   }
   enterBillingAddress(country, state, city, address, postalCode, phone) {

      this.elements.countryTextField().select(country);
      if (country === 'United States') {
         this.elements.stateTextField().select(state);
      }
      else {
         this.elements.stateTextField().type(state);
      }
      this.elements.cityTextField().type(city);
      this.elements.addressTextField().type(address);
      this.elements.zipPostalCodeTextField().type(postalCode);
      this.elements.phoneNumber().type(phone);
      this.elements.continueButton().click()
      this.elements.continueButtonForshippingMethod().click()
      this.elements.continueButtonForPaymentMethod().click()
      this.elements.continueButtonForPaymentInfo().click()
      this.elements.confirmButton().click()
      this.elements.successMessage().should('exist')
   }

   removeItemsFromCart() {
      cy.intercept('POST', '/cart/estimateshipping?CountryId=1&StateProvinceId=52&ZipPostalCode=23444&City=').as('apiCall');
      cy.intercept('POST', '/shoppingcart/checkoutattributechange?isEditable=True').as('apiCall2');
      cy.wait('@apiCall').then(() => {
         cy.wait('@apiCall2').then(() => {
            cy.get('@beatsSpeaker').then((val) => {
               this.elements.assert1().invoke('text').should('eq', val);
            })
            cy.get('@portableSpeaker').then((val) => {
               this.elements.assert2().invoke('text').should('eq', val);
            })
            this.elements.removeFromCart().then($element => {
               const numberOfElements = $element.length;
               for (let i = 0; i < numberOfElements; i++) {
                  this.elements.appSpinner().should('not.be.visible');
                  this.elements.removeFromCart().eq(i).should('be.visible').trigger('click', { force: true });
                  this.elements.appSpinner().should('not.be.visible');
               }
            });
         })
      })
      this.verifyCartQuantity(0)
   }
}

export default shoppingCartPage;
