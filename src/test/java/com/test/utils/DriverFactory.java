package com.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    private static final InvalidArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new InvalidArgumentException("Invalid browser.");


    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void initializeDriver(final String browser) {
        installDriver(browser);
        switch (browser) {
            case CHROME: {
                var chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(
                        "--headless=new",
                        "--window-size=1920x1200",
                        "--ignore-certificate-errors",
                        "--disable-extensions",
                        "--no-sandbox",
                        "--disable-gpu",
                        "--disable-dev-shm-usage",
                        "--remote-allow-origins=*",
                        "--log-net-log");
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.BROWSER, Level.ALL);
                logPrefs.enable(LogType.DRIVER, Level.ALL);
                chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("autofill.profile_enabled", false);
                chromeOptions.setExperimentalOption("prefs", prefs);
                webDriverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
            }
            case FIREFOX: {
                var firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(
                        "--headless",
                        "--window-size=1920x1200");
                webDriverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                break;
            }
            default:
                throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void installDriver(final String browser) {
        switch (browser) {
            case CHROME -> WebDriverManager.chromedriver().setup();
            case FIREFOX -> WebDriverManager.firefoxdriver().setup();
            default -> throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
