package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ExtentReportManager class implements the TestNG ITestListener interface to manage Extent Reports.
 */
public class ExtentReportManager implements ITestListener {

    // Extent report components
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    // Report name based on timestamp
    String repName;

    /**
     * Executed before the test suite starts, initializes the Extent report settings and system information.
     * @param testContext TestNG Test Context.
     */
    public void onStart(ITestContext testContext) {

        // Generate a timestamp for the report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

        // Set up ExtentSparkReporter with specified report location and configuration
        sparkReporter.config().setDocumentTitle("nopcommerce Automation Report"); // Title of report
        sparkReporter.config().setReportName("nopcommerce Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports and attach the ExtentSparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "nopcommerce");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));

        // Set system information from TestNG configuration
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        // Display groups information in the report
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    /**
     * Executed on test success, logs the test success status in the Extent report.
     * @param result TestNG test result.
     */
    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // to display groups in report
        test.log(Status.PASS,result.getName()+" got successfully executed");

    }

    /**
     * Executed on test failure, logs the test failure status, captures a screenshot, and attaches it to the Extent report.
     * @param result TestNG test result.
     */
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,result.getName()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        // Capture screenshot and attach to the report
        String imgPath = new BaseClass().captureScreen(result.getName());
        test.addScreenCaptureFromPath(imgPath);

    }

    /**
     * Executed on test skip, logs the test skip status in the Extent report.
     * @param result TestNG test result.
     */
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+" got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    /**
     * Executed after the test suite finishes, flushes the Extent report and opens the report file in the default browser.
     * @param testContext TestNG Test Context.
     */
    public void onFinish(ITestContext testContext) {
        // Flush the Extent report
        extent.flush();

        // Open the generated report in the default browser
        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
