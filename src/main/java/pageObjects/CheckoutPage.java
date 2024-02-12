package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutPageTitle = By.xpath("//h1[normalize-space()='Checkout']");
    private final By billingAddressHeader = By.xpath("//h2[normalize-space()='Billing address']");
    private final By countryDropDown = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By cityTxt = By.id("BillingNewAddress_City");
    private final By address1Txt = By.id("BillingNewAddress_Address1");
    private final By zipPostalCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberTxt = By.id("BillingNewAddress_PhoneNumber");
    private final By billingContinueButton = By.cssSelector("button.button-1.new-address-next-step-button");
    private final By shippingContinueButton = By.cssSelector("button.button-1.shipping-method-next-step-button");
    private final By paymentMethodContinueButton = By.cssSelector("button.button-1.payment-method-next-step-button");
    private final By paymentInfoContinueButton = By.cssSelector("button.button-1.payment-info-next-step-button");
    private final By confirmButton = By.cssSelector("button.button-1.confirm-order-next-step-button");

    public boolean confirmCheckoutPageTitle(){
        return confirmElementIsVisible(checkoutPageTitle);
    }
    public boolean confirmBillingAddressHeader(){
        return confirmElementIsVisible(billingAddressHeader);
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
