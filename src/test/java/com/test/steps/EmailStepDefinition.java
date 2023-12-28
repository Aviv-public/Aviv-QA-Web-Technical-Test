package com.test.steps;

import com.test.utils.BaseMethods;
import com.test.utils.CucumberElement;
import io.cucumber.java.en.And;

import java.time.Instant;

public class EmailStepDefinition {

    private final BaseMethods baseMethods;

    public static final String EMAIL_FORMAT = "user+%d@gmail.com";
    private final String email;

    public EmailStepDefinition(BaseMethods baseMethods) {
        this.baseMethods = baseMethods;
        this.email = String.format(EMAIL_FORMAT, Instant.now().getEpochSecond());
    }

    @And("user enters email inside element {element}")
    public void userWritesValueInElement(CucumberElement element) {
        baseMethods.writeInElement(email, element);
    }

}
