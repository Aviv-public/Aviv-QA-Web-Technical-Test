package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By pageTitle = By.xpath("//h1[normalize-space()='Checkout']");
    By billingAddressTitle = By.xpath("//h2[normalize-space()='Billing address']");
    By countryDropDown = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By cityTxt = By.id("BillingNewAddress_City");
    By address1Txt = By.id("BillingNewAddress_Address1");
    By zipPostalCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumberTxt = By.id("BillingNewAddress_PhoneNumber");
    By billingContinueButton = By.cssSelector("button.button-1.new-address-next-step-button");
    By shippingContinueButton = By.cssSelector("button.button-1.shipping-method-next-step-button");
    By paymentMethodContinueButton = By.cssSelector("button.button-1.payment-method-next-step-button");
    By paymentInfoContinueButton = By.cssSelector("button.button-1.payment-info-next-step-button");
    By confirmButton = By.cssSelector("button.button-1.confirm-order-next-step-button");

    public boolean confirmPageTitle(){
        return confirmElementIsVisible(pageTitle);
    }
    public boolean confirmBillingAddressTitle(){
        return confirmElementIsVisible(billingAddressTitle);
    }
    public boolean selectCountryDropDownValueByText(String countryName){
        return selectElementByText(countryDropDown,countryName);
    }
    public boolean sendKeysToCityTxt(String city){
        return sendKeysToElement(cityTxt,city);
    }

    public boolean sendKeysToAddress1Txt(String address){
        return sendKeysToElement(address1Txt,address);
    }
    public boolean sendKeysZipPostalCodeTxt(String postalCode){
        return sendKeysToElement(zipPostalCodeTxt,postalCode);
    }
    public boolean sendKeysPhoneNumberTxt(String phoneNumber){
        return sendKeysToElement(phoneNumberTxt,phoneNumber);
    }
    public boolean clickBillingContinueButton(){
        return clickElement(billingContinueButton,waitTimes.LONG_WAIT);
    }
    public boolean clickShippingContinueButton(){
        return clickElement(shippingContinueButton,waitTimes.LONG_WAIT);
    }
    public boolean clickPaymentMethodContinueButton(){
        return clickElement(paymentMethodContinueButton);
    }
    public boolean clickPaymentInfoContinueButton(){
        return clickElement(paymentInfoContinueButton);
    }
    public boolean clickConfirmButton(){
        return clickElement(confirmButton);
    }
}
