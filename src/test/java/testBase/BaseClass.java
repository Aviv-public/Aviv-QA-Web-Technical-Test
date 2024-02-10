package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){

        switch (browser.toLowerCase()){
            case "chrome" : WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver();
                            break;
            case "edge"   : WebDriverManager.edgedriver().setup();
                            driver = new EdgeDriver();
                            break;
            default       : System.out.println("No matching browser..");
        }

        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("login.url"));
        driver.manage().window().maximize();
    }

   //@AfterClass
    public void tearDown(){
        driver.close();
    }
}
