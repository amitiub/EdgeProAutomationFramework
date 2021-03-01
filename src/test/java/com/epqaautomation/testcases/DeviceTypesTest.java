package com.epqaautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.CustomersPage;
import com.epqaautomation.pages.DeviceTypesPage;
import com.epqaautomation.pages.UserLoginPage;


public class DeviceTypesTest extends BaseClass {

	@Test(priority = 1)
	public void createDeviceType() throws InterruptedException {		
		DeviceTypesPage DeviceTypes = PageFactory.initElements(driver, DeviceTypesPage.class);
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		//DataFormatter df = new DataFormatter();
		//String value = df.formatCellValue(cell);
		DeviceTypes.createDeviceType(excel.getStringData("DeviceTypes", 1, 1), excel.getStringData("Users", 2, 1), excel.getStringData("Users", 3, 1), excel.getNumericData("Users", 4, 1));	
	}

	@Test(priority = 2, dependsOnMethods = { "createDeviceType" })
	public void editDeviceTypes() throws InterruptedException {
		DeviceTypesPage DeviceTypes = PageFactory.initElements(driver, DeviceTypesPage.class);
		DeviceTypes.editDeviceTypes(excel.getStringData("Customers", 3, 1), excel.getStringData("Customers", 3, 2));
		DeviceTypes.wait.until(ExpectedConditions.visibilityOf(DeviceTypes.msgSuccess));
		Assert.assertEquals(DeviceTypes.msgSuccess.getText(), "Customer was updated successfully");
	}
	
	@Test(priority = 3, dependsOnMethods = { "createDeviceType" })
	public void deleteDeviceType() throws InterruptedException {
		DeviceTypesPage DeviceTypes = PageFactory.initElements(driver, DeviceTypesPage.class);
		String deviceTypeName = excel.getStringData("DeviceTypes", 2, 1);
		DeviceTypes.deleteDeviceType(deviceTypeName);
		System.out.println("User(s) deleted successfully");
	}
}