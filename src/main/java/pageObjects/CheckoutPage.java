package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By CHECKOUT_PAGE_TITLE = By.xpath("//h1[normalize-space()='Checkout']");
    private final By BILLING_ADDRESS_HEADER = By.xpath("//h2[normalize-space()='Billing address']");
    private final By SHIPPING_ADDRESS_HEADER = By.xpath("//h2[normalize-space()='Shipping address']");
    private final By SHIPPING_METHOD_HEADER = By.xpath("//h2[normalize-space()='Shipping method']");
    private final By PAYMENT_METHOD_HEADER = By.xpath("//h2[normalize-space()='Payment method']");
    private final By PAYMENT_INFORMATION_HEADER = By.xpath("//h2[normalize-space()='Payment information']");
    private final By CONFIRM_ORDER_HEADER = By.xpath("//h2[normalize-space()='Confirm order']");
    private final By COUNTRY_DROP_DOWN = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By CITY_TEXT_BOX = By.id("BillingNewAddress_City");
    private final By ADDRESS1_TEXT_BOX = By.id("BillingNewAddress_Address1");
    private final By ZIP_POSTAL_CODE_TEXT_BOX = By.id("BillingNewAddress_ZipPostalCode");
    private final By PHONE_NUMBER_TEXT_BOX = By.id("BillingNewAddress_PhoneNumber");
    private final By BILLING_CONTINUE_BUTTON = By.cssSelector("button.button-1.new-address-next-step-button");
    private final By NEXT_DAY_AIR_SHIPPING_METHOD_RADIO_BUTTON = By.id("shippingoption_1");
    private final By SHIPPING_CONTINUE_BUTTON = By.cssSelector("button.button-1.shipping-method-next-step-button");
    private final By CHECK_MONEY_ORDER_RADIO_BUTTON = By.id("paymentmethod_0");
    private final By PAYMENT_METHOD_CONTINUE_BUTTON = By.cssSelector("button.button-1.payment-method-next-step-button");
    private final By PAYMENT_INFO_CONTINUE_BUTTON = By.cssSelector("button.button-1.payment-info-next-step-button");
    private final By CONFIRM_BUTTON = By.cssSelector("button.button-1.confirm-order-next-step-button");

    public boolean confirmCheckoutPageTitleIsVisible(){
        return confirmElementIsVisible(CHECKOUT_PAGE_TITLE);
    }
    public boolean confirmBillingAddressHeaderIsVisible(){
        return confirmElementIsVisible(BILLING_ADDRESS_HEADER);
    }
    public boolean confirmShippingAddressHeaderIsVisible(){
        return confirmElementIsVisible(SHIPPING_ADDRESS_HEADER);
    }
    public boolean confirmShippingMethodHeaderIsVisible(){
        return confirmElementIsVisible(SHIPPING_METHOD_HEADER);
    }
    public boolean confirmPaymentMethodHeaderIsVisible(){
        return confirmElementIsVisible(PAYMENT_METHOD_HEADER);
    }
    public boolean confirmPaymentInformationHeaderIsVisible(){
        return confirmElementIsVisible(PAYMENT_INFORMATION_HEADER);
    }
    public boolean confirmConfirmOrderHeaderIsVisible(){
        return confirmElementIsVisible(CONFIRM_ORDER_HEADER);
    }
    public boolean selectCountryDropDownValueByText(String countryName){
        return selectElementByText(COUNTRY_DROP_DOWN,countryName);
    }
    public boolean sendKeysToCityTxt(String city){
        return sendKeysToElement(CITY_TEXT_BOX,city);
    }

    public boolean sendKeysToAddress1Txt(String address){
        return sendKeysToElement(ADDRESS1_TEXT_BOX,address);
    }
    public boolean sendKeysZipPostalCodeTxt(String postalCode){
        return sendKeysToElement(ZIP_POSTAL_CODE_TEXT_BOX,postalCode);
    }
    public boolean sendKeysPhoneNumberTxt(String phoneNumber){
        return sendKeysToElement(PHONE_NUMBER_TEXT_BOX,phoneNumber);
    }
    public boolean clickBillingContinueButton(){
        return clickElement(BILLING_CONTINUE_BUTTON,waitTimes.LONG_WAIT);
    }
    public boolean clickNextDayAirShippingMethodRadioButton(){
        return clickElement(NEXT_DAY_AIR_SHIPPING_METHOD_RADIO_BUTTON,waitTimes.LONG_WAIT);
    }
    public boolean clickShippingContinueButton(){
        return clickElement(SHIPPING_CONTINUE_BUTTON,waitTimes.LONG_WAIT);
    }
    public boolean clickCheckMoneyOrderRadioButton(){
        return clickElement(CHECK_MONEY_ORDER_RADIO_BUTTON);
    }
    public boolean clickPaymentMethodContinueButton(){
        return clickElement(PAYMENT_METHOD_CONTINUE_BUTTON);
    }
    public boolean clickPaymentInfoContinueButton(){
        return clickElement(PAYMENT_INFO_CONTINUE_BUTTON);
    }
    public boolean clickConfirmButton(){
        return clickElement(CONFIRM_BUTTON);
    }
}
