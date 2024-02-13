const products = JSON.parse(JSON.stringify(require('../utils/products.json')))

class DepartmentPage {


    constructor(page) {
        this.page = page
        this.addtocart = page.locator('.add-to-cart-button')
        this.productaddsuccessmsg = page.locator('p.content')
        this.enterpriceinput = page.locator('.enter-price-input')
        this.recipientname = page.locator('.recipient-name')
        this.sendername = page.locator('.sender-name')
        this.recipientemail = page.locator('.recipient-email')
        this.senderemail = page.locator('.sender-email')
        this.rentstartdate = page.locator('input#rental_start_date_40')
        this.datepickermonth = page.locator('span.ui-datepicker-month')
        this.datepickeryear = page.locator('span.ui-datepicker-year')
        this.next = page.locator("a[data-handler='next']")
        this.rentenddate = page.locator('input#rental_end_date_40')
        this.itembox = page.locator('.item-box')
        this.qtyinput = page.locator('.qty-input')
        this.color = page.locator('.attribute-square')
        this.inputqty = page.locator('input.qty-input')
        this.cameravariantname = page.locator('div.variant-name')
    }

    async selectedCameraVariation() {
        return await this.cameraVariation
    }

    async selectProductOption(attribute, option) {
        const productSpecificationList = await this.page.locator("select[name='product_attribute_" + attribute + "']")
        await productSpecificationList.selectOption(option)
    }

    async checkProductRadioBtn(attribute, index) {
        const hddList = await this.page.locator("input[name ='product_attribute_" + attribute + "']")
        await hddList.nth(index).click()
    }
    async enterCustomProductText(attribute, text) {
        await this.page.locator("input[name ='product_attribute_" + attribute + "']").fill(text)
    }

    async addToCart() {
        await this.addtocart.click()
    }
    async productAdditionSuccessMsg() {
        return await this.productaddsuccessmsg
    }
    async clickOnShoppingCart() {
        await this.page.getByRole('link', { name: 'shopping cart', exact: true }).click()
    }

    async clickOnCategoryAndAddToCart(category, productText, productQty) {
        await this.page.getByRole('link', { name: "" + category + "" }).first().click()
        await this.itembox.filter({ hasText: "" + productText + "" }).getByRole('button', { name: 'Add to cart' }).first().click()

        if (productText === products.DIGITAL_DOWNLOAD_PRODUCT__1 || productText === products.DIGITAL_DOWNLOAD_PRODUCT__2) {
            await this.enterpriceinput.fill(products.DIGITAL_DOWNLOAD_PRODUCT__PRICE_INPUT)
            await this.page.locator('input.qty-input').fill(productQty)
            await this.addToCart()
        }
        if (productText === products.GIFT_CARD_PRODUCT_1 || productText === products.GIFT_CARD_PRODUCT_2) {
            await this.recipientname.fill(products.GIFT_CARD_RECIPIENT_NAME)
            await this.sendername.fill(products.GIFT_CARD_SENDER_NAME)
            await this.inputqty.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.GIFT_CARD_PRODUCT_3) {
            await this.recipientname.fill(products.GIFT_CARD_RECIPIENT_NAME)
            await this.recipientemail.fill(products.GIFT_CARD_RECIPIENT_EMAIL)
            await this.sendername.fill(products.GIFT_CARD_SENDER_NAME)
            await this.senderemail.fill(products.GIFT_CARD_SENDER_EMAIL)
            await this.inputqty.fill(productQty)
            await this.addToCart()
        }
    }

    async clickOnCategoryAndRent(category, productText, startDate, endDate, productQty) {
        await this.page.getByRole('link', { name: "" + category + "" }).first().click()
        await this.itembox.filter({ hasText: "" + productText + "" }).getByRole('button', { name: 'Rent' }).first().click()
        if (productText === products.JEWELRY_PRODUCT_1) {
            await this.rentstartdate.click()
            while (!(await this.datepickermonth.textContent() === startDate.split("-")[0] && await this.datepickeryear.textContent() === startDate.split("-")[1])) {
                await this.next.click()
            }
            await this.page.locator("a[data-date='" + startDate.split("-")[2] + "']").click()
            await this.rentenddate.click()
            while (!(await this.datepickermonth.textContent() === endDate.split("-")[0] && await this.datepickeryear.textContent() === endDate.split("-")[1])) {
                await this.page.locator("a[data-handler='next']").click()
            }
            await this.page.locator("a[data-date='" + endDate.split("-")[2] + "']").click()
            await this.inputqty.fill(productQty)
            await this.addToCart()
        }
    }

    async clickOnSubcategoryAndAddToCart(category, subcategory, productText, productQty) {
        await this.page.getByRole('link', { name: "" + category + "" }).first().hover()
        await this.page.getByRole('link', { name: "" + subcategory + "" }).click()
        await this.itembox.filter({ hasText: "" + productText + "" }).getByRole('button', { name: 'Add to cart' }).waitFor()
        await this.itembox.filter({ hasText: "" + productText + "" }).getByRole('button', { name: 'Add to cart' }).first().click()

        if (productText === products.DESKTOP_BYOC) {
            await this.selectProductOption(1, products.DESKTOP_PROCESSOR)
            await this.selectProductOption(2, products.DESKTOP_RAM)
            await this.checkProductRadioBtn(3, "1")
            await this.inputqty.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.NOTEBOOK_PRODUCT_1) {
            await this.qtyinput.fill("")
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.CAMERA_PRODUCT_1) {
            await this.qtyinput.nth(0).fill(productQty)
            this.cameraVariation = await this.cameravariantname.nth(0).textContent()
            await this.addtocart.nth(0).click()
            await this.selectedCameraVariation()
        }
        if (productText === products.SHOES_PRODUCT_1) {
            await this.selectProductOption(9, products.SHOES_PRODUCT_1_SIZE)
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.SHOES_PRODUCT_2) {
            await this.selectProductOption(6, products.SHOES_PRODUCT_2_SIZE)
            await this.selectProductOption(7, products.SHOES_PRODUCT_2_COLOR)
            await this.color.nth(1).click()
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.APPAREL_PRODUCT_1) {
            await this.enterCustomProductText(12, products.APPAREL_PRODUCT_1_CUSTOM_TEXT)
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.APPAREL_PRODUCT_2) {
            await this.selectProductOption(11, products.APPAREL_PRODUCT_2_SIZE)
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
        if (productText === products.ACCESSORIES_PRODUCT_1) {
            await this.selectProductOption(13, products.ACCESSORIES_PRODUCT_1_SIZE)
            await this.qtyinput.fill(productQty)
            await this.addToCart()
        }
    }
}
module.exports = { DepartmentPage }