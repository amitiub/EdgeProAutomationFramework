package com.epqaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button'][3]")
	public WebElement btnGroupsMenu;
	
	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement txtSelectCustomer;
	
	@FindBy(how = How.XPATH, using = "//a[@class='MuiButtonBase-root MuiButton-root assetgroups_addbtn MuiButton-text']")
	public WebElement btnAddGroup;
	
	@FindBy(how = How.XPATH, using = "//div[@role='radiogroup']//input")
	public WebElement radioBtn1GrpTypeDevice;
	
	@FindBy(how = How.XPATH, using = "//input[@id='asset-group']/following::input[@name='assetGroupType'][1]")
	public WebElement radioBtn2GrpTypeDevice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='assetGroupType'][4]")
	public WebElement radioBtnGeofence;

	@FindBy(how = How.ID, using = "asset-group")
	public WebElement txtGrpName;

	@FindBy(how = How.ID, using = "save-asset-group")
	public WebElement btnSave;

	@FindBy(how = How.ID, using = "message-id")
	public WebElement msgSuccess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'WebDriver')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-asset-group')]")
	public WebElement btnDeleteAssetGroup;

	@FindBy(how = How.ID, using = "confirmDelete")
	public WebElement btnDeleteConfirm;

	public GroupPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}
	
	public void SelectCustomer() {
		btnGroupsMenu.click();
		txtSelectCustomer.click();
		txtSelectCustomer.sendKeys(Keys.DOWN);
		txtSelectCustomer.sendKeys(Keys.RETURN);
	}

	public void createGroup(String name) {
		radioBtn1GrpTypeDevice.click();
		btnAddGroup.click();
		txtGrpName.sendKeys(name);
		radioBtn2GrpTypeDevice.click();
		btnSave.click();
	}
	public void createDuplicateGroup(String name) throws InterruptedException{
		radioBtn1GrpTypeDevice.click();
		btnAddGroup.click();
		txtGrpName.sendKeys(name);
		radioBtn2GrpTypeDevice.click();
		btnSave.click();
	}
		
	public void deleteGroup(String name) throws InterruptedException {
		int groupCount = 0;
		groupCount = driver
				.findElements(By.xpath("//span[contains(text(),'" + name
						+ "')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-asset-group')]"))
				.size();
		while (groupCount > 0) {
			driver.navigate().to("http://epqa.metocean.com/home/assetgroups");
			radioBtn1GrpTypeDevice.click();
			wait.until(ExpectedConditions.visibilityOf(btnDeleteAssetGroup)).click();
			wait.until(ExpectedConditions.visibilityOf(btnDeleteConfirm)).click();
			groupCount--;
		}
	}
		/*public void deleteExistingGroup(String name) throws InterruptedException {
			int groupCount = 0;
			groupCount = driver
					.findElements(By.xpath("//span[contains(text(),'" + name
							+ "')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-asset-group')]"))
					.size();
			while (groupCount > 0) {
				driver.navigate().to("http://epqa.metocean.com/home/assetgroups");
				radioBtn1GrpTypeDevice.click();
				wait.until(ExpectedConditions.visibilityOf(btnDeleteAssetGroup)).click();
				wait.until(ExpectedConditions.visibilityOf(btnDeleteConfirm)).click();
				groupCount--;
			}
	}*/
}
