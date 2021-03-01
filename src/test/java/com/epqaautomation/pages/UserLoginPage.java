package com.epqaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserLoginPage {
	
	@FindBy(how= How.ID, using ="email")
	public WebElement txtUseremail;
	
	@FindBy(how= How.ID, using ="password")
	public WebElement txtPassword;
	
	@FindBy(how= How.ID, using ="login-submit")
	public WebElement btnSignIn;
	
	@FindBy(how= How.XPATH, using ="//span[@class='MuiIconButton-label']/parent::button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")
	public WebElement btnProfileMenu;
	
	@FindBy(how= How.XPATH, using ="//a[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button MuiMenuItem-root MuiMenuItem-gutters'][2]")
	public WebElement btnLogOut;
	
	public void login_epqa(String uid, String upassword) {
		txtUseremail.sendKeys(uid);
		txtPassword.sendKeys(upassword);
		btnSignIn.click();
	}
	
	public void logout_epqa() {
		btnProfileMenu.click();
		btnLogOut.click();
	}

	
}
