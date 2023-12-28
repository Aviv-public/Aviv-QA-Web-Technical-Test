package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum LoginPage implements CucumberElement {
    LOG_IN(By.xpath("//a[contains(text(),'Log in')]")),
    EMAIL_INPUT_FIELD_LOGIN(By.id("Email")),
    PASSWORD_FIELD(By.id("Password")),
    LOGIN_BUTTON(By.xpath("//button[contains(text(),'Log in')]"));
    private final By by;
}
