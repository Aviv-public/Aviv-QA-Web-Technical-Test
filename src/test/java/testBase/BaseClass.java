package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties properties;

    @BeforeClass
    public void setup(){

        //loading properties file
        try {
            FileReader file = new FileReader(".//src//test//java//resources//config.properties");
            properties = new Properties();
            properties.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }

   // @AfterClass
    public void tearDown(){
        driver.close();
    }

}
