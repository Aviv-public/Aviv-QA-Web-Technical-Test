package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By pageTitle = By.xpath("//h1[normalize-space()='Shopping cart']");
    private final By termOfServiceButton = By.name("termsofservice");
    private final By checkoutButton = By.id("checkout");

    public boolean confirmPageTitle(){
        return confirmElementIsVisible(pageTitle);
    }
    public boolean clickTermOfServiceButton(){
        return clickElement(termOfServiceButton);
    }
    public boolean clickCheckoutButton(){
        return clickElement(checkoutButton);
    }
}
