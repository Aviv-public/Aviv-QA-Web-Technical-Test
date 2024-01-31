import pytest
from conftest import browser
from playwright.sync_api import sync_playwright, expect
from registration_page import RegistrationPage, RegistrationSuccessfulPage
import time

@pytest.fixture(params=[("Romin", "Parvardeh", "17", "1", "1992", "romin.parvardeh+134@gmail.com", "AvivGroupChallange!234")])
def registration_data(request):
    return request.param

def test_user_signup_and_checkout(browser, registration_data):
    registration_page = RegistrationPage(browser.new_page())
    registration_page.navigate_to_registration()
    #  parameterization values
    first_name_value, last_name_value, dob_day_value, dob_month_value, dob_year_value, email_value, password_value = registration_data
    # fill Registration Form
    registration_page.fill_registration_form(
        first_name_value, last_name_value, dob_day_value,
        dob_month_value, dob_year_value, email_value, password_value
    )
    registration_page.click_register_button()
    successful_page = RegistrationSuccessfulPage(registration_page.page)
    successful_page.verify_successful_registration()
    successful_page.click_continue_button()
    expect(registration_page.page).to_have_url('https://demo.nopcommerce.com/')
