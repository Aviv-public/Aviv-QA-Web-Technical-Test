class Homepage:
    def __init__(self, page):
        self.page = page

    # Locators
    add_to_cart_buttons_locator = '.button-2.product-box-add-to-cart-button'
    books_menu_locator = 'ul.top-menu.notmobile > li > a[href="/books"]'

    def click_add_to_cart_button(self):
        add_to_cart_button = self.page.locator(self.add_to_cart_buttons_locator).nth(1)
        add_to_cart_button.click()

    # From the webside Top menu, click on books
    def click_books_menu(self):
        self.page.click(self.books_menu_locator)


