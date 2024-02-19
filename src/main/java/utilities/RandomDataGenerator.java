package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    // Generates a random first name
    public static String randomFirstName() {
         return "First" + RandomStringUtils.randomAlphabetic(5);
    }

    // Generates a random last name
    public static String randomLastName() {
        return "Last" + RandomStringUtils.randomAlphabetic(5);
    }

    // Generates a random email address
    public static String randomEmail() {
        String accountName = RandomStringUtils.randomAlphabetic(6);
        return accountName + "@test.com";
    }

    // Generates a random password
    public static String randomPassword() {
        String letter = RandomStringUtils.randomAlphabetic(3);
        String number = RandomStringUtils.randomNumeric(3);
        return (letter + "@" + number);
    }

    // Generates a random phone number
    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    // Generates a random postal code
    public static String randomPostalCode() {
        return RandomStringUtils.randomNumeric(5);
    }

    // Generates a random address
    public static String randomAddress() {
        return RandomStringUtils.randomAlphabetic(10) + " " + RandomStringUtils.randomNumeric(2);
    }
}
