class ShoppingCartPage {


    constructor(page) {
        this.page = page
        this.cart = page.locator('table.cart tbody tr')
        this.updatecartbtn = page.locator('button.update-cart-button')
        this.continueshopping = page.locator('button.continue-shopping-button')
        this.estimateshipping = page.locator('a.estimate-shipping-button')
        this.estimateshippingpopup = page.locator('div.estimate-shipping-popup')
        this.shippingdetails = page.locator('div.estimate-shipping-popup')
        this.carttotal = page.locator('table.cart-total')
        this.tnc = page.locator('input#termsofservice')
        this.productnames = page.locator('table.cart tbody tr a.product-name')
    }

    async productDetailsFromCartPage(productNameList, productQty) {
        const productCount = await this.productnames.count()
        for (let i = 0; i < productCount; i++) {
            if (await productNameList[i] === await this.cart.nth(i).locator('a.product-name').textContent()) {
                await this.cart.nth(i).locator('input.qty-input').inputValue() === productQty
            }
        }
    }

    async updateCartWithProductDetails(productName, modifiedProductQty) {
        const productCount = await this.productnames.count()
        for (let i = 0; i < productCount; i++) {
            if (await this.cart.nth(i).locator('a.product-name').textContent() === productName) {
                await this.cart.nth(i).locator('input.qty-input').fill(modifiedProductQty)
                await this.updatecartbtn.click()
                await this.cart.nth(i).locator('input.qty-input').inputValue() === modifiedProductQty
                break
            }
        }
        //await this.cartTotal()
    }

    async removeProductFromCart(productName) {
        const productCount = await this.productnames.count()
        for (let i = 0; i < productCount; i++) {
            if (await this.cart.nth(i).locator('a.product-name').textContent() === productName) {
                await this.cart.nth(i).locator('button.remove-btn').click()
                const updatedProductCount = await this.productnames.count()
                await updatedProductCount === productCount - 1
                break
            }
        }
        //await this.cartTotal()
    }

    async cartTotal() {
        const productCount = await this.productnames.count()
        let productsSum = []
        let actualSum = 0.00
        for (let i = 0; i < productCount; i++) {
            productsSum.push(await this.cart.nth(i).locator('span.product-subtotal').textContent())
        }
        for (let i = 0; i < productsSum.length; i++) {
            let actualPrice = productsSum[i].split("$")[1]
            actualSum = parseInt(actualPrice.replace(",", "")) + actualSum
        }
        let total = await this.carttotal.locator('tr.order-total span.value-summary strong').textContent()
        let actualTotal = total.split("$")[1]
        return actualSum === parseInt(actualTotal.replace(",", ""))
    }


    async continueShopping() {
        await this.continueshopping.click()
    }

    async estimateShipping(country, zipcode, method) {
        await this.estimateshipping.click()
        await this.estimateshippingpopup.isVisible()
        const countryList = await this.shippingdetails.locator('select#CountryId')
        await countryList.selectOption(country).then(() => {
            this.shippingdetails.locator('input#ZipPostalCode').fill(zipcode)
            this.shippingdetails.getByText(method).click().then(() => {
                this.shippingdetails.getByText('Apply').click()
            })
        })
    }

    async acceptTnC() {
        await this.tnc.check()
    }

    async goToCheckout() {
        await this.page.getByRole("button", { name: ' Checkout ' }).click()
    }
}

module.exports = { ShoppingCartPage }