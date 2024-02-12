package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.id("add-to-cart-button-5");
    private final By successMessage = By.xpath("//div[@class='bar-notification success']");
    private final By shoppingCartLink = By.xpath("//span[@class='cart-label'][text()='Shopping cart']");

    public boolean clickAddToCartButton(){
        return clickElement(addToCartButton);
    }

/*    public boolean confirmSuccessMessage(){
        return confirmElementIsVisible(successMessage);
    }*/

    public String get(){
        return getElementText(successMessage);
    }

    public boolean clickShoppingCartLink(){
        return clickElement(shoppingCartLink);
    }
}
