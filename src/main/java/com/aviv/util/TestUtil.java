/**
 * Author: Rakesh Mustoor
 */
package com.aviv.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aviv.base.BaseClass;


public class TestUtil extends BaseClass
{

	public static int PAGE_LOAD_TIMEOUT = 10;
	public static int IMPLICIT_WAIT = 10;

	public void setEmailValue() throws IOException
	{

		try {
			Properties properties = new Properties();
			BufferedReader reader = new BufferedReader(new FileReader(
					System.getProperty("user.dir") + "/src/main/java/com/aviv/config/config.properties"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					properties.put(parts[0], parts[1]);
				}
			}
			reader.close();
			properties.setProperty("email", "test" + RandomStringUtils.randomAlphabetic(4) + "@test.com");
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					System.getProperty("user.dir") + "/src/main/java/com/aviv/config/config.properties"));
			for (String property : properties.stringPropertyNames()) {
				writer.write(property + " " + properties.getProperty(property));
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(curDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
