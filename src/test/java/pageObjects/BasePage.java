package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;


    BasePage(WebDriver driver){
        this.driver = driver;
    }


    public boolean clickElement(By locator) {
        try {
            WebElement elementToClick = new WebDriverWait(driver, Duration.ofSeconds(5))
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
            WebElement elementText = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elementText.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to get text from Element.";
        }
    }
}
