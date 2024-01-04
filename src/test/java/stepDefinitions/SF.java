package stepDefinitions;

import base.BaseTest;
import base.testBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.pageReader;

import java.io.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class SF extends testBase {
    String currentDirectory = System.getProperty("user.dir");
    String fileDoc = currentDirectory + "\\Screenshots\\";
    BaseTest baseTest = new BaseTest();
    private static Map<String, WebElement> elementMap = new HashMap<>();
    private final pageReader pr = new pageReader();

    @Before
    public void setUp() throws IOException {
        baseTest.setup();
    }

    @After(order = 0)
    public void tearDown() throws IOException {
        baseTest.tearDown();
    }

    @AfterStep(order = 1)
    public void addScreenshot(Scenario scenario) throws IOException {
        baseTest.addScreenshot(scenario);
    }

    public void takeScreenshot(WebDriver driver, String fileFolder) throws IOException {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile = new File(fileFolder + System.currentTimeMillis() + ".jpg");

        // Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Given("I am on homepage url \"([^\\\"]*)\"$")
    public void i_am_on_home_page_url(String arg1) throws IOException {
        FileReader fr = new FileReader(baseTest.configFolder);
        Properties props = new Properties();
        props.load(fr);
        baseTest.driver.get(props.getProperty(arg1));
    }

    @When("I enter  \"([^\\\"]*)\" in \"([^\\\"]*)\" field of \"([^\\\"]*)\"$")
    public void iEnterInFieldOf(String testData, String elementName, String pageName) throws IOException {
        WebElement element;
        element = pr.readDataFromExcel(elementName, pageName);
        if (element != null) {
            highlight(element);
            element.sendKeys(testData);
        }
    }

    @Then("I click \"([^\\\"]*)\" button of \"([^\\\"]*)\"$")
    public void iClickButtonOf(String elementName, String pageName) throws IOException {
//        SFCustomScripts.clickButton(elementName,pageName);
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        if (element != null) {
            highlight(element);
            element.click();
        } else {
            System.out.println("Element not found: " + elementName);
        }
    }

    @Then("User waits for page to get loaded")
    public void user_waits_for_page_to_get_loaded() {
        Duration pageLoadTimeout = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(baseTest.driver, pageLoadTimeout);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    @Then("User waits for sleep time")
    public void userWaitsForSleepTime() throws InterruptedException {
        Thread.sleep(5000);
    }


    @When("I enter \"([^\\\"]*)\" in \"([^\\\"]*)\" field of \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void iEnterUsernameInUsernameFieldOfLoginpage(String testData, String elementName, String pageName, String continueOnFailure) {
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        try {
            if (element != null) {
                testData = readTestData(elementName, pageName);
                element.clear();
                element.sendKeys(testData);
                highlight(element);
            } else {
                System.out.println("Element not found: " + elementName);
                handleFailure(continueOnFailure);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking the element: " + e.getMessage());
            handleFailure(continueOnFailure);
        }
    }

    @And("User waits for \"([^\\\"]*)\" element to be \"([^\\\"]*)\" in \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void userWaitsForElementToBeIn(String arg0, String arg1, String arg2, String continueOnFailure) {
        WebDriverWait wait = new WebDriverWait(baseTest.driver, Duration.ofSeconds(30));
        WebElement element = readExcelToFindElementwithMap(arg0, arg2);
        try {
            if (arg1.equals("displayed")) {
                WebElement Eelement = wait.until(ExpectedConditions.visibilityOf(element));
                highlight(element);
                System.out.println("Element is displayed in " + arg2);
            } else {
                System.out.println("Element is not displayed");
                handleFailure(continueOnFailure);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking the element: " + e.getMessage());
            handleFailure(continueOnFailure);
        }
    }

    @And("I select \"([^\\\"]*)\" from \"([^\\\"]*)\" of \"([^\\\"]*)\"$")
    public void iSelectFromOf(String arg0, String arg1, String arg2) throws IOException {
        WebElement element = readExcelToFindElementwithMap(arg1, arg2);
        if (element != null) {
            highlight(element);
            Select dd = new Select(element);
            dd.selectByValue(arg0);
        }
    }

    @When("User generates random \"([^\\\"]*)\" value and enters in \"([^\\\"]*)\" field of \"([^\\\"]*)\"$")
    public void userGeneratesRandomValueAndStoresInFieldOf(String arg0, String arg1, String arg2) {
        WebElement element = readExcelToFindElementwithMap(arg1, arg2);
//        int randomNo = generateRandomValue();
//        String readNumber = writeIntoExcel(arg1,arg2);
        if (element != null) {
            element.clear();
            element.sendKeys(String.valueOf(generateRandomValue(arg0)));
        }
    }

    @And("User reads \"([^\\\"]*)\" and stores \"([^\\\"]*)\" of \"([^\\\"]*)\"$")
    public void userReadsAndStoresOf(String arg0, String arg1, String arg2) throws IOException {
        WebElement element = readExcelToFindElementwithMap(arg1, arg2);
        if (element != null) {
            highlight(element);
            String elementValue;
            if (arg0.equals("Attribute")) {
                elementValue = element.getAttribute("value");
                String readNumber = writeIntoExcel(elementValue, arg1, arg2);
            } else if (arg0.equals("text")) {
                elementValue = element.getText();
                String readNumber = writeIntoExcel(elementValue, arg1, arg2);
            }
        }
    }

    @Then("I click \"([^\\\"]*)\" button of \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void iClickButtonOf(String elementName, String pageName, String continueOnFailure) {
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        try {
            if (element != null || element.isDisplayed()) {
                highlight(element);
                element.click();
            } else {
                System.out.println("Element not found: " + elementName);
                handleFailure(continueOnFailure);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking the element: " + e.getMessage());
            handleFailure(continueOnFailure);
        }
    }

    @Then("I click \"([^\\\"]*)\" button until \"([^\\\"]*)\" element is \"([^\\\"]*)\" of \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void iClickButtonUntilElementIsOf(String elementName1, String elementName2, String displayValidation, String pageName, String continueOnFailure) {
        WebDriverWait wait = new WebDriverWait(baseTest.driver, Duration.ofSeconds(10));
        WebElement element1 = readExcelToFindElementwithMap(elementName1, pageName);
        WebElement element2 = readExcelToFindElementwithMap(elementName2, pageName);
        while (!element2.isDisplayed()) {
            if (element1 != null) {
                element1.click();
            }
            try {
                // Wait for the presence of the "Empty ShoppingCart" element
                element2 = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element2));
                break;  // Exit the loop if the element is found
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Continue the loop if the element is not found
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        handleFailure(continueOnFailure);
    }

    @Then("User verify if \"([^\\\"]*)\" is \"([^\\\"]*)\" in \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void userVerifyIfIsIn(String elementName, String visibility, String pageName, String continueOnFailure) {
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        try {
            // Check visibility based on the provided condition
            if (visibility.equalsIgnoreCase("displayed")) {
                // Verify if the element is displayed
                if (element.isDisplayed()) {
                    highlight(element);
                    System.out.println("Element '" + elementName + "' is displayed.");
                } else {
                    handleFailure(continueOnFailure);
                }
            } else if (visibility.equalsIgnoreCase("not displayed")) {
                // Verify if the element is not displayed
                if (!element.isDisplayed()) {
                    System.out.println("Element '" + elementName + "' is not displayed.");
                } else {
                    handleFailure(continueOnFailure);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking the element: " + e.getMessage());
            handleFailure(continueOnFailure);
        }
    }

    @When("User enters \"([^\\\"]*)\" in \"([^\\\"]*)\" field of \"([^\\\"]*)\".\"([^\\\"]*)\"$")
    public void userEntersFirstNameInFieldOf(String fieldValue, String elementName, String pageName, String continueOnFailure) {
        WebElement element = readExcelToFindElementwithMap(elementName, pageName);
        try {
            if (element != null) {
                highlight(element);
                element.clear();
                element.sendKeys(fieldValue);
            } else {
                handleFailure(continueOnFailure);
            }

        } catch (Exception e) {
            e.printStackTrace();
            handleFailure(continueOnFailure);
        }
    }

    private WebElement readExcelToFindElementwithMap(String elementNameToFind, String pageName) {
//        String filePath = "C:\\Users\\Poorn\\OneDrive\\Desktop\\AVIV\\Aviv-QA-Web-Technical-Test\\src\\test\\java\\pages\\Pages.xlsx";
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "\\src\\test\\java\\pages\\Pages.xlsx";
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

    private String readTestData(String elementNameToFind, String pageName) {
        Map<String, String> testDataMap = new HashMap<>();
        // Specify the path to your Excel file
//        String filePath = "C:\\Users\\Poorn\\OneDrive\\Desktop\\AVIV\\Aviv-QA-Web-Technical-Test\\src\\test\\java\\pages\\Pages.xlsx";
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "\\src\\test\\java\\pages\\Pages.xlsx";
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
                        String currentElementName = getStringCellValue(row.getCell(0));
                        String testData = getStringCellValue(row.getCell(3));
//                        String testData = row.getCell(3).toString();

                        if (currentElementName.equals(elementNameToFind)) {
                            // Add the test data to the map
                            testDataMap.put(elementNameToFind, testData);
                            System.out.println("Current Element Name: " + currentElementName);
                            System.out.println("Test Data: " + testData);
                            return testData;
                        }
                    }
                }
            } else {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private WebElement readExcelToFindElement(String elementNameToFind, String pageName) {
        // Specify the path to your Excel file
        String filePath = currentDirectory + "\\src\\test\\java\\pages\\Pages.xlsx";
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
                        String currentElementName = getStringCellValue(row.getCell(0));
                        String locatorType = getStringCellValue(row.getCell(1));
                        String locatorValue = getStringCellValue(row.getCell(2));
                        // Find the element based on locator name and value
                        if (currentElementName.equals(elementNameToFind)) {
                            return findElement(currentElementName, locatorType, locatorValue);
                        }
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

    private By getBy(String elementName, String locatorType, String locatorValue) {
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

    private WebElement findElement(String elementName, String locatorType, String locatorValue) {
        By by = getBy(elementName, locatorType, locatorValue);
//        WebDriverWait wait = new WebDriverWait(baseTest.driver, Duration.ofSeconds(10));
        return baseTest.driver.findElement(by);
        // Wait for the element to be present in the DOM and visible on the page
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private String writeIntoExcel(String readValue, String elementNameToFind, String pageName) {
//        String filePath = "C:\\Users\\Poorn\\OneDrive\\Desktop\\AVIV\\Aviv-QA-Web-Technical-Test\\src\\test\\java\\pages\\Pages.xlsx";
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "\\src\\test\\java\\pages\\Pages.xlsx";
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

                        if (currentElementName.equals(elementNameToFind)) {
                            // Modify the existing code to write data into the Excel file
                            Cell testDataCell = row.createCell(3);  // Assuming column index 3 for test data
                            testDataCell.setCellValue(readValue);  // Replace with the new test data

                            // Save the changes to the Excel file
                            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                                workbook.write(fileOut);
                            }

                            System.out.println("Test data written for element: " + elementNameToFind);
                            break;  // Assuming you want to stop after finding the first match
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

    private Object generateRandomValue(String arg0) {
        Random r = new Random();
        Object randomValue = null;
        if (arg0.equals("long")) {
            long randomTenDigitNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            randomValue = randomTenDigitNumber;
        } else if (arg0.equals("int")) {
            int randomTenDigitNumber = r.nextInt(100) + 1;
            randomValue = randomTenDigitNumber;
        }

        return randomValue;
    }

    private void handleFailure(String continueOnFailure) {
        if ("(Continue on Failure)".equalsIgnoreCase(continueOnFailure)) {
            System.out.println("Continue on failure. Test execution continues.");
        } else {
            throw new AssertionError("Element not found, and continueOnFailure is not specified.");
        }
    }

    private void highlight(WebElement ele) throws IOException {
        //Create object of a JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) baseTest.driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with pink color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: cyan; border: 2px solid red;');", ele);
//        takeScreenshot(baseTest.driver, fileDoc);
    }
}
