package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum HomePage implements CucumberElement {
    REGISTER(By.className("ico-register"));

    private final By by;
}
