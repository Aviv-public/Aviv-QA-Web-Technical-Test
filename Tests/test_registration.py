from conftest import browser, dynamic_email, dynamic_password
from playwright.sync_api import expect
from Pages.registration_page import RegistrationPage, RegistrationSuccessfulPage


def test_user_signup_and_checkout(browser, dynamic_email, dynamic_password):
    registration_page = RegistrationPage(browser.new_page())
    registration_page.navigate_to_registration()
    registration_page.fill_registration_form(
        "Romin", "Parvardeh", "17", "1", "1992", dynamic_email,  dynamic_password
    )

    registration_page.click_register_button()
    successful_page = RegistrationSuccessfulPage(registration_page.page)
    successful_page.verify_successful_registration()
    successful_page.click_continue_button()
    expect(registration_page.page).to_have_url('https://demo.nopcommerce.com/')
