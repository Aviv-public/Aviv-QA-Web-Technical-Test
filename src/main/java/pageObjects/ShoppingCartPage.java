package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By pageTitle = By.xpath("//h1[normalize-space()='Shopping cart']");
    By termOfServiceButton = By.name("termsofservice");
    By checkoutButton = By.id("checkout");

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
