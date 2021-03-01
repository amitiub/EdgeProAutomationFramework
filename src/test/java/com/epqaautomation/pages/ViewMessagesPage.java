package com.epqaautomation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewMessagesPage {

	public static WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement txtSelectCustomer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Message History')]")
	public WebElement btnMsgHistory;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View Messages')]")
	public WebElement btnViewMsg;

	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement deviceName;

	@FindBy(how = How.ID, using = "select-messageType")
	public WebElement messageType;

	@FindBy(how = How.XPATH, using = "//*[@id='menu-messageType']/div[3]/ul/li[4]/em")
	public WebElement allMessages;

	@FindBy(how = How.ID, using = "start-date")
	public WebElement calendarStartDate;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiPickersCalendarHeader-switchHeader']/button/span[@class='MuiIconButton-label']")
	public WebElement calendarStartDateArrow;

	@FindBy(how = How.XPATH, using = "//p[@class='MuiTypography-root MuiTypography-body2 MuiTypography-colorInherit'][contains(text(),'14')]")
	public WebElement calendarSelectStartDate;

	@FindBy(how = How.XPATH, using = "//span[@class='MuiButton-label'][contains(text(),'OK')]")
	public WebElement calendarSelectOK;

	@FindBy(how = How.ID, using = "end-date")
	public WebElement calendarEndDate;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiPickersCalendarHeader-switchHeader']/div/following-sibling::button/span[@class='MuiIconButton-label']")
	public WebElement calendarEndDateArrow;

	@FindBy(how = How.XPATH, using = "//p[@class='MuiTypography-root MuiTypography-body2 MuiTypography-colorInherit'][contains(text(),'14')]")
	public WebElement calendarSelectEndDate;	
	@FindBy(how = How.XPATH, using = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label'][contains(text(),'Data Table')]")
	public WebElement dataTable;

	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Submit')]")
	public WebElement btnSubmit;

	@FindBy(how = How.ID, using = "message-id")
	public WebElement msgSuccess;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), '\"SUCCESS\"')]")
	public static WebElement txtSUCCESSNew;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'SUCCESS')]")
	public static WebElement txtSUCCESS;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Success')]")
	public static WebElement txtSuccess;

	@FindBy(how = How.XPATH, using = "//div[@aria-rowindex='1']/div[@aria-colindex='9']/span/div/button")
	public static WebElement btnAction;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'messages')]")
	public static WebElement txtGetMessages;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'status')]")
	public static WebElement txtGetMessagesStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'pin1Config')]")
	public static WebElement txtSendReport;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), '\"DIGITAL_INPUT\"')]")
	public static WebElement txtSendReportVal;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'accelerationX')]")
	public static WebElement txtReadAcceleration;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'temperature')]")
	public static WebElement txtTemperature;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'value')]")
	public static WebElement txtGetProperties;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'fixGnssMode')]")
	public static WebElement txtPosition;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), '\"GPS_GLONASS\"')]")
	public static WebElement txtPositionVal;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'pinNumber')]")
	public static WebElement txtReadPin;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), '\"GPIO_2\"')]")
	public static WebElement txtReadPinVal;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'result')]")
	public static WebElement txtcreateGeoFence;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'response')]")
	public static WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'resultCode')]")
	public static WebElement txtGetMessage;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), '\"MESSAGE_NOT_FOUND\"')]")
	public static WebElement txtGetMessageVal;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'firmwareVersion')]")
	public static WebElement txtgetVersion;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'resultCode')]")
	public static WebElement txtPulseCount;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'deviceId')]")
	public static WebElement txtDeviceInfo;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'inputVoltage')]")
	public static WebElement txtDeviceStatus;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'success')]")
	public static WebElement txtStatus;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'resultCode')]")
	public static WebElement txtresultCode;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'threadCount')]")
	public static WebElement txtThreadCount;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'serviceNumber')]")
	public static WebElement txtserviceNumber;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'true')]")
	public static WebElement txtTrue;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'number')]")
	public static WebElement txtgeonumber;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'state')]")
	public static WebElement txtState;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'false')]")
	public static WebElement txtFalse;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'geofenceStatusList')]")
	public static WebElement txtgeoStatusList;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'notifyCondition')]")
	public static WebElement txtNotifyCondition;

	@FindBy(how = How.XPATH, using ="//span[contains(text(), 'ENTER')]")
	public static WebElement txtNotifyConditionEnter;


	public ViewMessagesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	public void SelectCustomer(String custName) {
		btnMsgHistory.click();
		btnViewMsg.click();
		txtSelectCustomer.sendKeys(custName);
		txtSelectCustomer.sendKeys(Keys.DOWN);
		txtSelectCustomer.sendKeys(Keys.RETURN);
	}

	public void goToViewMsgPage() {
		btnMsgHistory.click();
		btnViewMsg.click();
	}

	public void viewMessage(String DeviceName) throws InterruptedException {
		deviceName.sendKeys(DeviceName);
		deviceName.sendKeys(Keys.DOWN);
		deviceName.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		messageType.click();
		Thread.sleep(1000);
		allMessages.click();
		Thread.sleep(1000);
		// Select Start Date.
		calendarStartDate.click();
		Thread.sleep(1000);
		calendarStartDateArrow.click();
		Thread.sleep(1000);
		calendarSelectStartDate.click();
		calendarSelectOK.click();
		Thread.sleep(1000);

		//Select End Date.
		calendarEndDate.click();
		Thread.sleep(1000);
		calendarEndDateArrow.click();
		Thread.sleep(1000);
		calendarSelectEndDate.click();
		calendarSelectOK.click();
		Thread.sleep(1000);
		dataTable.click();
		Thread.sleep(1000);
		btnSubmit.click();
		Thread.sleep(2000);
	}


	public  String verifyMO(String commands) throws InterruptedException {
		WebElement sendMsg = btnAction;
		Actions actions = new Actions(driver);
		actions.moveToElement(sendMsg).click().build().perform();
		Thread.sleep(2000);
		String attribute="Attribute not found!";
		String attributeName = "Attribute not found!";
		String attributeVal = "Attribute not found!";

		switch (commands) 
		{

		case "setProperties":
			try {
				attributeName = txtresultCode.getText();
				attributeVal = txtSUCCESSNew.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("resultCode:") && attributeVal.contains("\"SUCCESS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getMessages":
			try {
				attributeName = txtGetMessagesStatus.getText();
				attributeVal = txtSUCCESSNew.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("status:") && attributeVal.contains("\"SUCCESS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "sendReport":
			try {
				attributeName = txtSendReport.getText();
				attributeVal = txtSendReportVal.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);

			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("pin1Config:") && attributeVal.contains("\"DIGITAL_INPUT\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}
	      
		case "getPosition":
			try {
				attributeName = txtPosition.getText();
				attributeVal = txtPositionVal.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);

			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("fixGnssMode:") && attributeVal.contains("\"GPS_GLONASS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "createCircle":
			try {
				attributeName = txtcreateGeoFence.getText();
				attributeVal = txtSUCCESS.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("result:\"SUCCESS\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "createRectangle":
			try {
				attributeName = txtcreateGeoFence.getText();
				attributeVal = txtSUCCESS.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);

			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("result:\"SUCCESS\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "readTemperature":
			try {
				attribute = txtTemperature.getText();
				System.out.println("Attribute to verify: " + attribute);

			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("temperature:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			} 

		case "updatePassword":
			try {
				attributeName = txtPassword.getText();
				attributeVal = txtSuccess.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("response:\"Success\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "readAcceleration":
			try {
				attribute = txtReadAcceleration.getText();
				System.out.println("Attribute to verify: " + attribute);

			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("accelerationX:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "readPin":
			try {
				attributeName = txtReadPin.getText();
				attributeVal = txtReadPinVal.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("pinNumber:\"GPIO_2\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getProperties":
			try {
				attribute = txtGetProperties.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("value:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getMessage":
			try {
				attributeName = txtGetMessage.getText();
				attributeVal = txtGetMessageVal.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("resultCode:\"MESSAGE_NOT_FOUND\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getPositionDetails":
			try {
				attribute = txtPosition.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("fixTime:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}


		case "getDeviceInfo":
			try {
				attribute = txtDeviceInfo.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("deviceId:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getLastKnownPosition":
			try {
				attributeName = txtPosition.getText();
				attributeVal = txtPositionVal.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("fixGnssMode:") && attributeVal.contains("\"GPS_GLONASS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "createPolygon":
			try {
				attributeName = txtcreateGeoFence.getText();
				attributeVal = txtSUCCESS.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("result:\"SUCCESS\"")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getDeviceStatus":
			try {
				attribute = txtDeviceStatus.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("inputVoltage:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "resetOdometer":
			try {
				attributeName = txtStatus.getText();
				attributeVal = txtTrue.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("success:") && attributeVal.contains("true"))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}	    	 

		case "getGeofenceStatusByNumber":
			try {
				attribute = txtgeonumber.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("number:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "disableGeofence":
			try {
				attributeName = txtState.getText();
				attributeVal = txtFalse.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}


			if ((attributeName.contains("state:") && attributeVal.contains("false"))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "enableGeofence":
			try {
				attributeName = txtState.getText();
				attributeVal = txtTrue.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}


			if ((attributeName.contains("state:") && attributeVal.contains("true"))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getGeofenceInfoByNumber":
			try {
				attribute = txtgeonumber.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("number:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "updateGeofenceName":
			try {
				attributeName = txtcreateGeoFence.getText();
				attributeVal = txtSUCCESS.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attributeName.contains("result:") && attributeVal.contains("\"SUCCESS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getGeofenceStatusList":
			try {
				attribute = txtgeoStatusList.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if ((attribute.contains("geofenceStatusList:"))){
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "updateNotifyCondition":
			try {
				attributeName = txtNotifyCondition.getText();
				attributeVal = txtNotifyConditionEnter.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}
			if ((attributeName.contains("notifyCondition:") && attributeVal.contains("\"ENTER\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "deleteGeofence":
			try {
				attributeName = txtcreateGeoFence.getText();
				attributeVal = txtSUCCESSNew.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}
			if ((attributeName.contains("result:") && attributeVal.contains("\"SUCCESS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}

		case "getDeviceHealth":

			try {
				attribute = txtThreadCount.getText();
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}

			if (attribute.contains("threadCount:")) {
				return attribute;
			} else {
				return "Unexpected Attribute value found!";
			} 

			/*
			 * case "getserviceInfo":
			 * 
			 * try { attributeName = txtserviceNumber.getText(); attributeVal =
			 * txtSuccess.getText(); attribute = attributeName + attributeVal;
			 * System.out.println("Attribute to verify: " + attribute); } catch (Exception
			 * e) { System.out.println("Unable to find attribute!"); }
			 * 
			 * if (attribute.contains("response:\"Success\"")) { return attribute; } else {
			 * return "Unexpected Attribute value found!"; }
			 */

		case "syncTime":
			try {
				attributeName = txtresultCode.getText();
				attributeVal = txtSUCCESS.getText();
				attribute = attributeName + attributeVal;
				System.out.println("Attribute to verify: " + attribute);
			} catch (Exception e) {
				System.out.println("Unable to find attribute!");
			}


			if ((attributeName.contains("resultCode:") && attributeVal.contains("\"SUCCESS\""))) {
				return attributeName + attributeVal;
			} else {
				return "Unexpected Attribute value found!";
			}
		}
		return "Attribute not found!";
	}
}