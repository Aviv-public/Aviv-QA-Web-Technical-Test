class Homepage:
    def __init__(self, page):
        self.page = page

    # Locators
    add_to_cart_buttons_locator = '.button-2.product-box-add-to-cart-button'

    # Actions
    def click_add_to_cart_button(self):
        add_to_cart_button = self.page.locator(self.add_to_cart_buttons_locator).nth(1)
        add_to_cart_button.click()
