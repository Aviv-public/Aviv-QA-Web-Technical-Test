package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum CheckoutPage implements CucumberElement {
    CHECKOUT_TITLE(By.xpath("//h1[contains(text(),'Checkout')]")),
    COUNTRY_DROPDOWN(By.id("BillingNewAddress_CountryId")),
    CITY_INPUT_FIELD(By.id("BillingNewAddress_City")),
    ADDRESSS1_INPUT_FIELD(By.id("BillingNewAddress_Address1")),
    ZIPCODE_INPUT_FIELD(By.id("BillingNewAddress_ZipPostalCode")),
    PHONE_NUMBER_INPUT_FIELD(By.id("BillingNewAddress_PhoneNumber")),
    CONTINUE_CHECKOUT_BUTTON(By.xpath("//button[contains(text(),'Continue')]")),
    GROUND_SHIPPING_METHOD(By.id("shippingoption_0")),
    CONTINUE_SHIPPING_METHOD_BUTTON(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")),
    CHECK_PAYMENT_METHOD_BUTTON(By.id("paymentmethod_0")),
    CREDIT_CARD_PAYMENT_METHOD_BUTTON(By.id("paymentmethod_1")),
    CONTINUE_PAYMENT_METHOD_BUTTON(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")),
    CONTINUE_PAYMENT_INFORMATION_BUTTON(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")),
    CONFIRM_BUTTON(By.xpath("//button[contains(text(),'Confirm')]")),
    THANK_YOU_MESSAGE(By.xpath("//h1[contains(text(),'Thank you')]")),
    ORDER_SUCCESS_MESSAGE(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
    private final By by;
}
