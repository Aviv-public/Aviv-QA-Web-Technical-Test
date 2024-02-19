package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

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
    public boolean checkTermOfServiceCheckbox(){
        return checkAndSelectCheckboxOrRadioButton(TERM_OF_SERVICE_CHECKBOX);
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

    public void verifyProductQuantity(String productName, int expectedQuantity){
        String quantityAsString = getProductQuantityByGivenProductName(productName);
        int actualQuantity = Integer.parseInt(quantityAsString);
        // Verify the quantity
        Assert.assertEquals(actualQuantity, expectedQuantity,"Quantity mismatch for product: " + productName);
    }

    public void modifyProductQuantity(String productName, int newQuantity) {
        assertTrue("unable to clear product quantity text box",clearProductQuantity(productName));
        assertTrue("unable to send keys for product quantity",sendKeysProductQuantity(productName,newQuantity));
        assertTrue("unable to click on 'Update Shopping Cart' button",clickUpdateShoppingCartButton());
    }

    public void removeProductFromCartAndVerify(String productName){
        assertTrue("unable to click on remove icon",clickRemoveButton(productName));
        assertTrue("unable to click on 'Update Shopping Cart' button",clickUpdateShoppingCartButton());
        assertTrue("Product '" + productName + "' is still present in the cart after removal",confirmProductNameLinkIsNotVisible(productName));
    }
}
