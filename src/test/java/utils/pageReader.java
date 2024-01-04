package utils;

import base.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;


public class pageReader {
    static BaseTest baseTest = new BaseTest();

    public void setUp() throws IOException {
        baseTest.setup();
    }

    public WebElement readDataFromExcel(String elementName, String pageName) {
        // Specify the path to your Excel file
        String filePath = "C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\src\\test\\java\\pages\\Pages.xlsx";
        String sheetName = pageName;

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                // Start reading data from the second row (index 1)
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row != null) {
                        elementName = getStringCellValue(row.getCell(0));
                        String locatorType = getStringCellValue(row.getCell(1));
                        String locatorValue = getStringCellValue(row.getCell(2));
                        String testData = getStringCellValue(row.getCell(3));

                        // Find the element based on locator name and value
                        WebElement element = findElement(locatorType, locatorValue);

                        // Perform actions on the element (e.g., enter test data)
                        element.sendKeys(testData);

                        // Other actions as needed
//                        System.out.println("Successfully entered data for " + elementName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return "";
    }

    private static By getBy(String locatorType, String locatorXpath) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorXpath);
            case "name":
                return By.name(locatorXpath);
            case "xpath":
                return By.xpath(locatorXpath);
            // Add more cases as needed (e.g., className, tagName, etc.)
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }

    public static WebElement findElement(String locatorType, String locatorXpath) {
        By by = getBy(locatorType, locatorXpath);
        return baseTest.driver.findElement(by);
    }
}

