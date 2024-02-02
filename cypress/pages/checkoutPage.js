class CheckoutPage {
    validateProcessStep() {
      cy.get(".tab-section").should("have.length", 6);
    }
  
    fillAddress(address) {
      cy.get("body").then((body) => {
        if (body.find("#billing-address-select").length > 0) {
          cy.get(
            "#billing-buttons-container > .new-address-next-step-button"
          ).click();
        } else {
          // Element is not visible
          // Add your code for the not visible scenario
          cy.get("#BillingNewAddress_CountryId").select(address.country);
          cy.get("#BillingNewAddress_StateProvinceId").select(address.state);
          cy.get("#BillingNewAddress_City").clear().type(address.city);
          cy.get("#BillingNewAddress_Address1").clear().type(address.address1);
          cy.get("#BillingNewAddress_Address2").clear().type(address.address2);
          cy.get("#BillingNewAddress_ZipPostalCode")
            .clear()
            .type(address.postalCode);
          cy.get("#BillingNewAddress_PhoneNumber").clear().type(address.phone);
          cy.get("#BillingNewAddress_FaxNumber").clear().type(address.fax);
  
          // Submit the form (if there is a submit button)
          cy.get('button[type="submit"]').click();
          cy.get(
            "#billing-buttons-container > .new-address-next-step-button"
          ).click();
        }
      });
    }
  
    selectShippingOption() {
      cy.get("#shippingoption_1").check();
      cy.get(".shipping-method-next-step-button").click();
    }
  
    selectPaymentOption() {
      cy.get("#paymentmethod_0").check();
      cy.get(".payment-method-next-step-button").click();
    }
  
    validateAndProceedFromPaymentInfo() {
      cy.get(".payment-info-next-step-button").click();
    }
  
    confirmCheckoutOrder() {
      cy.get(".confirm-order-next-step-button").click();
    }
  
    validateOrderPlacement(checkout) {
      cy.get(
        ".page-body.checkout-data .section.order-completed .title strong"
      ).should("have.text", checkout.successfulOrder);
  
      // Verify that the order number contains 'Order number:' and matches the regex for order number (assuming \d+ represents the order number)
      cy.get(
        ".page-body.checkout-data .section.order-completed .details .order-number strong"
      )
        .invoke("text")
        .should("match", new RegExp(checkout.orderNumber));
  
      // Verify that the href attribute contains '/orderdetails/' followed by one or more digits
      cy.get(
        ".page-body.checkout-data .section.order-completed .details .details-link a"
      )
        .should("have.attr", "href")
        .and("match", new RegExp(checkout.orderDetails));
    }
  }
  
  export default CheckoutPage;