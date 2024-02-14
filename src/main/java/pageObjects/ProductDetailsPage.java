package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(@id, 'add-to-cart-button-')]");
    private final By PRODUCT_ADDED_TO_SHIPPING_CART_SUCCESS_MESSAGE = By.xpath("//div[@id='bar-notification']//p[@class='content']");
    private final By SHOPPING_CART_LINK = By.xpath("//a[normalize-space()='shopping cart']");

    By ENTERED_QUANTITY_TEXT_BOX = By.xpath("//input[contains(@id, 'product_enteredQuantity_')]");

    public boolean clickAddToCartButton(){
        return clickElement(ADD_TO_CART_BUTTON);
    }

    public String getProductAddedToShippingCartSuccessMessage(){
        return getElementText(PRODUCT_ADDED_TO_SHIPPING_CART_SUCCESS_MESSAGE);
    }

    public boolean clickShoppingCartLink(){
        return clickElement(SHOPPING_CART_LINK);
    }

    public boolean sendKeysToEnteredQuantityTextBox(int num){
        return sendKeysToElement(ENTERED_QUANTITY_TEXT_BOX, String.valueOf(num));
    }

    public boolean clearEnteredQuantityTextBox(){
        return clearElement(ENTERED_QUANTITY_TEXT_BOX);
    }
}
