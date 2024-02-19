package testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BaseClass provides common setup and teardown methods for test classes, along with
 * capturing screenshots and managing WebDriver instances.
 */
public class BaseClass {

    //ThreadLocal to store WebDriver instances for parallel test execution
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Retrieves the WebDriver instance associated with the current thread.
     * @return WebDriver instance.
     */
    protected static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Setup method to initialize WebDriver based on the specified browser.
     * @param browser Browser name specified in TestNG parameters.
     */
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){

        // Initialize WebDriver based on the specified browser
        switch (browser.toLowerCase()){
            case "chrome" : driverThreadLocal.set(new ChromeDriver());
                            break;
            case "firefox" : driverThreadLocal.set(new FirefoxDriver());
                            break;
            default       : System.out.println("No matching browser..");
        }

        // Common setup steps for WebDriver
        WebDriver driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("login.url"));
        driver.manage().window().maximize();
    }

    /**
     * Teardown method to quit the WebDriver instance and remove it from the ThreadLocal.
     */
   @AfterClass
    public void tearDown(){
       WebDriver driver = getDriver();
       if (driver != null) {
           driver.quit();
           driverThreadLocal.remove();
       }
    }

    /**
     * Captures a screenshot and saves it to a file.
     * @param tname Test name or identifier.
     * @return File path of the saved screenshot.
     */
    public String captureScreen(String tname){
        // Generate a timestamp for the screenshot file
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // Capture screenshot using WebDriver's TakesScreenshot interface
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Specify the target file path for the screenshot
        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        // Rename and move the source file to the target file path
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
