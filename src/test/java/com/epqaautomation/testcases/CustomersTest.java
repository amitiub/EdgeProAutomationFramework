package com.epqaautomation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.CustomersPage;


public class CustomersTest extends BaseClass {
	
	
	@Test(priority = 1)
	public void createCustomer() throws InterruptedException {
		CustomersPage Customer = PageFactory.initElements(driver, CustomersPage.class);
		String custName = excel.getStringData("Customers", 2, 1);
		Customer.btnCustomersMenu.click();
		Customer.deleteCust(custName);
		Customer.createCust(excel.getStringData("Customers", 1, 1), excel.getStringData("Customers", 1, 2));
		Customer.wait.until(ExpectedConditions.visibilityOf(Customer.msgSuccess));
		Assert.assertEquals(Customer.msgSuccess.getText(), "Customer was created successfully");
	}
	
	@Test(priority = 2, dependsOnMethods = { "createCustomer" })
	public void createDuplicateCustomer() throws InterruptedException {
		CustomersPage Customer = PageFactory.initElements(driver, CustomersPage.class);
		Customer.createCust(excel.getStringData("Customers", 1, 1), excel.getStringData("Customers", 1, 2));
		Customer.wait.until(ExpectedConditions.visibilityOf(Customer.msgSuccess));
		Assert.assertEquals(Customer.msgSuccess.getText(),
				"An organization for given name already exists. Please enter a different name.");
	}
	
	@Test(priority = 3, dependsOnMethods = { "createCustomer" })
	public void editCustomer() throws InterruptedException {
		CustomersPage Customer = PageFactory.initElements(driver, CustomersPage.class);
		Customer.editCust(excel.getStringData("Customers", 3, 1), excel.getStringData("Customers", 3, 2));
		Customer.wait.until(ExpectedConditions.visibilityOf(Customer.msgSuccess));
		Assert.assertEquals(Customer.msgSuccess.getText(), "Customer was updated successfully");
	}

	@Test(priority = 4, dependsOnMethods = { "createCustomer" })
	public void deleteCustomer() throws InterruptedException {
		CustomersPage Customer = PageFactory.initElements(driver, CustomersPage.class);
		String custName = excel.getStringData("Customers", 2, 1);
		Customer.deleteCust(custName);
		System.out.println("Customer(s) deleted successfully");
	}
}


