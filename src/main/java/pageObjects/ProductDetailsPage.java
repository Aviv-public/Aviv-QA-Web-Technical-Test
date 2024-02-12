package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button-5");
    //private final By SUCCESS_MESSAGE = By.xpath("//div[@class='bar-notification success']");
    private final By SHOPPING_CART_LINK = By.xpath("//span[@class='cart-label'][text()='Shopping cart']");

    public boolean clickAddToCartButton(){
        return clickElement(ADD_TO_CART_BUTTON);
    }

/*    public boolean confirmSuccessMessage(){
        return confirmElementIsVisible(successMessage);
    }*/

/*    public String get(){
        return getElementText(SUCCESS_MESSAGE);
    }*/

    public boolean clickShoppingCartLink(){
        return clickElement(SHOPPING_CART_LINK);
    }
}
