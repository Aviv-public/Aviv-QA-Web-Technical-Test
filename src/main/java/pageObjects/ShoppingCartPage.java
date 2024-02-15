package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By SHOPPING_CART_PAGE_TITLE = By.xpath("//h1[normalize-space()='Shopping cart']");
    private final By TERM_OF_SERVICE_CHECKBOX = By.name("termsofservice");
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By UPDATE_SHOPPING_CART_BUTTON = By.id("updatecart");

    private By getProductQuantity_byGivenProductName(String productName){
        return By.xpath("//td[contains(., '" + productName + "')]/following-sibling::td[@class='quantity']//input[@class='qty-input']");

    }

    private By getRemoveButton_byGivenProductName(String productName){
        return By.xpath("//td[contains(., '" + productName + "')]/following-sibling::td[@class='remove-from-cart']//button[@class='remove-btn']");
    }

    private By getProductNameLink_byGivenProductName(String productName){
        return By.xpath("//a[@class='product-name'][normalize-space()='" + productName + "']");
    }

    public boolean confirmShoppingCartPageTitleIsVisible(){
        return confirmElementIsVisible(SHOPPING_CART_PAGE_TITLE);
    }
    public boolean clickTermOfServiceCheckbox(){
        return clickElement(TERM_OF_SERVICE_CHECKBOX);
    }
    public boolean clickCheckoutButton(){
        return clickElement(CHECKOUT_BUTTON);
    }

    public String getProductQuantityByGivenProductName(String productName){

        return getAttributeValue(getProductQuantity_byGivenProductName(productName));

    }
    public boolean clearProductQuantity(String productName){
        return clearElement(getProductQuantity_byGivenProductName(productName));
    }
    public boolean sendKeysProductQuantity(String productName, int newQuantity){
        return sendKeysToElement(getProductQuantity_byGivenProductName(productName), String.valueOf(newQuantity));
    }
    public boolean clickUpdateShoppingCartButton(){
        return clickElement(UPDATE_SHOPPING_CART_BUTTON);
    }

    public boolean clickRemoveButton(String productName){
        return clickElement(getRemoveButton_byGivenProductName(productName));
    }
    public boolean confirmProductNameLinkIsNotVisible(String productName){
        return confirmElementIsNotVisible(getProductNameLink_byGivenProductName(productName));
    }
}
