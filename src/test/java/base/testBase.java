package base;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class testBase {
    public WebDriver driver;
    String currentDirectory = System.getProperty("user.dir");
    Properties props = new Properties();
    public String configFolder = currentDirectory + "\\config.properties";


    @Before
    public void setup() throws IOException {
        loadConfigurations();
        setupWebDriver();
        configureWebDriver();
    }

    @BeforeClass
    public void setupWebDriver() {
//        // Load configurations from a properties file
//        loadConfigurations();
        if (props.getProperty("Browser").equals("chrome")) {
            setupChromeDriver();
        } else if (props.get("Browser").equals("edge")) {
            setupEdgeDriver();
        } else {
            // Handle other cases or provide a default
            setupDefaultDriver();
        }

        // Additional setup code
        configureWebDriver();
    }

    @AfterClass
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureAndAttachScreenshot(scenario, driver);
        }
        driver.close();
        driver.quit();
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureAndAttachScreenshot(scenario, driver);
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (props.getProperty("ScreenshotOnFailure").equals("No")) {
            ScreenshotUtil.captureAndAttachScreenshot(scenario, driver);
        } else if (props.getProperty("ScreenshotOnFailure").equals("Yes") && scenario.isFailed()) {
            ScreenshotUtil.captureAndAttachScreenshot(scenario, driver);
        }
    }

    private void setupChromeDriver() {
        {
            System.setProperty("webdriver.chrome.driver", currentDirectory + "/src/test/resources/drivers/chromedriver.exe");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("--start-maximized");
            ops.addArguments("--use-fake-ui-for-media-stream");
            ops.addArguments("--disable-user-media-security=true");
            driver = new ChromeDriver(ops);
        }
    }

    private void setupEdgeDriver() {
        // Set the driver path
        System.setProperty("webdriver.edge.driver", currentDirectory + "/src/test/resources/drivers/msedgedriver.exe");
        // Start Edge Session
        driver = new EdgeDriver();
    }

    private void setupDefaultDriver() {
        System.setProperty("webdriver.edge.driver", currentDirectory + "/src/test/resources/drivers/msedgedriver.exe");            // Start Edge Session
        driver = new EdgeDriver();
    }

    private void configureWebDriver() {
        // Reusable WebDriver configurations
        WebDriverUtil.maximizeWindow(driver);
        WebDriverUtil.configureTimeouts(driver, Duration.ofSeconds(40), Duration.ofSeconds(40));
    }

    // ...
    private void loadConfigurations() {
        try (FileReader reader = new FileReader(configFolder)) {
            props.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class WebDriverUtil {
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void configureTimeouts(WebDriver driver, Duration implicit, Duration pageLoad) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
}

class ScreenshotUtil {
    public static void captureAndAttachScreenshot(Scenario scenario, WebDriver driver) {
        // Capture screenshot and attach to the scenario
        if (scenario.isFailed()) {
            System.err.println("Taking Screenshot from After Method !");

            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }

    }// ...
}
