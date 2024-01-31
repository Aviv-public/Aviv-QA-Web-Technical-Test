class LoginPage:
    def __init__(self, page):
        self.page = page

    login_button = 'a.ico-login'
    email_field = 'input#Email'
    password_field = 'input#Password'
    remmember_me_checkbox = 'input#RememberMe'
    login_submit_button = 'button.button-1.login-button'

    def navigate_to_login(self):
        login_button = self.page.locator(self.login_button)
        login_button.click()

    def fill_login_form(self, email, password):
        self.page.fill(self.email_field, email)
        self.page.fill(self.password_field, password)
        self.page.check(self.remmember_me_checkbox)

    def click_login_submit_button(self):
        self.page.click(self.login_submit_button)
