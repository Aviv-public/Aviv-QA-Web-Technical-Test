class RegistrationPage:
    def __init__(self, page):
        self.page = page

    # Locators
    first_name_locator = 'input#FirstName'
    last_name_locator = 'input#LastName'
    dob_day_locator = 'select[name="DateOfBirthDay"]'
    dob_month_locator = 'select[name="DateOfBirthMonth"]'
    dob_year_locator = 'select[name="DateOfBirthYear"]'
    email_locator = 'input#Email'
    password_locator = 'input#Password'
    confirm_password_locator = 'input#ConfirmPassword'
    register_button_locator = 'button#register-button'
    register_button = '.ico-register'
    gender_male_radio_locator = 'input#gender-male'

    def navigate_to_registration(self):
        self.page.goto("https://demo.nopcommerce.com/")
        register_button = self.page.locator(self.register_button)
        register_button.click()

    def fill_registration_form(self, first_name, last_name, dob_day, dob_month, dob_year, email, password):
        self.page.check(self.gender_male_radio_locator)
        self.page.fill(self.first_name_locator, first_name)
        self.page.fill(self.last_name_locator, last_name)
        self.page.select_option(self.dob_day_locator, dob_day)
        self.page.select_option(self.dob_month_locator, dob_month)
        self.page.select_option(self.dob_year_locator, dob_year)
        self.page.fill(self.email_locator, email)
        self.page.fill(self.password_locator, password)
        self.page.fill(self.confirm_password_locator, password)

    def click_register_button(self):
        self.page.click(self.register_button_locator)


class RegistrationSuccessfulPage:
    def __init__(self, page):
        self.page = page

    title = 'h1'
    registration_result = 'div.result'
    continue_button = 'a.button-1.register-continue-button'

    def verify_successful_registration(self):
        assert self.page.locator(self.title).inner_text() == 'Register'
        # assert the registration result text
        assert self.page.locator(self.registration_result).inner_text() == 'Your registration completed'

    def click_continue_button(self):
        self.page.click(self.continue_button)

class RegistrationUnsuccessfulPage:
    def __init__(self, page):
        self.page = page

    error_message_locator = '.field-validation-error[data-valmsg-for="Email"]'
    def verify_unsuccessful_registration(self):
        assert self.page.locator(self.error_message_locator).inner_text() == 'Wrong email'