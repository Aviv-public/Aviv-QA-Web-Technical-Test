package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum RegisterPage implements CucumberElement {
    REGISTER_MESSAGE(By.xpath("//h1[contains(text(),'Register')]")),
    GENDER_FEMALE(By.id("gender-female")),
    GENDER_MALE(By.id("gender-male")),
    FIRSTNAME_INPUT_FIELD(By.id("FirstName")),
    LASTNAME_INPUT_FIELD(By.id("LastName")),
    EMAIL_INPUT_FIELD(By.xpath("//input[@id='Email']")),
    COMPANY_NAME_INPUT_FIELD(By.xpath("//input[@id='Company']")),
    NEWSLETTER_CHECKBOX(By.xpath("//input[@id='Newsletter']")),
    PASSWORD_INPUT_FIELD(By.xpath(" //input[@id='Password']")),
    CONFIRM_PASSWORD_INPUT_FIELD(By.xpath("//input[@id='ConfirmPassword']")),
    REGISTER_BUTTON(By.xpath("//button[@id='register-button']")),
    BIRTH_DATE(By.xpath("//select[@name='DateOfBirthDay']")),
    BIRTH_MONTH(By.xpath("//select[@name='DateOfBirthMonth']")),
    BIRTH_YEAR(By.xpath("//select[@name='DateOfBirthYear']")),
    MESSAGE_REGISTRATION_COMPLETED(By.xpath("//div[contains(text(),'Your registration completed')]")),
    LASTNAME_ERROR_MESSAGE(By.id("LastName-error")),
    EMAIL_ERROR_MESSAGE(By.id("Email-error")),
    CONFIRM_PASSWORD_ERROR_MESSAGE(By.id("ConfirmPassword-error"));
    private final By by;
}
