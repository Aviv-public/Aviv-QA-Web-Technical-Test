package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static String randomString() {
         return RandomStringUtils.randomAlphabetic(6);
    }

    public static String randomAlphaNumeric() {
        String letter = RandomStringUtils.randomAlphabetic(3);
        String number = RandomStringUtils.randomNumeric(3);
        return (letter + "@" + number);
    }
}
