package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage extends BasePage{
    public OrderCompletedPage(WebDriver driver) {
        super(driver);
    }

    private final By orderCompletedPageTitle = By.xpath("//h1[normalize-space()='Thank you']");
    private final By orderProcessedSuccessMessage = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");

    public boolean confirmOrderProcessedSuccessMessage(){
        return confirmElementIsVisible(orderProcessedSuccessMessage);
    }
    public boolean confirmOrderCompletedPageTitle(){
        return confirmElementIsVisible(orderCompletedPageTitle);
    }
}
