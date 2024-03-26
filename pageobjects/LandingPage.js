const userdetails = JSON.parse(JSON.stringify(require('../utils/userdetails.json')))

class LandingPage {

    constructor(page) {
        this.page = page
        this.register = page.locator('.ico-register')
        this.login = page.locator('.ico-login')
        this.email = page.locator('#Email')
        this.loginbtn = page.locator('.login-button')
        this.gendermale = page.locator('#gender-male')
        this.firstname = page.locator('#FirstName')
        this.lastname = page.locator('#LastName')
        this.dayList = page.locator("select[name='DateOfBirthDay']")
        this.monthList = page.locator("select[name='DateOfBirthMonth']")
        this.yearList = page.locator("select[name='DateOfBirthYear']")
        this.company = page.locator('#Company')
        this.password = page.locator('#Password')
        this.confirmpassword = page.locator('#ConfirmPassword')
        this.registerbutton = page.locator('#register-button')
        this.useregistered = page.locator('.result')
        this.userexists = page.locator('div.message-error')
        this.usernotfound = page.locator('div.message-error li')
    }

    async goTo() {
        await this.page.goto('/')
    }

    async clickRegistrationLink() {
        await this.register.click()
    }

    async clickLoginLink() {
        await this.login.click()
    }
    async loginuser(useremail) {
        await this.email.fill(useremail)
        await this.password.fill(process.env.PASSWORD)
        await this.loginbtn.click()
    }

    async checkUserUponRegistrationAndValidLogin(useremail) {
        await this.register.click()
        await this.registerNewUser(useremail)
        if (await this.useregistered.isVisible()) {
            return "new"
        }
        if (await this.userexists.isVisible()) {
            return "existing"
        }
    }

    async checkUserUponLoginAndValidLogin(useremail) {
        await this.clickLoginLink()
        await this.loginuser(useremail)
        if (await this.usernotfound.isVisible()) {
            await this.registerNewUser(useremail)
            await this.clickLoginLink()
            await this.loginuser(useremail)
            return "new"
        } else {
            return "existing"
        }
    }

    async registerNewUser(useremail) {
        await this.register.click()
        await this.gendermale.check()
        await this.firstname.fill(userdetails.USER_FIRST_NAME)
        await this.lastname.fill(userdetails.USER_LAST_NAME)
        await this.dayList.selectOption(userdetails.USER_DOB_DAY)
        await this.monthList.selectOption(userdetails.USER_DOB_MONTH)
        await this.yearList.selectOption(userdetails.USER_DOB_YEAR)
        await this.email.fill(useremail)
        await this.company.fill(userdetails.USER_COMPANY)
        await this.password.fill(process.env.PASSWORD)
        await this.confirmpassword.fill(process.env.PASSWORD)
        await this.registerbutton.click()
    }

}
module.exports = { LandingPage }