package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
                "json:target/cucumber.json",
                "junit:target/JunitReports/report.xml",
                "html: target/cucumber-reports.html",
                "rerun:target/failedrerun.txt", // Output file for failed scenarios
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@AVIVTest")

public class parallelTestRunner extends AbstractTestNGCucumberTests {
//    Parallel Testing can be handled using below code
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}