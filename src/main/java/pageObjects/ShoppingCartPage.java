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

    public boolean confirmShoppingCartPageTitleIsVisible(){
        return confirmElementIsVisible(SHOPPING_CART_PAGE_TITLE);
    }
    public boolean clickTermOfServiceCheckbox(){
        return clickElement(TERM_OF_SERVICE_CHECKBOX);
    }
    public boolean clickCheckoutButton(){
        return clickElement(CHECKOUT_BUTTON);
    }
}
