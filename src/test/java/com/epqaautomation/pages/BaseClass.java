package com.epqaautomation.pages;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.epqaautomation.utility.APIException;
import com.epqaautomation.utility.BrowserFactory;
import com.epqaautomation.utility.ConfigDataProvider;
import com.epqaautomation.utility.ExcelDataProvider;
import com.epqaautomation.utility.Helper;
import com.epqaautomation.utility.TestRail;

public class BaseClass {

	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public ConfigDataProvider config;

	public static void waitForElementInDOM(WebDriver driver, String elementIdentifier, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			// this will wait for element to be visible for 15 seconds
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementIdentifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(elementIdentifier)));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setup() throws InterruptedException, IOException, APIException {

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		String custName = excel.getStringData("Customers", 4, 1);
		TraceMsg.selectPage(custName);
		System.out.println("Customer selected successfully.");
		Reporter.log("Customer selected successfully.");
		// Create Test Run in TestRail Project.
		TestRail.createTestRun(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result, ITestContext context)
			throws IOException, APIException, ParseException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.CaptureScreenShot(driver, result.getName());
			List<String> testCaseId = (List<String>) context.getAttribute("testCaseId");
			TestRail.setTestFailureResult(driver, testCaseId);
			System.out.println("Failed Test Case ID: " + testCaseId);
		  }
		if (result.getStatus() == ITestResult.SUCCESS) {
			List<String> testCaseId = (List<String>) context.getAttribute("testCaseId");
			TestRail.setTestSuccessResult(driver, testCaseId);
			System.out.println("Passed Test Case ID: " + testCaseId);
		}
		
		if (result.getStatus() == ITestResult.SKIP) {
			Helper.CaptureScreenShot(driver, result.getName());
			List<String> testCaseId = (List<String>) context.getAttribute("testCaseId");
			TestRail.setTestFailureResult(driver, testCaseId);
			System.out.println("Failed Test Case ID: " + testCaseId);
		  }
	}

	@AfterClass()
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
	}
}
