package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/failedrerun.txt"}, // Use the @ symbol to specify the rerun file
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "junit:target/JunitReports/rerun_report.xml",
                "html:target/rerun_cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@AVIVTest"
)
public class RerunTestRunner extends AbstractTestNGCucumberTests {
}
