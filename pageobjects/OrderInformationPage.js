class OrderInformationPage {


    constructor(page) {
        this.page = page
        this.ordercompleted = page.locator('div.page.checkout-page.order-completed-page')
        this.orderdetail = page.locator('div.page-body')
        this.ordernumber = page.locator('div.details')
    }


    async orderPlacedSuccessMsg() {
        return await this.ordercompleted.locator('strong').nth(0).textContent()
    }

    async getOrder() {
        if (await this.ordernumber.locator('strong').isEnabled()) {
            const orderText = await this.ordernumber.locator('strong').first().textContent()
            return await orderText.split(": ")[1]
        }
    }

    async openAndValidationOrder(orderNumber) {
        await this.page.locator("a[href*='" + orderNumber + "']").click()
        if (await this.orderdetail.locator('div.order-number strong').isEnabled()) {
            const ordText = await this.orderdetail.locator('div.order-number strong').textContent()
            return await ordText.split("#")[1]
        }
    }
}
module.exports = { OrderInformationPage }