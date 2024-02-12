package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationResultPage extends BasePage{
    public RegistrationResultPage(WebDriver driver) {
        super(driver);
    }

    private final By REGISTER_RESULT_SUCCESS_MESSAGE = By.className("result");

    public String getRegisterResultText(){
        return getElementText(REGISTER_RESULT_SUCCESS_MESSAGE);
    }
}
