package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By ShoppingCartPageTitle = By.xpath("//h1[normalize-space()='Shopping cart']");
    private final By termOfServiceCheckbox = By.name("termsofservice");
    private final By checkoutButton = By.id("checkout");

    public boolean confirmShoppingCartPageTitle(){
        return confirmElementIsVisible(ShoppingCartPageTitle);
    }
    public boolean clickTermOfServiceCheckbox(){
        return clickElement(termOfServiceCheckbox);
    }
    public boolean clickCheckoutButton(){
        return clickElement(checkoutButton);
    }
}
