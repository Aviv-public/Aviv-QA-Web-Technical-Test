package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static String randomFirstName() {
         return "First" + RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomLastName() {
        return "Last" + RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomEmail() {
        String accountName = RandomStringUtils.randomAlphabetic(6);
        return accountName + "@test.com";
    }
    public static String randomPassword() {
        String letter = RandomStringUtils.randomAlphabetic(3);
        String number = RandomStringUtils.randomNumeric(3);
        return (letter + "@" + number);
    }

    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomPostalCode() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String randomAddress() {
        return RandomStringUtils.randomAlphabetic(10) + " " + RandomStringUtils.randomNumeric(2);
    }

}
