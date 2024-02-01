from playwright.sync_api import Page

class ConfirmPage:
    def __init__(self, page: Page):
        self.page = page
        self.confirm_button_locator = '.button-1.confirm-order-next-step-button'

    def click_confirm_button(self):
        confirm_button = self.page.locator(self.confirm_button_locator)
        confirm_button.click()
