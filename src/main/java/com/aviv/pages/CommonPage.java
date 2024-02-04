/**
 * Author: Rakesh Mustoor
 */

package com.aviv.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aviv.base.BaseClass;
import com.aviv.util.TestUtil;

public class CommonPage extends BaseClass
{
	TestUtil testUtil;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logOut;

	@FindBy(id = "gender-male")
	WebElement genderMale;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//*[text()='Your registration completed']")
	WebElement registrationSuccess;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")
	WebElement continueButton;

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement login;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@class='top-menu notmobile']//a[@href='/computers']")
	WebElement computersMenu;

	@FindBy(xpath = "//*[@class='page-body']//a[@href='/notebooks']")
	WebElement notebooks;

	@FindBy(xpath = "//*[@class='top-menu notmobile']//a[@href='/books']")
	WebElement booksMenu;

	@FindBy(xpath = "//*[@class='page-body']//a[@href='/shoes']")
	WebElement shoes;

	@FindBy(xpath = "//*[@class='top-menu notmobile']//a[@href='/electronics']")
	WebElement electronicsMenu;

	@FindBy(xpath = "//*[@class='page-body']//a[@href='/cell-phones']")
	WebElement cellphones;

	@FindBy(xpath = "//BUTTON[text()='Add to cart'][1]")
	WebElement addToCart;

	@FindBy(xpath = "//*[@class='qty-input']//following::button[1]")
	WebElement addToCart2;

	@FindBy(xpath = "//*[contains(text(),'The product has been added to your')]")
	WebElement addedToCartSuccessMessage;

	@FindBy(xpath = "//a[@class='ico-cart']")
	WebElement shoppingCart;

	@FindBy(id = "termsofservice")
	WebElement termsOfService;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;

	@FindBy(id = "BillingNewAddress_City")
	WebElement city;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zip;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phone;

	@FindBy(xpath = "//*[@id='billing-buttons-container']//button[@name='save']")
	WebElement continueBilling;

	@FindBy(className = "shipping-method-next-step-button")
	WebElement continueShipping;

	@FindBy(className = "payment-method-next-step-button")
	WebElement continuePayment;

	@FindBy(className = "payment-info-next-step-button")
	WebElement continuePaymentInfo;

	@FindBy(className = "confirm-order-next-step-button")
	WebElement confirmOrder;

	@FindBy(xpath = "//*[text()='Your order has been successfully processed!']")
	WebElement orderSuccess;

	@FindBy(xpath = "//*[text()='The specified email already exists']")
	WebElement duplicateEmail;

	@FindBy(xpath = "//*[@class='order-number']")
	WebElement orderNum;

	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccount;

	@FindBy(xpath = "//*[@class='listbox']//*[text()=\"Orders\"]")
	WebElement orders;

	@FindBy(xpath = "//*[@class='order-list']//child::strong")
	WebElement orderNumMyAccount;

	@FindBy(xpath = "//*[@class='message-error validation-summary-errors']//li")
	WebElement signUpError;

	@FindBy(xpath = "//*[@class='product-title']")
	WebElement firstItem;

	@FindBy(xpath = "//*[@class='product-title']")
	WebElement itemName;

	SoftAssert softAssert = new SoftAssert();

	public CommonPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void loadUrl(String url)
	{
		driver.get(url);
	}

	public void signUpAndPlaceOrderScenario() throws IOException, InterruptedException
	{
		String orderNumberExpected, orderNumberActual;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		testUtil = new TestUtil();
		testUtil.setEmailValue();
		prop.getProperty("email");
		register.click();
		signUp();
		wait.until(ExpectedConditions.visibilityOf(registrationSuccess));
		softAssert.assertEquals("Your registration completed", registrationSuccess.getText(),
				"Registration success message is incorrect");
		continueButton.click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		signIn();
		computersMenu.click();
		notebooks.click();
		addToCart.click();
		addToCart2.click();
		wait.until(ExpectedConditions.visibilityOf(addedToCartSuccessMessage));
		softAssert.assertTrue(addedToCartSuccessMessage.isDisplayed());
		driver.navigate().refresh();
		shoppingCart.click();
		termsOfService.click();
		checkoutButton.click();
		Select selCountry = new Select(country);
		selCountry.selectByVisibleText(prop.getProperty("country"));
		city.sendKeys(prop.getProperty("city"));
		address1.sendKeys(prop.getProperty("address1"));
		zip.sendKeys(prop.getProperty("zip"));
		phone.sendKeys(prop.getProperty("phone"));
		continueBilling.click();
		continueShipping.click();
		wait.until(ExpectedConditions.elementToBeClickable(continuePayment));
		continuePayment.click();
		wait.until(ExpectedConditions.elementToBeClickable(continuePaymentInfo));
		continuePaymentInfo.click();
		confirmOrder.click();
		softAssert.assertTrue(orderSuccess.isDisplayed());
		orderNumberExpected = orderNum.getText().replaceAll("[^0-9]", "");
		myAccount.click();
		orders.click();
		orderNumberActual = orderNumMyAccount.getText().replaceAll("[^0-9]", "");
		softAssert.assertEquals(orderNumberExpected, orderNumberActual, "latest Order not found");
		logOut.click();
	}

	public void signUpFailureScenario()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		register.click();
		genderMale.click();
		firstName.sendKeys(prop.getProperty("firstName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		email.sendKeys(prop.getProperty("invalidEmail"));
		password.sendKeys(System.getenv("password"));
		confirmPassword.sendKeys(System.getenv("password"));
		registerButton.click();
		wait.until(ExpectedConditions.visibilityOf(signUpError));
		softAssert.assertEquals("Wrong email", signUpError.getText(), "Error message is not correct");
	}

	public void loginAndPlaceOrderScenario() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		login.click();
		signIn();
		booksMenu.click();
		addToCart.click();
		wait.until(ExpectedConditions.visibilityOf(addedToCartSuccessMessage));
		softAssert.assertTrue(addedToCartSuccessMessage.isDisplayed());
		driver.navigate().refresh();
		shoppingCart.click();
		termsOfService.click();
		checkoutButton.click();
		continueBilling.click();
		continueShipping.click();
		continuePayment.click();
		continuePaymentInfo.click();

//		App doesnt allow user to place the orders back to back
//		confirmOrder.click();
//		Boolean msg = driver.switchTo().activeElement().getText()
//				.contains("Please wait several seconds before placing a new order");
//		softAssert.assertTrue(msg);
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ESCAPE);
		logOut.click();
	}

	public void cartBehaviourScenario() throws InterruptedException
	{
		int countBefore, countAfter, countInCart;
		driver.navigate().refresh();
		countBefore = Integer.valueOf(shoppingCart.getText().replaceAll("[^0-9]", ""));
		booksMenu.click();
		String name = firstItem.getText();
		addToCart.click();
		countAfter = Integer.valueOf(shoppingCart.getText().replaceAll("[^0-9]", ""));
		softAssert.assertEquals(countBefore + 1, countAfter, "Items count is not incremented in the cart");
		shoppingCart.click();
		softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).isDisplayed());
		countInCart = Integer.valueOf(shoppingCart.getText().replaceAll("[^0-9]", ""));
		softAssert.assertEquals(1, countInCart, "Items count within cart is not correct");
		countBefore = countAfter;
		electronicsMenu.click();
		cellphones.click();
		name = firstItem.getText();
		addToCart.click();
		countAfter = Integer.valueOf(shoppingCart.getText().replaceAll("[^0-9]", ""));
		softAssert.assertEquals(countBefore + 1, countAfter, "Items count is not incremented in the cart");
		shoppingCart.click();
		softAssert
				.assertTrue(driver.findElement(By.xpath("//*[@class='cart']//*[text()='" + name + "']")).isDisplayed());
		countInCart = Integer.valueOf(shoppingCart.getText().replaceAll("[^0-9]", ""));
		softAssert.assertEquals(1, countInCart, "Items count within cart is not correct");
		countBefore = countAfter;
		driver.findElement(By.xpath("//*[@class='cart']//*[text()='" + name + "']//following::button[1]")).click();
		softAssert.assertEquals(countBefore, countAfter - 1, "Items count is not decremented in the cart");
	}
		
	private void signUp()
	{
		genderMale.click();
		firstName.sendKeys(prop.getProperty("firstName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		email.sendKeys(prop.getProperty("email"));
		password.sendKeys(System.getenv("password"));
		confirmPassword.sendKeys(System.getenv("password"));
		registerButton.click();
	}
	
	private void signIn()
	{
		email.sendKeys(prop.getProperty("email"));
		password.sendKeys(System.getenv("password"));
		loginButton.click();
	}

}
