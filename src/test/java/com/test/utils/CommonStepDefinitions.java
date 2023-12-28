package com.test.utils;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

@RequiredArgsConstructor
public class CommonStepDefinitions {

    private final BaseMethods baseMethods;

    @ParameterType("[A-Za-z_]+\\w*")
    public CucumberElement element(String elementName) {
        return CucumberElementResolver.resolveCucumberElement(elementName);
    }

    @And("user clicks on element {element}")
    public void userClicksOnElement(CucumberElement element) {
        baseMethods.clickButton(element);
    }

    @And("user select {element}")
    public void selectElement(CucumberElement element) {
        if (!baseMethods.isSelected(element)) {
            baseMethods.clickButton(element);
        }
    }

    @And("user unselect {element}")
    public void unselectElement(CucumberElement element) {
        if (baseMethods.isSelected(element)) {
            baseMethods.clickButton(element);
        }
    }

    @And("user select value {string} in element {element}")
    public void selectFromDropDownInElement(String value, CucumberElement element) {
        baseMethods.selectValue(element, value);
    }

    @And("user sees element {element}")
    public void userSeesElement(CucumberElement element) {
        baseMethods.userSeesElement(element);
    }


    @And("user writes value {string} in element {element}")
    public void userWritesValueInElement(String value, CucumberElement element) {
        baseMethods.writeInElement(value, element);
    }

    @And("user sees text {string} in element {element}")
    public void usersSeesTextInTheElement(String value, CucumberElement element) {
        WebElement elementText = baseMethods.findElement(element);
        assertThat(elementText.getText(), Matchers.containsString(value));
    }

    @And("user expect to see the text {string} in element {element}")
    public void usersExpectTextInTheElement(String value, CucumberElement element) {
        String elementText = baseMethods.readFromElement(element);
        assertThat(elementText, Matchers.containsString(value));
    }
}