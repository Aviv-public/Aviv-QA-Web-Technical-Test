package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum HomePage implements CucumberElement {
    REGISTER(By.className("ico-register")),
    LOGIN(By.className("ico-login")),
    SHOPPING_CART_MENU(By.className("cart-label")),
    CLOSE_ADD_TO_CART_MESSAGE(By.className("close"));

    private final By by;
}
