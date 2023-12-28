Feature:004 Verify cart functionality- verify the cart functionality is working as expected

  Scenario: Verify cart functionality
    Then user sees text "Welcome to our store" in element LANDING_PAGE
    When user clicks on element APPLE_MACBOOK_PRO_13_INCH
    And user clicks on element ADD_TO_CART
    And user sees text "The product has been added to your shopping cart" in element ADD_TO_CART_MESSAGE
    And user clicks on element CLOSE_ADD_TO_CART_MESSAGE
    And user clicks on element HOME_MENU
    And user clicks on element HTC_ONE_M8_ANDROID_L_5_0_LOLLIPOP
    And user clicks on element ADD_TO_CART_HTC
    And user clicks on element CLOSE_ADD_TO_CART_MESSAGE
    And user clicks on element SHOPPING_CART_MENU
    Then user expect to see the text "1" in element ITEM_QUANTITY_HTC
    And user sees text "$3,845.00" in element TOTAL_AMOUNT
    And user writes value "3" in element ITEM_QUANTITY_HTC
    And user clicks on element UPDATE_CART
    And user sees text "$4,335.00" in element TOTAL_AMOUNT
    And user expect to see the text "3" in element ITEM_QUANTITY_HTC
    And user sees text "HTC One M8 Android L 5.0 Lollipop" in element HTC_ONE_M8_ANDROID_L_5_0_LOLLIPOP
    And user clicks on element REMOVE_BUTTON_HTC
    And user sees text "$3,600.00" in element TOTAL_AMOUNT

