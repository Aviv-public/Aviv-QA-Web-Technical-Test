package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterResultPage extends BasePage{
    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }

    By registerResultSuccessMessage = By.className("result");

    public String getRegisterResultText(){
        return getElementText(registerResultSuccessMessage);
    }
}
