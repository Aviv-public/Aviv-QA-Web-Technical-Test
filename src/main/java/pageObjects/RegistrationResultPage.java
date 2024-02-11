package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationResultPage extends BasePage{
    public RegistrationResultPage(WebDriver driver) {
        super(driver);
    }

    By registerResultSuccessMessage = By.className("result");

    public String getRegisterResultText(){
        return getElementText(registerResultSuccessMessage);
    }
}
