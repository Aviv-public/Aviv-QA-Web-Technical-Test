package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    private final By REGISTER_LINK = By.xpath("//a[normalize-space()='Register']");
    private final By LOGIN_LINK = By.linkText("Log in");
    private final By SEARCH_STORE_PLACEHOLDER = By.id("small-searchterms");
    private final By firstElement = By.xpath("(//li[@class='ui-menu-item'])[1]");


    public boolean clickRegisterLink(){
        return clickElement(REGISTER_LINK);
    }

    public boolean clickLoginLink(){
        return clickElement(LOGIN_LINK);
    }
    public boolean sendKeysToSearchStorePlaceholder(String laptop){
        return sendKeysToElement(SEARCH_STORE_PLACEHOLDER,laptop);
    }
    public boolean clickFirstElementInSearchStorePlaceholder(){
        return clickElement(firstElement);
    }
}
