package customFiles;

import base.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.pageReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SFCustomScripts{
    static BaseTest baseTest = new BaseTest();
    static pageReader pr = new pageReader();
    private static Map<String, WebElement> elementMap = new HashMap<>();

    public static void enterDataInTestField(String testData, String ele, String pageName) {
        WebElement element = pr.readDataFromExcel(ele, pageName);
        if (element != null) {
            element.sendKeys(testData);
        }
    }

    public static void clickButton(String elementName, String pageName) throws IOException {
//        baseTest.driver.findElement(By.id(element));
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        if (element != null) {
            highlight(element);
            element.click();
        } else {
            System.out.println("Element not found: " + elementName);
        }
    }

    private static void highlight(WebElement ele) throws IOException {
        //Create object of a JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) baseTest.driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid red;');", ele);
//        takeScreenshot(baseTest.driver, fileDoc);
    }

    private static WebElement readExcelToFindElementwithMap(String elementNameToFind, String pageName) {
        String filePath = "C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\src\\test\\java\\pages\\Pages.xlsx";
        String sheetName = pageName;

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                // Start reading data from the second row (index 1)
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);

                    if (row != null) {
                        String currentElementName = getStringCellValue(row.getCell(0));
                        String locatorType = getStringCellValue(row.getCell(1));
                        String locatorValue = getStringCellValue(row.getCell(2));

                        if (currentElementName.equals(elementNameToFind)) {
                            WebElement element = findElement(currentElementName, locatorType, locatorValue);
                            // Add the element to the map
                            elementMap.put(elementNameToFind, element);
                            return element;
                        }
                    }
                }
            } else {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file", e);
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

    private static By getBy(String elementName, String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            // Add more cases as needed (e.g., className, tagName, etc.)
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }

    private static WebElement findElement(String elementName, String locatorType, String locatorValue) {
        By by = getBy(elementName, locatorType, locatorValue);
        return baseTest.driver.findElement(by);
    }
}
