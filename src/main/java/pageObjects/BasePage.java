package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import waitTimes.WaitTimes;
import java.time.Duration;

/**
 * BasePage class for initializing WebDriver, wait times and common event methods.
 */
public class BasePage {

    WebDriver driver;
    public WaitTimes waitTimes = new WaitTimes();

    /**
     * Constructor for BasePage.
     * @param driver WebDriver instance.
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Clicks the element identified by the given locator after ensuring it is clickable within the default wait time.
     * @param locator By object identifying the element to be clicked.
     * @return true if the click is successful, false otherwise.
     */
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

    /**
     * Clicks the element identified by the given locator after ensuring it is clickable within the specified wait duration.
     * @param locator    By object identifying the element to be clicked.
     * @param waitTimes  Duration specifying the maximum time to wait for the element to be clickable.
     * @return true if the click is successful, false otherwise.
     */
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

    /**
     * Retrieves the text content of the element identified by the given locator after ensuring it is visible within the default wait time.
     * @param locator By object identifying the element from which to retrieve text.
     * @return The text content of the element if successful, or an error message if unsuccessful.
     */
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

    /**
     * Sends the specified keys to the element identified by the given locator after ensuring it is clickable within the default wait time.
     * @param locator By object identifying the element to receive the keys.
     * @param keys    The keys to be sent to the element.
     * @return true if the keys are successfully sent, false otherwise.
     */
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

    /**
     * Confirms the visibility of the element identified by the given locator within the default wait time.
     * @param locator By object identifying the element to confirm visibility.
     * @return true if the element is visible, false otherwise.
     */
    public boolean confirmElementIsVisible(By locator) {
        try {
            WebElement webElement = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Selects an option from a dropdown element identified by the given locator based on the visible text, within the default wait time.
     * @param locator By object identifying the dropdown element.
     * @param text    The visible text of the option to be selected.
     * @return true if the option is successfully selected, false otherwise.
     */
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

    /**
     * Clears the content of the element identified by the given locator within the default wait time.
     * @param locator By object identifying the element to be cleared.
     * @return true if the element content is successfully cleared, false otherwise.
     */
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

    /**
     * Retrieves the value of the attribute "value" from the element identified by the given locator within the default wait time.
     * @param locator By object identifying the element from which to retrieve the attribute value.
     * @return The value of the "value" attribute if successful, or an error message if unsuccessful.
     */
    public String getAttributeValue(By locator) {
        try {
            WebElement elementText = new WebDriverWait(driver, waitTimes.DEFAULT_WAIT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elementText.getAttribute("value");
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to get text from Element.";
        }
    }

    /**
     * Confirms that the element identified by the given locator is not visible within the default wait time.
     * @param locator By object identifying the element to confirm non-visibility.
     * @return true if the element is not visible, false otherwise.
     */
    public boolean confirmElementIsNotVisible(By locator) {
        try {
            new WebDriverWait(driver, waitTimes.DEFAULT_WAIT).until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Checks and selects the checkbox or radio button identified by the given locator.
     * If the checkbox or radio button is not already selected, it will be selected.
     * @param locator By object identifying the checkbox or radio button.
     * @return true if the checkbox or radio button is selected (either initially or after being clicked), false otherwise.
     */
    public boolean checkAndSelectCheckboxOrRadioButton(By locator) {
        boolean selected = false;
        try {
            WebElement checkboxOrRadioButton = driver.findElement(locator);
            selected = checkboxOrRadioButton.isSelected();

            // If the checkbox or radio button is not selected, select it
            if (!selected) {
                checkboxOrRadioButton.click();
                selected = true; // Update the selected status
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return selected;
    }
}
