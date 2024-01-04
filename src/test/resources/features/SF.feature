Feature: AVIV Feature

  @AVIVTest
  Scenario: User Signup and Checkout
#    Given I connect to the database
    Given I am on homepage url "BaseURL"
    Then I click "Register" button of "AVIV_Registration".""
    When I enter "FirstName" in "FirstName" field of "AVIV_Registration".""
    When I enter "LastName" in "LastName" field of "AVIV_Registration".""
    When I enter "Email" in "Email" field of "AVIV_Registration".""
    When I enter "Password" in "Password" field of "AVIV_Registration".""
    When I enter "ConfirmPassword" in "ConfirmPassword" field of "AVIV_Registration".""
    Then I click "Register_Button" button of "AVIV_Registration".""
    And User waits for "Reg_verification" element to be "displayed" in "AVIV_Registration"."(Continue on Failure)"
    Then I click "Continue" button of "AVIV_Registration"."(Continue on Failure)"
    Then I click "Log in" button of "AVIV_Registration".""
    When I enter "Email" in "Email" field of "AVIV_LoginPage".""
    When I enter "Password" in "Password" field of "AVIV_LoginPage".""
    Then I click "Login_Button" button of "AVIV_LoginPage".""
    And User waits for "Log out" element to be "displayed" in "AVIV_LoginPage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And I select "3" from "Product RAM" of "AVIV_HomePage"
    Then I click "HDD" button of "AVIV_HomePage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Shopping Cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "termsofservice" button of "AVIV_CheckoutPage".""
    Then I click "checkout" button of "AVIV_CheckoutPage".""
    Then I click "Edit" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    And User waits for sleep time
    Then I click "termsofservice" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    Then I click "checkout" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    And I select "127" from "Country" of "AVIV_CheckoutPage"
    When I enter "City" in "City" field of "AVIV_CheckoutPage".""
    When I enter "Address" in "Address" field of "AVIV_CheckoutPage".""
    When I enter "ZipCode" in "ZipCode" field of "AVIV_CheckoutPage".""
    When I enter "PhNo" in "PhNo" field of "AVIV_CheckoutPage".""
    Then I click "Continue" button of "AVIV_CheckoutPage".""
    Then I click "Shipping_Continue" button of "AVIV_CheckoutPage".""
    Then I click "Payment_Continue" button of "AVIV_CheckoutPage".""
    Then I click "PayInfo_Continue" button of "AVIV_CheckoutPage".""
    Then I click "Confirm" button of "AVIV_CheckoutPage".""
    And User waits for "Success" element to be "displayed" in "AVIV_CheckoutPage".""

  @AVIVTest
  Scenario Outline: Invalid Signup Attempt
    Given I am on homepage url "BaseURL"
    Then I click "Register" button of "AVIV_Registration".""
    When User enters <FirstName> in "FirstName" field of "AVIV_Registration".""
    When User enters <LastName> in "LastName" field of "AVIV_Registration".""
    When User enters <Email> in "Email" field of "AVIV_Registration".""
    When User enters <Password> in "Password" field of "AVIV_Registration".""
    When User enters <ConfirmPassword> in "ConfirmPassword" field of "AVIV_Registration".""
    Then I click "Register_Button" button of "AVIV_Registration".""
    And User waits for "Reg_Failure" element to be "displayed" in "AVIV_Registration"."(Continue on Failure)"
    Examples:
      | FirstName | LastName  | Email             | Password  | ConfirmPassword |
      | "John"    | "Doe"     | "email@gmail.com" | "Pass123" | "Pass123"       |
      | "Alice"   | "Smith"   | "email@gmail.com" | "Pass456" | "Pass456"       |
      | "Bob"     | "Johnson" | "email@gmail.com" | "Pass789" | "Pass789"       |

  @AVIVTest
  Scenario: Existing User Login and Checkout
    Given I am on homepage url "BaseURL"
    Then I click "Log in" button of "AVIV_Registration".""
    When I enter "Email" in "Email" field of "AVIV_LoginPage".""
    When I enter "Password" in "Password" field of "AVIV_LoginPage".""
    Then I click "Login_Button" button of "AVIV_LoginPage".""
    And User waits for "Log out" element to be "displayed" in "AVIV_LoginPage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And I select "3" from "Product RAM" of "AVIV_HomePage"
    Then I click "HDD" button of "AVIV_HomePage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
#    And User waits for "Cart_Success" element to be "displayed" in "AVIV_HomePage"
#    Then I click "Close_CartSuccess" button of "AVIV_HomePage"
    And User waits for sleep time
    Then I click "Shopping Cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "termsofservice" button of "AVIV_CheckoutPage".""
    Then I click "checkout" button of "AVIV_CheckoutPage".""
    Then I click "Edit" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    And User waits for sleep time
    And I select "127" from "Country" of "AVIV_CheckoutPage"
    When I enter "City" in "City" field of "AVIV_CheckoutPage".""
    When User generates random "long" value and enters in "Address" field of "AVIV_CheckoutPage"
    And User reads "Attribute" and stores "Address" of "AVIV_CheckoutPage"
    When I enter "ZipCode" in "ZipCode" field of "AVIV_CheckoutPage".""
    When User generates random "long" value and enters in "PhNo" field of "AVIV_CheckoutPage"
    And User reads "Attribute" and stores "PhNo" of "AVIV_CheckoutPage"
    Then I click "Continue" button of "AVIV_CheckoutPage".""
    Then I click "Shipping_Continue" button of "AVIV_CheckoutPage".""
    Then I click "Payment_Continue" button of "AVIV_CheckoutPage".""
    Then I click "PayInfo_Continue" button of "AVIV_CheckoutPage".""
#    Then I click "Shipping_Continue" button of "AVIV_CheckoutPage"
    Then I click "Confirm" button of "AVIV_CheckoutPage".""
    And User waits for "Success" element to be "displayed" in "AVIV_CheckoutPage".""
    And User reads "text" and stores "OrderNo" of "AVIV_CheckoutPage"


  @AVIVTest
  Scenario: Verify Cart Functionality
    Given I am on homepage url "BaseURL"
    Then I click "Log in" button of "AVIV_Registration".""
    When I enter "Email" in "Email" field of "AVIV_LoginPage".""
    When I enter "Password" in "Password" field of "AVIV_LoginPage".""
    Then I click "Login_Button" button of "AVIV_LoginPage".""
    And User waits for "Log out" element to be "displayed" in "AVIV_LoginPage".""
    Then I click "electronics" button of "AVIV_HomePage".""
    Then I click "Camera Category" button of "AVIV_HomePage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Apparel" button of "AVIV_HomePage".""
    Then I click "Shoe Category" button of "AVIV_HomePage".""
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And I select "23" from "Shoe Size" of "AVIV_HomePage"
    Then I click "Add to cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Shopping Cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Remove" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Edit Product" button of "AVIV_CheckoutPage".""
    When I enter "Product Quantity" in "Product Quantity" field of "AVIV_HomePage".""
    Then I click "Update" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then I click "Shopping Cart" button of "AVIV_HomePage".""
    And User waits for sleep time
    Then User verify if "ItemQuantity" is "displayed" in "AVIV_CheckoutPage".""
    Then I click "termsofservice" button of "AVIV_CheckoutPage".""
    Then I click "checkout" button of "AVIV_CheckoutPage".""
    And User waits for sleep time
    Then I click "Edit" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    And User waits for sleep time
#    Then I click "termsofservice" button of "AVIV_CheckoutPage"."(Continue on Failure)"
#    Then I click "checkout" button of "AVIV_CheckoutPage"."(Continue on Failure)"
    And I select "127" from "Country" of "AVIV_CheckoutPage"
    When I enter "City" in "City" field of "AVIV_CheckoutPage".""
    When User generates random "long" value and enters in "Address" field of "AVIV_CheckoutPage"
    And User reads "Attribute" and stores "Address" of "AVIV_CheckoutPage"
    When I enter "ZipCode" in "ZipCode" field of "AVIV_CheckoutPage".""
    When User generates random "long" value and enters in "PhNo" field of "AVIV_CheckoutPage"
    And User reads "Attribute" and stores "PhNo" of "AVIV_CheckoutPage"
    Then I click "Continue" button of "AVIV_CheckoutPage".""
    Then I click "Shipping_Continue" button of "AVIV_CheckoutPage".""
    Then I click "Payment_Continue" button of "AVIV_CheckoutPage".""
    Then I click "PayInfo_Continue" button of "AVIV_CheckoutPage".""
    Then I click "Confirm" button of "AVIV_CheckoutPage".""
    And User waits for "Success" element to be "displayed" in "AVIV_CheckoutPage".""
    And User reads "text" and stores "OrderNo" of "AVIV_CheckoutPage"


