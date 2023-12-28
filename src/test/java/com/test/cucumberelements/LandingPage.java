package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum LandingPage implements CucumberElement {
    LANDING_PAGE(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
    private final By by;
}
