import pytest
from playwright.sync_api import sync_playwright, expect

@pytest.fixture
def browser():
    with sync_playwright() as p:
        browser = p.chromium.launch(headless=False, slow_mo=100)
        yield browser
        browser.close()

def test_user_signup_and_checkout(browser):
    # Open the website
    page = browser.new_page()
    page.goto("https://demo.nopcommerce.com/")
    register_button = page.locator('.ico-register')
    register_button.click()

    page.check('input#gender-male')

    # Fill in the First Name
    # Locators
    first_name_locator = 'input#FirstName'
    last_name_locator = 'input#LastName'
    dob_day_locator = 'select[name="DateOfBirthDay"]'
    dob_month_locator = 'select[name="DateOfBirthMonth"]'
    dob_year_locator = 'select[name="DateOfBirthYear"]'
    email_locator = 'input#Email'
    password_locator = 'input#Password'
    confirm_password_locator = 'input#ConfirmPassword'
    register_button_locator = 'button#register-button'

    # Locators for Registration Completion Page
    registration_title_locator = 'h1'
    registration_result_locator = 'div.result'
    continue_button_locator = 'a.button-1.register-continue-button'

    # Values
    first_name_value = 'Romin'
    last_name_value = 'Parvardeh'
    dob_day_value = '17'
    dob_month_value = '1'
    dob_year_value = '1992'
    email_value = 'romin.parvardeh+126@gmail.com'
    password_value = 'AvivGroupChallange!234'

    # Actions
    page.fill(first_name_locator, first_name_value)
    page.fill(last_name_locator, last_name_value)
    page.select_option(dob_day_locator, dob_day_value)
    page.select_option(dob_month_locator, dob_month_value)
    page.select_option(dob_year_locator, dob_year_value)
    page.fill(email_locator, email_value)
    page.fill(password_locator, password_value)
    page.fill(confirm_password_locator, password_value)

    # click on the Register button
    page.click(register_button_locator)


    # Assert the title
    assert page.locator(registration_title_locator).inner_text() == 'Register'

    # Assert the registration result text
    assert page.locator(registration_result_locator).inner_text() == 'Your registration completed'

    # Click on the Continue button
    page.click(continue_button_locator)
    # Assert that the URL is the expected homepage URL
    expect(page).to_have_url('https://demo.nopcommerce.com/')
