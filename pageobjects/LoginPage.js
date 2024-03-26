class LoginPage {


    constructor(page) {
        this.page = page
        this.email = page.locator('#Email')
        this.password = page.locator('#Password')
        this.loginbtn = page.locator('.login-button')
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
        this.login = page.locator('.ico-login')
    }

    async loginuser(useremail) {
        await this.email.fill(useremail)
        await this.password.fill(process.env.PASSWORD)
        await this.loginbtn.click()
    }
}

module.exports = { LoginPage }