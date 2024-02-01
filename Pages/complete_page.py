from playwright.sync_api import Page

class CompletedPage:
    def __init__(self, page: Page):
        self.page = page

    # Locators
    title_locator = '.title strong'
    order_number_locator = '.order-number strong'
    details_link_locator = '.details-link a'
    continue_button_locator = '.button-1.order-completed-continue-button'
    page_container_locator = '.page.checkout-page.order-completed-page'
    expected_text = 'Your order has been successfully processed!'

    def is_page_visible(self):
        # check if the page container is visible
        page_container = self.page.locator(self.page_container_locator)
        return page_container.is_visible()

    def is_expected_text_present(self):
        # check if the expected text is present in the page
        return self.expected_text in self.page.locator(self.page_container_locator).inner_text()

    def get_order_number(self):
        # get the inner text of the order number, extract the integer, and return it
        order_number_element = self.page.locator(self.order_number_locator)
        order_number_text = order_number_element.inner_text()
        order_number = int(order_number_text.split()[-1])
        print(order_number)
        return order_number

    def click_details_link(self):
        # click on the "Click here for order details" link
        details_link = self.page.locator(self.details_link_locator)
        details_link.click()

    def click_continue_button(self):
        continue_button = self.page.locator(self.continue_button_locator)
        continue_button.click()
