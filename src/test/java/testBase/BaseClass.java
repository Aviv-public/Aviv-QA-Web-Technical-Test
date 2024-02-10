package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup(){

        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("login.url"));
        driver.manage().window().maximize();
    }

   @AfterClass
    public void tearDown(){
        driver.close();
    }
}
