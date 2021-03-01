package com.epqaautomation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.UserLoginPage;

public class LoginTest extends BaseClass {
	
	@Test(priority=1)
	public void loginSuperAdmin() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.logout_epqa();
		login_Page.login_epqa(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Assert.assertEquals(driver.getTitle().contains("Edge(R) Pro Web Portal"),  true);
		login_Page.logout_epqa();
	}
	
	@Test(priority=2, dependsOnMethods={"loginSuperAdmin"})
	public void loginAdmin() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		Assert.assertEquals(driver.getTitle().contains("Edge(R) Pro Web Portal"),  true);
		login_Page.logout_epqa();
	}
	
	@Test(priority=3, dependsOnMethods={"loginSuperAdmin"})
	public void loginStdUser() throws InterruptedException {
		UserLoginPage login_Page = PageFactory.initElements(driver, UserLoginPage.class);
		login_Page.login_epqa(excel.getStringData("Login", 2, 0), excel.getStringData("Login", 2, 1));
		Assert.assertEquals(driver.getTitle().contains("Edge(R) Pro Web Portal"),  true);
		login_Page.logout_epqa();
	}
}