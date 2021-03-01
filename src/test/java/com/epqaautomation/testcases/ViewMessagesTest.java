package com.epqaautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.GroupPage;
import com.epqaautomation.pages.TraceMessagesPage;
import com.epqaautomation.pages.UserLoginPage;
import com.epqaautomation.pages.ViewMessagesPage;

public class ViewMessagesTest extends BaseClass {

	@Test(priority = 1)
	public void selectCustomer() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		String custName = excel.getStringData("Customers", 4, 1);
		viewMessage.SelectCustomer(custName);
		System.out.println("Customer selected successfully");
	}

	
	@Test(priority = 2)
	public void viewMessage() throws InterruptedException {
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		System.out.println("Device selected successfully");
		//viewMessage.verifyMO(excel.getStringData("Commands", 2, 1));
	}

	
	/*@Test(priority = 3)
	public static void verifyMO() throws InterruptedException {
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		String a = viewMessage.verifyMO(excel.getStringData("Commands", 2, 1));
		Assert.assertEquals(a, "messages");*/
	}

