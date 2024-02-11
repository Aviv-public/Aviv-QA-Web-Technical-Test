package testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {

    static public WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){

        switch (browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver();
                            break;
            case "edge"   : driver = new EdgeDriver();
                            break;
            default       : System.out.println("No matching browser..");
        }

        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("login.url"));
        driver.manage().window().maximize();
    }

   @AfterClass
    public void tearDown(){
        driver.close();
    }

    public String captureScreen(String tname){

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
