package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waitTimes.WaitTimes;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public WaitTimes waitTimes = new WaitTimes();

    BasePage(WebDriver driver){
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

    public String getElementText(By locator, Duration waitTimes) {
        try {
            WebElement elementText = new WebDriverWait(driver, waitTimes)
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
    public boolean sendKeysToElement(By locator, String keys, Duration waitTime) {
        try {
            WebElement elementToReceiveKeys = new WebDriverWait(driver, waitTime)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            elementToReceiveKeys.sendKeys(keys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
