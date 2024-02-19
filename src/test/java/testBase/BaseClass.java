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

public class BaseClass {

    //static public WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){

        switch (browser.toLowerCase()){
            case "chrome" : driverThreadLocal.set(new ChromeDriver());
                            break;
            case "firefox" : driverThreadLocal.set(new FirefoxDriver());
                            break;
            default       : System.out.println("No matching browser..");
        }

        WebDriver driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("login.url"));
        driver.manage().window().maximize();
    }

   @AfterClass
    public void tearDown(){
       WebDriver driver = getDriver();
       if (driver != null) {
           driver.quit();
           driverThreadLocal.remove();
       }
    }

    public String captureScreen(String tname){

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
