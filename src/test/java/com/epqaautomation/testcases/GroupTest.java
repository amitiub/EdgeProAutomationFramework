package com.epqaautomation.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.UserLoginPage;
import com.epqaautomation.pages.GroupPage;


public class GroupTest extends BaseClass {
	
	/*@Test(priority = 1)
	public void deleteExistingGroup() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Thread.sleep(3000);
		GroupPage group = PageFactory.initElements(driver, GroupPage.class);
		group.SelectCustomer();
		String groupName = excel.getStringData("Group", 1, 1);
		group.deleteGroup(groupName);
		System.out.println("Group(s) deleted successfully");
	}*/
	
	@Test(priority = 1)
	public void createGroup() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Thread.sleep(3000);
		GroupPage group = PageFactory.initElements(driver, GroupPage.class);
		group.SelectCustomer();
		group.createGroup(excel.getStringData("Group", 1, 1));
		//group.wait.until(ExpectedConditions.visibilityOf(group.msgSuccess));
		//Assert.assertEquals(group.msgSuccess.getText(), "Group was created successfully");
	}
	
	@Test(priority = 3, dependsOnMethods = { "createGroup" })
	public void createDuplicateGroup() throws InterruptedException {
		GroupPage group = PageFactory.initElements(driver, GroupPage.class);
		group.createGroup(excel.getStringData("Group", 1, 1));
		group.wait.until(ExpectedConditions.visibilityOf(group.msgSuccess));
		Assert.assertEquals(group.msgSuccess.getText(),
				"Assets Group already exists.");
	}
	

	@Test(priority = 4, dependsOnMethods = { "createGroup" })
	public void deleteGroup() throws InterruptedException {
		GroupPage group = PageFactory.initElements(driver, GroupPage.class);
		String groupName = excel.getStringData("Group", 1, 1);
		group.deleteGroup(groupName);
		System.out.println("Group(s) deleted successfully");
	}
}


