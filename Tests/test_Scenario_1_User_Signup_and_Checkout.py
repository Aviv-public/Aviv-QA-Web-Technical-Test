from conftest import browser, dynamic_email, dynamic_password
from playwright.sync_api import expect
from Pages.registration_page import RegistrationPage, RegistrationSuccessfulPage, RegistrationUnsuccessfulPage
from Pages.login_page import LoginPage
from Pages.home_page import Homepage
from Pages.product_detail_page import ProductDetailPage
from Pages.cart_page import CartPage
from Pages.checkout_page import CheckoutPage
from Pages.shippingmethod_page import ShippingMethodPage
from Pages.payment_method_page import PaymentMethodPage
from Pages.confirm_page import ConfirmPage
from Pages.complete_page import CompletedPage
import pytest


@pytest.mark.parametrize(
    "first_name, last_name, dob_day, dob_month, dob_year, email, password, expected_result",
    [
        ("Romin", "Parvardeh", "17", "1", "1992", None, None, True),  # Valid registration
        ("Invalid", "User", "1", "1", "2000", "invalid_email", "password123", False),  # Invalid registration for scenario 2
    ],
)
def test_user_login(browser, first_name, last_name, dob_day, dob_month, dob_year, email, password, expected_result, dynamic_email, dynamic_password):
    # Registration Page
    registration_page = RegistrationPage(browser.new_page())
    registration_page.navigate_to_registration()

    if email is None:
        email = dynamic_email
        password = dynamic_password

    registration_page.fill_registration_form(
        first_name, last_name, dob_day, dob_month, dob_year, email, password
    )

    registration_page.click_register_button()

    if expected_result:
        # If expected result is True, checks successful registration
        registration_successful_page = RegistrationSuccessfulPage(registration_page.page)
        registration_successful_page.verify_successful_registration()
        registration_successful_page.click_continue_button()
        expect(registration_page.page).to_have_url('https://demo.nopcommerce.com/')
    else:
        # If not , check unsuccessful registration for scenario 2
        registration_unsuccessful_page = RegistrationUnsuccessfulPage(registration_page.page)
        registration_unsuccessful_page.verify_unsuccessful_registration()
        pytest.xfail("Test is expected to fail due to invalid registration")


    # login Page
    login_page = LoginPage(registration_page.page)
    login_page.navigate_to_login()

    login_page.fill_login_form(dynamic_email,  dynamic_password)

    # click on the Login button
    login_page.click_login_submit_button()

    # assert that the URL is the expected homepage URL after login for checking redirecting to the homepage
    expect(login_page.page).to_have_url('https://demo.nopcommerce.com/')

    # homepage - Add a product to the shopping cart
    homepage = Homepage(login_page.page)
    homepage.click_add_to_cart_button()

    # Product Detail Page - Add it to shopping card
    product_detail_page = ProductDetailPage(homepage.page)
    product_detail_page.click_add_to_cart_button()

    product_detail_page.assert_notification_bar_appears()

    # click on the shopping cart button
    product_detail_page.click_shopping_cart_button()

    # Cart Page - Perform checkout
    cart_page = CartPage(product_detail_page.page)
    cart_page.checkout()

    # checkout Page - Fill in billing information and continue
    checkout_page = CheckoutPage(cart_page.page)
    checkout_page.fill_billing_information()
    checkout_page.click_continue_button()

    # Shipping Method Page - continue with shipping method
    shipping_method_page = ShippingMethodPage(checkout_page.page)
    shipping_method_page.click_continue_button()

    # Payment Method Page - Continue with payment method
    payment_method_page = PaymentMethodPage(shipping_method_page.page)
    payment_method_page.click_continue_payment_method_button()

    # Payment Method Page - Continue with payment info
    payment_method_page.click_continue_payment_info_button()


    # Confirm Page - Confirm the order
    confirm_page = ConfirmPage(payment_method_page.page)
    confirm_page.click_confirm_button()

    # Completed Page - Assertions after successful purchase
    completed_page = CompletedPage(confirm_page.page)
    assert completed_page.is_expected_text_present() == True
    completed_page.click_continue_button()
    # TODO: write more comments / improve assersions

