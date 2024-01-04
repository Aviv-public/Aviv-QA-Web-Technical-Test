package utils;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
//    protected String baseUrl;
    private static final Properties properties = new Properties();

    static {
        String currentDirectory = System.getProperty("user.dir");
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(currentDirectory+"\\config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            } else {
                // Load a properties file from class path
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // You may choose to rethrow the exception if needed
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
