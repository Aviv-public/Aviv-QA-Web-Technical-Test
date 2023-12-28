package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum ShoppingCartPage implements CucumberElement {
    GO_TO_CART(By.xpath("//button[contains(text(),'Go to cart')]")),
    CHECK_OUT_BUTTON(By.id("checkout")),
    PRODUCT_NAME(By.partialLinkText("Apple MacBook Pro 13")),
    TERMS_OF_SERVICE(By.id("termsofservice"));
    private final By by;
}
