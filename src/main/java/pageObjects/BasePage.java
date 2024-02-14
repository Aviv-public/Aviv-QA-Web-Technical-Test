package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import waitTimes.WaitTimes;
import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public WaitTimes waitTimes = new WaitTimes();

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean clickElement(By locator) {
        try {
            WebElement elementToClick = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickElement(By locator, Duration waitTimes) {
        try {
            WebElement elementToClick = new WebDriverWait(driver, waitTimes)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getElementText(By locator) {
        try {
            WebElement elementText = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elementText.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to get text from Element.";
        }
    }

    public boolean sendKeysToElement(By locator, String keys) {
        try {
            WebElement elementToReceiveKeys = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            elementToReceiveKeys.sendKeys(keys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean confirmElementIsVisible(By locator) {
        try {
            WebElement webElement = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean selectElementByText(By locator, String text) {
        try {
            WebElement element = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select = new Select(element);
            select.selectByVisibleText(text);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clearElement(By locator) {
        try {
            WebElement webElement = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            webElement.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
