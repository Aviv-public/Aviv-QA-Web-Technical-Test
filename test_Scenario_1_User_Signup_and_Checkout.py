import pytest
from conftest import browser, dynamic_email, dynamic_password
from playwright.sync_api import sync_playwright, expect
from registration_page import RegistrationPage
from login_page import LoginPage
from home_page import Homepage
from product_detail_page import ProductDetailPage
from cart_page import CartPage
from checkout_page import CheckoutPage
from shippingmethod_page import ShippingMethodPage
from payment_method_page import PaymentMethodPage
from confirm_page import ConfirmPage
from complete_page import CompletedPage
import time



def test_user_login(browser, dynamic_email, dynamic_password):
    # Registration Page
    registration_page = RegistrationPage(browser.new_page())
    registration_page.navigate_to_registration()

    registration_page.fill_registration_form(
        "Romin", "Parvardeh", "17", "1", "1992", dynamic_email,  dynamic_password
    )

    registration_page.click_register_button()

    # login Page
    login_page = LoginPage(registration_page.page)
    login_page.navigate_to_login()

    login_page.fill_login_form(dynamic_email,  dynamic_password)


    # click on the Login button
    login_page.click_login_submit_button()

    # Assert that the URL is the expected homepage URL after login
    expect(login_page.page).to_have_url('https://demo.nopcommerce.com/')

 # homepage - Add a product to the shopping cart
    homepage = Homepage(login_page.page)
    homepage.click_add_to_cart_button()

    # Product Detail Page - Add the same product to the shopping cart again
    product_detail_page = ProductDetailPage(homepage.page)
    product_detail_page.click_add_to_cart_button()

    product_detail_page.assert_notification_bar_appears()

    # Click on the shopping cart button
    product_detail_page.click_shopping_cart_button()

    # Cart Page - Perform checkout
    cart_page = CartPage(product_detail_page.page)
    cart_page.checkout()

# checkout Page - Fill in billing information and continue
    checkout_page = CheckoutPage(cart_page.page)
    checkout_page.fill_billing_information()
    checkout_page.click_continue_button()

    # Shipping Method Page - Continue with shipping method
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
    # TODO: write more comments / improve assersions / make the structure of the folders

