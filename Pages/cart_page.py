class CartPage:
    def __init__(self, page):
        self.page = page

    # Locators
    terms_and_condition_checkbox_locator = 'input#termsofservice'
    checkout_button_locator = 'button#checkout'

    # Actions
    def checkout(self):
        # Check the terms and conditions checkbox
        terms_and_condition_checkbox = self.page.locator(self.terms_and_condition_checkbox_locator)
        terms_and_condition_checkbox.check()

        checkout_button = self.page.locator(self.checkout_button_locator)
        checkout_button.click()
