package com.test.cucumberelements;

import com.test.utils.CucumberElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
@Getter
public enum ChooseItemPage implements CucumberElement {
    APPLE_MACBOOK_PRO_13_INCH(By.xpath("//a[contains(text(),'Apple MacBook Pro 13-inch')]")),
    ADD_TO_CART(By.xpath("//button[@class='button-1 add-to-cart-button']")),
    ADD_TO_CART_MESSAGE(By.xpath("//p[@class='content']")),
    HOME_MENU(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]")),
    HTC_ONE_M8_ANDROID_L_5_0_LOLLIPOP(By.partialLinkText("HTC One M8 Android L")),
    ADD_TO_CART_HTC(By.xpath("//button[@class='button-1 add-to-cart-button']")),
    REMOVE_BUTTON_HTC(By.xpath("(//button[@class='remove-btn'])[2]")),
    ITEM_QUANTITY_HTC(By.xpath(" (//input[@class='qty-input'])[2]")),
    UPDATE_CART(By.id("updatecart")),
    TOTAL_AMOUNT(By.xpath("(//span[@class='value-summary'])[4]/strong"));
    private final By by;
}
