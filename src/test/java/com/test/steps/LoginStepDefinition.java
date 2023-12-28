package com.test.steps;

import com.test.cucumberelements.HomePage;
import com.test.cucumberelements.LoginPage;
import com.test.cucumberelements.RegisterPage;
import com.test.utils.BaseMethods;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginStepDefinition {

    private final BaseMethods baseMethods;

    @Given("user is logged in")
    public void userIsLoggedIn() {
        EmailStepDefinition emailStepDefinition = new EmailStepDefinition(baseMethods);
        baseMethods.clickButton(HomePage.REGISTER);
        baseMethods.writeInElement("user", RegisterPage.FIRSTNAME_INPUT_FIELD);
        baseMethods.writeInElement("name", RegisterPage.LASTNAME_INPUT_FIELD);
        emailStepDefinition.userWritesValueInElement(RegisterPage.EMAIL_INPUT_FIELD);
        baseMethods.writeInElement("Password*1", RegisterPage.PASSWORD_INPUT_FIELD);
        baseMethods.writeInElement("Password*1", RegisterPage.CONFIRM_PASSWORD_INPUT_FIELD);
        baseMethods.clickButton(RegisterPage.REGISTER_BUTTON);
        baseMethods.clickButton(HomePage.LOGIN);
        emailStepDefinition.userWritesValueInElement(LoginPage.EMAIL_INPUT_FIELD_LOGIN);
        baseMethods.writeInElement("Password*1", LoginPage.PASSWORD_FIELD);
        baseMethods.clickButton(LoginPage.LOGIN_BUTTON);
    }

}
