Feature: 002 Home Page Feature:Invalid signup attempt- Check the invalid signup functionality is working as expected

  Scenario: User Signup and Checkout
    When user sees element REGISTER
    And user clicks on element REGISTER
    And user sees element REGISTER_MESSAGE
    And user select GENDER_FEMALE
    And user writes value "user" in element FIRSTNAME_INPUT_FIELD
    And user writes value "name" in element LASTNAME_INPUT_FIELD
    And user writes value "email" in element EMAIL_INPUT_FIELD
    And user select value "6" in element BIRTH_DATE
    And user select value "February" in element BIRTH_MONTH
    And user select value "1990" in element BIRTH_YEAR
    And user writes value "Aviv group" in element COMPANY_NAME_INPUT_FIELD
    And user select NEWSLETTER_CHECKBOX
    And user writes value "Applefruit*1" in element PASSWORD_INPUT_FIELD
    And user writes value "Applefruit*13434" in element CONFIRM_PASSWORD_INPUT_FIELD
    And  user clicks on element REGISTER_BUTTON
    Then user sees text "Wrong email" in element EMAIL_ERROR_MESSAGE
    And user sees text "The password and confirmation password do not match." in element CONFIRM_PASSWORD_ERROR_MESSAGE
