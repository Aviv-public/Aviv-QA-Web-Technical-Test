from playwright.sync_api import Page

class ShippingMethodPage:
    def __init__(self, page: Page):
        self.page = page
        self.shipping_method_continue_button_locator = '.button-1.shipping-method-next-step-button'

    def click_continue_button(self):
        continue_button = self.page.locator(self.shipping_method_continue_button_locator)
        continue_button.click()