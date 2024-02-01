from playwright.sync_api import Page

class PaymentMethodPage:
    def __init__(self, page: Page):
        self.page = page

    # Locators
    payment_method_continue_button_locator = '.button-1.payment-method-next-step-button'
    payment_info_continue_button_locator = '.button-1.payment-info-next-step-button'

    def click_continue_payment_method_button(self):
        continue_button = self.page.locator(self.payment_method_continue_button_locator)
        continue_button.click()

    def click_continue_payment_info_button(self):
        continue_button = self.page.locator(self.payment_info_continue_button_locator)
        continue_button.click()


