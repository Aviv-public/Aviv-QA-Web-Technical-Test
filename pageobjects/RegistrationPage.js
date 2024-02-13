const userdetails = JSON.parse(JSON.stringify(require('../utils/userdetails.json')))

class RegistrationPage {

    constructor(page) {
        this.page = page
        this.gendermale = page.locator('#gender-male')
        this.firstname = page.locator('#FirstName')
        this.lastname = page.locator('#LastName')
        this.dayList = page.locator("select[name='DateOfBirthDay']")
        this.monthList = page.locator("select[name='DateOfBirthMonth']")
        this.yearList = page.locator("select[name='DateOfBirthYear']")
        this.email = page.locator('#Email')
        this.company = page.locator('#Company')
        this.password = page.locator('#Password')
        this.confirmpassword = page.locator('#ConfirmPassword')
        this.registerbutton = page.locator('#register-button')
        this.registrationsuccessmsg = page.locator('.result')
        this.emailalreadyexists = page.locator('div.message-error')
        this.wrongemail = page.locator('div.message-error ul li')
    }

    async registerUserInvalidEmail(userinvalidemail) {
        await this.gendermale.check()
        await this.firstname.fill(userdetails.USER_FIRST_NAME)
        await this.lastname.fill(userdetails.USER_LAST_NAME)
        await this.dayList.selectOption(userdetails.USER_DOB_DAY)
        await this.monthList.selectOption(userdetails.USER_DOB_MONTH)
        await this.yearList.selectOption(userdetails.USER_DOB_YEAR)
        await this.email.fill(userinvalidemail)
        await this.company.fill(userdetails.USER_COMPANY)
        await this.password.fill(process.env.PASSWORD)
        await this.confirmpassword.fill(process.env.PASSWORD)
        await this.registerbutton.click()
        return await this.wrongemail
    }

    async clickRegisterWithoutEnteringDetails() {
        await this.registerbutton.click()
        const errListMsg = []
        errListMsg.push(await this.page.locator('span#FirstName-error').textContent())
        errListMsg.push(await this.page.locator('span#LastName-error').textContent())
        errListMsg.push(await this.page.locator('span#Email-error').textContent())
        errListMsg.push(await this.page.locator('span#Password-error').textContent())
        errListMsg.push(await this.page.locator('span#ConfirmPassword-error').textContent())
        return errListMsg
    }
}
module.exports = { RegistrationPage }