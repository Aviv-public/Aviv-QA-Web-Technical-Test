class Cart {
  homePageAddtoCartButton = "button.product-box-add-to-cart-button:eq(0)";
  productPageAddToCartButton = "#add-to-cart-button-1";
  ramDropdown = "select[name='product_attribute_2']";
  hddRadio = "select[name='product_attribute_3']";
  termsOfServiceCheckbox = "#termsofservice";
  checkoutButtonId = "#checkout";
  billingAddressCountry = "#BillingNewAddress_CountryId";
  city = "#BillingNewAddress_City";
  address = "#BillingNewAddress_Address1";
  zipCode = "#BillingNewAddress_ZipPostalCode";
  phoneNumber = "#BillingNewAddress_PhoneNumber";
  continueButton = "button[name='save']:eq(0)";
  NextDayAirShippingOption = "#shippingoption_1";
  ShippingMethodContinueBtn = "button.shipping-method-next-step-button";
  payByCardOption = "#paymentmethod_1";
  paymentMethodContniueBtn = "#payment-method-buttons-container button";
  cardHolderName = "#CardholderName";
  cardNumber = "#CardNumber";
  expireMonth = "#ExpireMonth";
  expireYear = "#ExpireYear";
  cardCode = "#CardCode";
  cardInfoContinueBtn = "#payment-info-buttons-container button";
  confirmOrderContinueBtn = "button.confirm-order-next-step-button";
  orderConfirmationMessage = "div.title strong";

  addToCart(productTitle) {
    cy.get("div.product-grid").scrollIntoView();
    cy.contains(".product-title a", productTitle)
      .parents(".product-item")
      .find(".button-2.product-box-add-to-cart-button")
      .click();
  }
  AddRamHDDToComputer() {
    cy.get(this.ramDropdown).select("2 GB");
    cy.get("#product_attribute_3_6").check("6");
    cy.get(this.productPageAddToCartButton).click();
  }
  VerifyAddToCartSuccess() {
    cy.get(".content").should(
      "have.text",
      "The product has been added to your shopping cart"
    );
    cy.get("span.close").click();
  }

  goToCart() {
    cy.get(".cart-label").click();
    cy.url().should("eq", "https://demo.nopcommerce.com/cart"); // => true
  }

  checkTermsAndConditions() {
    cy.get(this.termsOfServiceCheckbox).check();
    cy.get(this.checkoutButtonId).click();
  }
  enterBillingDetails({
    country = "",
    city = "",
    streetAddress = "",
    zipcode = "",
    phoneNumber = "",
  }) {
    cy.get(this.billingAddressCountry).select(country);
    cy.get(this.city).type(city);
    cy.get(this.address).type(streetAddress);
    cy.get(this.zipCode).type(zipcode);
    cy.get(this.phoneNumber).type(phoneNumber);
    cy.get(this.continueButton).click();
  }
  SelectBillingAddressFromAddBook() {
    cy.get("#billing-new-address-form").then(($el) => {
      if ($el.is(":visible")) {
        this.enterBillingDetails({
          country: "Germany",
          city: "Berlin",
          streetAddress: "test",
          zipcode: "5432",
          phoneNumber: "434503988",
        });
      } else {
        cy.get(this.continueButton).click();
      }
    });
  }
  selectShippingMethodAndContinue() {
    cy.get(this.NextDayAirShippingOption).check();
    cy.get(this.ShippingMethodContinueBtn).click();
  }

  payByCard() {
    cy.get(this.payByCardOption).check();
    cy.get(this.paymentMethodContniueBtn).click();
  }

  enterCardDetails() {
    let cardInfo = {
      cardHolderName: "test",
      cardNumber: "3566000020000410",
      expireMonth: "02",
      expireYear: "2026",
      cardCode: "123",
    };
    cy.get(this.cardHolderName).type(cardInfo.cardHolderName);
    cy.get(this.cardNumber).type(cardInfo.cardNumber);
    cy.get(this.expireMonth).select(cardInfo.expireMonth);
    cy.get(this.expireYear).select(cardInfo.expireYear);
    cy.get(this.cardCode).type(cardInfo.cardCode);
    cy.get(this.cardInfoContinueBtn).click();
  }
  confirmOrder() {
    cy.get(this.confirmOrderContinueBtn).click();
  }
  verifySuccessfulPurchase() {
    cy.get(this.orderConfirmationMessage).should(
      "contain",
      "Your order has been successfully processed"
    );
  }
}
export default Cart;
