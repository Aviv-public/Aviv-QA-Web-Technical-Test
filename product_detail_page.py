class ProductDetailPage:
    def __init__(self, page):
        self.page = page

    # Locators
    add_to_cart_button_locator = '.button-1.add-to-cart-button'
    notification_bar_locator = '#bar-notification'
    shopping_cart_button_locator = '#topcartlink a'
    notification_close_button_locator = '.bar-notification.success .close'

    # Actions
    def click_add_to_cart_button(self):
        add_to_cart_button = self.page.locator(self.add_to_cart_button_locator)
        add_to_cart_button.click()

    def assert_notification_bar_appears(self):
        notification_bar = self.page.locator(self.notification_bar_locator)
        notification_bar.wait_for()
        assert notification_bar.is_visible(), "Notification bar did not appear after adding the product."
        notification_close_button = self.page.locator(self.notification_close_button_locator)
        notification_close_button.click()


    def click_shopping_cart_button(self):
        shopping_cart_button = self.page.locator(self.shopping_cart_button_locator)
        shopping_cart_button.click()
