const { test } = require('@playwright/test')

exports.customtest = test.extend({
    testDataForOrder: {
        useremail: "test3@aviv.com",
        registrationSuccessMessageExpected: 'Your registration completed',
        productAdditionSuccessActual: 'The product has been added to your shopping cart',
        category: "Computers",
        subCategory: "Software",
        productName: "Windows 8 Pro",
        shippingMethod: "Next Day Air ($0.00)",
        country: "Germany",
        state: "Other",
        city: "Berlin",
        address: "Sample Address",
        zipcode: "10965",
        phonenumber: "1234567890",
        orderPlacedSuccessMsg: "Your order has been successfully processed!",
        shippingAddress: "differentFromBilling",
        cardType: "Discover",
        cardHolderName: "sharma",
        cardNumber: "1111222233334444",
        cardExpiryMonth: "01",
        cardExpiryYear: "2025",
        cardCVv: "123",
    }
})

exports.customtestinvaliduseremail = test.extend({
    testDataForInvalidEmail: {
        useremail: "t@t",
        registrationWrongEmail: 'Wrong email'
    }
})

exports.customtestregisterwithoutdata = test.extend({
    registerwithoutdata: {
        firstNameError: 'First name is required.',
        lastNameError: 'Last name is required.',
        emailError: 'Email is required.',
        pwderror: 'Password is required.',
        confirmpwderror: 'Password is required.'
    }
})

exports.customtestmultipleproducts = test.extend({
    multipleproducts: {
        productNameNotebook: "Apple MacBook Pro 13-inch",
        productNameElectronics: "Nikon D5500 DSLR",
        productNameApparel: "Nike Floral Roshe Customized Running Shoes",
        productNameJewelry: "Elegant Gemstone Necklace (rental)",
        rentStartDate: "February-2024-29",
        rentEndDate: "March-2024-29",
        productNameDigitalDownloads: "If You Wait (donation)",
        prouctNameBooks: "Fahrenheit 451 by Ray Bradbury",
        productNameGiftCard: "$25 Virtual Gift Card",
        productAdditionSuccessActual: "The product has been added to your shopping cart",
        productQty: "2",
        modifiedProductQty: "3"
    }
})