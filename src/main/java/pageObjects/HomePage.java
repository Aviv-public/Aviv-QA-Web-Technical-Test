package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertTrue;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    private final By NOPCOMMERCE_LOGO = By.xpath("//img[@alt='nopCommerce demo store']");
    private final By REGISTER_LINK = By.xpath("//a[normalize-space()='Register']");
    private final By LOGIN_LINK = By.linkText("Log in");
    private final By SEARCH_STORE_PLACEHOLDER = By.id("small-searchterms");
    private final By FIRST_ELEMENT_IN_SEARCH_STORE_PLACEHOLDER = By.xpath("(//li[@class='ui-menu-item'])[1]");

    public boolean confirmNopCommerceLogoIsVisible(){
        return confirmElementIsVisible(NOPCOMMERCE_LOGO);
    }
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
        return clickElement(FIRST_ELEMENT_IN_SEARCH_STORE_PLACEHOLDER);
    }

    public void searchAndSelectFirstElementInSearchStorePlaceholder(String productName){
        assertTrue("unable to enter text in 'Search store' placeholder",sendKeysToSearchStorePlaceholder(productName));
        assertTrue("unable to click on first element in Search store placeholder",clickFirstElementInSearchStorePlaceholder());
    }
}
