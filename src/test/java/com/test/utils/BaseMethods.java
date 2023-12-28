package com.test.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Slf4j
public class BaseMethods {

    private WebDriver driver;

    private JavascriptExecutor js;
    public static Properties prop;
    private static final int DEFAULT_TIMEOUT_SLEEP_DIVISOR = 30;
    private static final Duration DEFAULT_WEB_DRIVER_WAIT_TIMEOUT = ofSeconds(15);


    @Before
    public void setUp() throws IOException {
        prop = new Properties();
        try (FileInputStream ip = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(ip);
        }
        String browser = getFromEnvOrProperty("browser");
        DriverFactory.initializeDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        String url = getFromEnvOrProperty("homepage");
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            takeScreenShot(scenario.getId());
        }

        driver.close();
    }

    public void takeScreenShot(String name) {
        byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.createDirectories(Paths.get("screenshot"));
            File outputFile = new File("screenshot" + File.separator + name + ".jpg");
            Files.write(outputFile.toPath(), scrFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInElement(String value, CucumberElement element) {
        var webElement = getAssuredElement(element);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public String readFromElement(CucumberElement element) {
        return getAssuredElement(element).getAttribute("value");
    }

    protected WebElement findElement(By by) {
        return getAssuredElement(by);
    }

    public WebElement findElement(CucumberElement element) {
        return findElement(element.getBy());
    }

    public void userSeesElement(CucumberElement element) {
        findElement(element).isDisplayed();
    }

    public void clickButton(CucumberElement button) {
        WebElement clickableElement = getAssuredElement(button);
        clickButton(button.toString(), clickableElement);
    }

    public boolean isSelected(CucumberElement button) {
        WebElement clickableElement = getAssuredElement(button);
        return clickableElement.isSelected();
    }

    public void selectValue(CucumberElement button, String value) {
        var selectedField = new Select(getAssuredElement(button));
        selectedField.selectByVisibleText(value);
    }

    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition) {
        return expectationFulfilledAfterWait(webElementExpectedCondition, DEFAULT_WEB_DRIVER_WAIT_TIMEOUT);
    }

    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition, Duration timeout) {
        return expectationFulfilledAfterWait(webElementExpectedCondition, timeout,
                timeout.dividedBy(DEFAULT_TIMEOUT_SLEEP_DIVISOR));
    }

    public <T> T expectationFulfilledAfterWait(ExpectedCondition<T> webElementExpectedCondition, Duration timeout,
                                               Duration sleep) {
        try {
            return new WebDriverWait(driver, timeout, sleep).until(
                    webElementExpectedCondition);
        } catch (TimeoutException e) {
            log.error("Condition not fulfilled after waiting {}: {}", timeout, webElementExpectedCondition);
            return null;
        }
    }

    WebElement getAssuredElement(CucumberElement cucumberElement) {
        return getAssuredElement(cucumberElement.getBy());
    }

    WebElement getAssuredElement(By by) {
        WebElement element = expectationFulfilledAfterWait(elementToBeClickable(by));
        assertThat(by + " not clickable after waiting", element, notNullValue());
        return element;
    }

    void clickButton(String buttonName, WebElement clickable) {
        log.debug("Clicking element \"{}\"", buttonName);
        js.executeScript("arguments[0].click();", clickable);
    }

    private String getFromEnvOrProperty(String propertyName) {
        String propertyValue = System.getenv(propertyName);
        if (propertyValue == null) {
            propertyValue = prop.getProperty(propertyName);
        }
        return propertyValue;
    }

}