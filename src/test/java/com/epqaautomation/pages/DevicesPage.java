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

public class DevicesPage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(how = How.XPATH, using = "//div/span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary'][text()='Users']")
	public WebElement btnUsersMenu;
	
	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement txtSelectCust;
	

	@FindBy(how = How.XPATH, using = "//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text']")
	public WebElement btnAddUsers;

	@FindBy(how = How.NAME, using = "email")
	public WebElement txtUserEmail;
	
	@FindBy(how = How.ID, using = "standard-first-name")
	public WebElement txtFirstName;
	
	@FindBy(how = How.NAME, using = "lastName")
	public WebElement txtLastName;

	@FindBy(how = How.ID, using = "phone-number")
	public WebElement txtPhone;

	@FindBy(how = How.ID, using = "save-user")
	public WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//span[text()='amit+iub@gmail.com']")
	public WebElement verifyUserCreation;

	@FindBy(how = How.ID, using = "search-text")
	public WebElement btnSearchUser;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'WebDriver')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-customer')]")
	public WebElement btnDeleteCustomer;

	@FindBy(how = How.ID, using = "confirmDelete")
	public WebElement btnDeleteConfirm;
	
	@FindBy(how = How.ID, using = "message-id")
	public WebElement msgSuccess;

	public DevicesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	public void createDevice(String email, String firstName, String lastName, Number phone) throws InterruptedException {
		btnUsersMenu.click();
		txtSelectCust.click();
		txtSelectCust.sendKeys(Keys.DOWN);
		txtSelectCust.sendKeys(Keys.RETURN);
		btnAddUsers.click();
		txtUserEmail.sendKeys(email);
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtPhone.sendKeys(""+phone);
		Thread.sleep(8000);
		btnSave.click();
	}

	public void deleteDevice(String deviceName) throws InterruptedException {

		int userCount = 0;
		userCount = driver
				.findElements(By.xpath("//span[contains(text(),'" + deviceName
						+ "')]/parent::div/following-sibling::div/span/div/button[contains(@id, 'delete-customer')]"))
				.size();
		while (userCount > 0) {
			driver.navigate().to("http://epqa.metocean.com/home/customers");
			wait.until(ExpectedConditions.visibilityOf(btnDeleteCustomer)).click();
			wait.until(ExpectedConditions.visibilityOf(btnDeleteConfirm)).click();
			userCount--;
		}
	}
}
