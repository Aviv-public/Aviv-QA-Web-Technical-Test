package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(@id, 'add-to-cart-button-')]");
    private final By PRODUCT_ADDED_TO_SHIPPING_CART_SUCCESS_MESSAGE = By.xpath("//div[@id='bar-notification']//p[@class='content']");
    private final By SHOPPING_CART_LINK = By.xpath("//a[normalize-space()='shopping cart']");
    private final By ENTERED_QUANTITY_TEXT_BOX = By.xpath("//input[contains(@id, 'product_enteredQuantity_')]");

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

    public void addProductToCart(int quantity ){
        assertTrue("unable to clear entered quantity text box", clearEnteredQuantityTextBox());

        assertTrue("unable to enter quantity in entered quantity text box", sendKeysToEnteredQuantityTextBox(quantity));

        assertTrue("unable to click on 'ADD TO CART' button",clickAddToCartButton());
        String productAddedToShippingCartExpectedSuccessMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(getProductAddedToShippingCartSuccessMessage(),productAddedToShippingCartExpectedSuccessMessage,"unable to verify product added to shipping card success message");
    }
}
