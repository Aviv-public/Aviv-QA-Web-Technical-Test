/**
 * Author: Rakesh Mustoor
 */
package com.aviv.UITests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aviv.base.BaseClass;
import com.aviv.pages.CommonPage;
import com.aviv.util.TestUtil;

public class UIAssignmentTests extends BaseClass
{

	CommonPage commonPage;
	TestUtil testUtil;

	public UIAssignmentTests()
	{
		super();
	}

	@BeforeSuite
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		commonPage = new CommonPage();
	}
	
	@BeforeTest
	   public void setOutputDirectory(ITestContext context) {
	      TestRunner runner = (TestRunner) context;
	      runner.setOutputDirectory(System.getProperty("user.dir")+"/reports");
	   }

	@Test(priority = 1)
	public void newUserSignupAndCheckout() throws InterruptedException, IOException
	{
		commonPage.signUpAndPlaceOrderScenario();
	}

	@Test(priority = 2)
	public void invalidSignupAttempt() throws InterruptedException
	{
		commonPage.signUpFailureScenario();
	}

	@Test(priority = 3)
	public void existingUserLoginAndCheckout() throws InterruptedException
	{
		commonPage.loginAndPlaceOrderScenario();
	}

	@Test(priority = 4)
	public void verifyCartFunctionality() throws InterruptedException
	{
		commonPage.cartBehaviourScenario();
	}

	@AfterSuite
	public void cleanUp()
	{
		driver.quit();
	}

}
