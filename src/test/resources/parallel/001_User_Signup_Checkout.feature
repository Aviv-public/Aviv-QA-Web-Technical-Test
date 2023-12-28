Feature: 001 Home Page :User signup and checkout -  Check user signup and checkout functionalities are working as expected

  Scenario: User Signup and Checkout
    When user sees element REGISTER
    And user clicks on element REGISTER
    And user sees element REGISTER_MESSAGE
    And user select GENDER_FEMALE
    And user writes value "user" in element FIRSTNAME_INPUT_FIELD
    And user writes value "name" in element LASTNAME_INPUT_FIELD
    And user select value "6" in element BIRTH_DATE
    And user select value "February" in element BIRTH_MONTH
    And user select value "1990" in element BIRTH_YEAR
    And user enters email inside element EMAIL_INPUT_FIELD
    And user writes value "Aviv group" in element COMPANY_NAME_INPUT_FIELD
    And user select NEWSLETTER_CHECKBOX
    And user writes value "Password*1" in element PASSWORD_INPUT_FIELD
    And user writes value "Password*1" in element CONFIRM_PASSWORD_INPUT_FIELD
    And  user clicks on element REGISTER_BUTTON
    Then user sees text "Your registration completed" in element MESSAGE_REGISTRATION_COMPLETED
    When user clicks on element LOG_IN
    And user enters email inside element EMAIL_INPUT_FIELD_LOGIN
    And user writes value "Password*1" in element PASSWORD_FIELD
    And user clicks on element LOGIN_BUTTON
    Then user sees text "Welcome to our store" in element LANDING_PAGE
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