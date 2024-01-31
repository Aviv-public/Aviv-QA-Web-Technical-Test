import time
class CheckoutPage:
    def __init__(self, page):
        self.page = page

    # Locators
    country_dropdown_locator = 'select#BillingNewAddress_CountryId'
    city_input_locator = 'input#BillingNewAddress_City'
    address1_input_locator = 'input#BillingNewAddress_Address1'
    zipcode_input_locator = 'input#BillingNewAddress_ZipPostalCode'
    phone_number_input_locator = 'input#BillingNewAddress_PhoneNumber'
    continue_button_locator = '#billing-buttons-container'

    # Actions
    def fill_billing_information(self):
        # Choose Germany from the country dropdown
        country_dropdown = self.page.locator(self.country_dropdown_locator)
        country_dropdown.select_option('Germany')


        # Fill in the city
        city_input = self.page.locator(self.city_input_locator)
        city_input.fill('Berlin')

        # Fill in the address1
        address1_input = self.page.locator(self.address1_input_locator)
        address1_input.fill('dernburgstrasse 21')

        # Fill in the zipcode
        zipcode_input = self.page.locator(self.zipcode_input_locator)
        zipcode_input.fill('14055')

        # fill in the phone number
        phone_number_input = self.page.locator(self.phone_number_input_locator)
        phone_number_input.fill('+491638979207')

    def click_continue_button(self):
        continue_button = self.page.locator(self.continue_button_locator)
        continue_button.click()
