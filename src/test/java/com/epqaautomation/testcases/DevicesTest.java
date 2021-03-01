package com.epqaautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.DevicesPage;
import com.epqaautomation.pages.UserLoginPage;




public class DevicesTest extends BaseClass {

	@Test(priority = 1)
	public void createDevice() throws InterruptedException {		
		DevicesPage device = PageFactory.initElements(driver, DevicesPage.class);
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		//DataFormatter df = new DataFormatter();
		//String value = df.formatCellValue(cell);
		device.createDevice(excel.getStringData("Devices", 1, 1), excel.getStringData("Users", 2, 1), excel.getStringData("Users", 3, 1), excel.getNumericData("Users", 4, 1));	
	}
	
	@Test(priority = 2, dependsOnMethods = { "createDevice" })
	public void ediDevice() throws InterruptedException {		
		DevicesPage device = PageFactory.initElements(driver, DevicesPage.class);
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		device.createDevice(excel.getStringData("Devices", 1, 1), excel.getStringData("Users", 2, 1), excel.getStringData("Users", 3, 1), excel.getNumericData("Users", 4, 1));	
	}
/*
	@Test(priority = 4, dependsOnMethods = { "createUser" })
	public void deleteDevicer() throws InterruptedException {
		UsersPage User = PageFactory.initElements(driver, UsersPage.class);
		String userName = excel.getStringData("Users", 2, 1);
		User.deleteUser(userName);
		System.out.println("User(s) deleted successfully");
	}*/
	
	@Test(priority = 3, dependsOnMethods = { "createDevice" })
	public void deleteDevice() throws InterruptedException {		
		DevicesPage device = PageFactory.initElements(driver, DevicesPage.class);
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		device.deleteDevice("WebDriver");	
	}
}