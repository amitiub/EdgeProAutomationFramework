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

public class CustomersPage {

	public WebDriver driver;
	public WebDriverWait wait;

	// Customer page.
	@FindBy(how = How.XPATH, using = "//div[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button'][1]")
	public WebElement btnCustomersMenu;

	@FindBy(how = How.XPATH, using = "//a[@class='MuiButtonBase-root MuiButton-root customers_addbtn MuiButton-text']")
	public WebElement btnAddCustomer;

	@FindBy(how = How.ID, using = "customer-name")
	public WebElement txtCustName;

	@FindBy(how = How.ID, using = "customer-description")
	public WebElement txtCustDesc;

	@FindBy(how = How.ID, using = "save-customer")
	public WebElement btnSave;

	@FindBy(how = How.ID, using = "message-id")
	public WebElement msgSuccess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'WebDriver')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'edit-customer')]")
	public WebElement btnEditCustomer;

	/*@FindBy(how = How.XPATH, using = "//span[contains(text(), 'WebDriver')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-customer')]")
	public WebElement btnDeleteCustomer;*/

	@FindBy(how = How.ID, using = "confirmDelete")
	public WebElement btnDeleteConfirm;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'\" + custName\r\n"
			+ "	+ \"')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-customer')]")
	public WebElement btnDeleteCustomer;

	public CustomersPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}
	
	public void createCust(String name, String description) {
		btnCustomersMenu.click();
		btnAddCustomer.click();
		txtCustName.sendKeys(name);
		txtCustDesc.sendKeys(description);
		btnSave.click();
	}
	
	public void editCust(String name, String description) throws InterruptedException {
		btnCustomersMenu.click();
		btnEditCustomer.click();
		txtCustName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),name);
		txtCustDesc.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),description);
		btnSave.click();
	}
	
	public void deleteCust(String custName) throws InterruptedException {

		int custCount = 0;
		custCount = driver
				.findElements(By.xpath("//span[contains(text(),'" + custName
						+ "')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-customer')]"))
				.size();
		while (custCount > 0) {
			driver.navigate().to("http://epqa.metocean.com/home/customers");
			wait.until(ExpectedConditions.visibilityOf(btnDeleteCustomer)).click();
			wait.until(ExpectedConditions.visibilityOf(btnDeleteConfirm)).click();
			custCount--;
		}
	}
}
