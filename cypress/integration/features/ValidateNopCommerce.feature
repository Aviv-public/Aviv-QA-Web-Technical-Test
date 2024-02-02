Feature: Testing of Ecommerce website for Sigup, SignIn and Checkout

    Scenario: User Signup and Checkout

        Given Navigate to the website
        When Click on the Register link
        When Fill in valid information for a new user
        Then Verify successful registration and redirection to the homepage
        When Log in with valid user credentials
        When Add a product to the shopping cart
        When Proceed to the checkout process
        Then Verify the checkout process steps: Cart, Address, Shipping, Payment
        When Fill in valid shipping information
        When Choose a shipping method
        When Select a payment method
        When Complete the purchase
        When Verify successful purchase and user confirmation
        Then Logout from portal

    Scenario: Invalid Signup Attempt
    
        Given Navigate to the website
        When Click on the Register link
        When Fill in invalid information for a new user
        Then Verify the user is not registered, and an appropriate error message is displayed

    Scenario: Existing User Login and Checkout

        Given Navigate to the website
        When Log in with valid user credentials
        When Add a product to the shopping cart
        When Proceed to the checkout process
        Then Verify the checkout process steps: Cart, Address, Shipping, Payment
        When Fill in valid shipping information
        When Choose a shipping method
        When Select a payment method
        When Complete the purchase
        When Verify successful purchase and user confirmation
        Then Logout from portal

    Scenario: Verify Cart Functionality

        Given Navigate to the website
        When Add multiple products to the shopping cart
        Then Verify correct products and quantities in the shopping cart
        When Modify the quantity of a product
        When Remove a product from the cart
        Then Verify the cart is updated accordingly
