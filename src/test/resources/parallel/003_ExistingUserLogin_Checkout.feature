Feature:003 Existing User Login and Checkout- Check the Existing User Login and Checkout functionality working as expected

  Scenario: Existing User Login and Checkout
    Given user is logged in
    When user clicks on element APPLE_MACBOOK_PRO_13_INCH
    And user clicks on element ADD_TO_CART
    Then user sees text "The product has been added to your shopping cart" in element ADD_TO_CART_MESSAGE
    And user clicks on element CLOSE_ADD_TO_CART_MESSAGE
    When user clicks on element SHOPPING_CART_MENU
    And user sees text "Apple MacBook Pro 13" in element PRODUCT_NAME
    And user select TERMS_OF_SERVICE
    And user clicks on element CHECK_OUT_BUTTON
    Then user sees text "Checkout" in element CHECKOUT_TITLE
    When user select value "Germany" in element COUNTRY_DROPDOWN
    And user writes value "Berlin" in element CITY_INPUT_FIELD
    And user writes value "berlin strasse" in element ADDRESSS1_INPUT_FIELD
    And user writes value "12345" in element ZIPCODE_INPUT_FIELD
    And user writes value "+491234789" in element PHONE_NUMBER_INPUT_FIELD
    And user clicks on element CONTINUE_CHECKOUT_BUTTON
    And user select GROUND_SHIPPING_METHOD
    And user clicks on element CONTINUE_SHIPPING_METHOD_BUTTON
    And user select CHECK_PAYMENT_METHOD_BUTTON
    And user clicks on element CONTINUE_PAYMENT_METHOD_BUTTON
    And user clicks on element CONTINUE_PAYMENT_INFORMATION_BUTTON
    And user clicks on element CONFIRM_BUTTON
    Then user sees text "Thank you" in element THANK_YOU_MESSAGE
    And user sees text "Your order has been successfully processed!" in element ORDER_SUCCESS_MESSAGE