package com.epqaautomation.pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TraceMessagesPage {
	public WebDriver driver;
	public WebDriverWait wait;

	// Go to Trace message page.
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Message History')]")
	public WebElement btnMsgHistory;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Trace Messages')]")
	public WebElement BtnTraceMsg;
	
	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement txtSelectCustomer;
	
	// Send a Message.
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Send Message')]")
	public WebElement btnSendMsg;

	@FindBy(how = How.ID, using = "device-input")
	public WebElement txtDevName;

	@FindBy(how = How.ID, using = "messageDescriptorId-input")
	public WebElement txtMsgType;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add row')]")
	public WebElement btnAddRow;

	@FindBy(how = How.XPATH, using = "//div/button/span[contains(text(),'Send Message')]")
	public WebElement btnSendCommand;

	@FindBy(how = How.XPATH, using = "//div/button/span[contains(text(),'Confirm')]")
	public WebElement btnConfirm;

	@FindBy(how = How.XPATH, using = "//div/button/span[contains(text(),'Cancel')]")
	public WebElement btnCancel;

	@FindBy(how = How.ID, using = "message-id")
	public WebElement msgSuccess;

	// Search Messages
	@FindBy(how = How.ID, using = "autoselect-id-input")
	public WebElement txtDeviceName;

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

	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Submit')]")
	public WebElement btnSubmit;

	// Collect message Type and ID.
	@FindBy(how = How.XPATH, using = "//div[@aria-rowindex='1']/div[@aria-colindex='1']/span")
	public static WebElement msgType;

	@FindBy(how = How.XPATH, using = "//div[@aria-rowindex='1']/div[@aria-colindex='2']/span")
	public static WebElement msgID;

	@FindBy(how = How.XPATH, using = "//div[@aria-rowindex='1']/div[@aria-colindex='3']/span")
	public static WebElement correlationID;

	@FindBy(how = How.XPATH, using = "//div[@aria-rowindex='1']/div[@aria-colindex='2']/span")
	public static WebElement moId;

	// setProperties attributes.
	@FindBy(how = How.ID, using = "sn_id")
	public WebElement txtSn;

	@FindBy(how = How.NAME, using = "pn_id")
	public WebElement txtPn;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']")
	public WebElement drpFieldType;

	@FindBy(how = How.XPATH, using = "//li/em[contains(text(),'enum')]")
	public WebElement drpSelectEnum;

	@FindBy(how = How.NAME, using = "value_id")
	public WebElement txtValue;

	// sendReport attributes.
	@FindBy(how = How.ID, using = "reportSn_id")
	public WebElement txtReportSn;

	@FindBy(how = How.NAME, using = "reportMn_id")
	public WebElement txtReportMn;

	@FindBy(how = How.NAME, using = "maxAge_id")
	public WebElement txtMaxAge;

	@FindBy(how = How.NAME, using = "timeout_id")
	public WebElement txtTimeout;

	// getPosition attributes.
	@FindBy(how = How.XPATH, using = "//div[@id='select-fixType_id']")
	public WebElement drpfixType;

	@FindBy(how = How.XPATH, using = "//li[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button MuiMenuItem-root MuiMenuItem-gutters']/em[contains(text(),'FIX_2D')]")
	public WebElement drpSelectFixType;

	@FindBy(how = How.ID, using = "maxAge_id")
	public WebElement txtMaxId;

	@FindBy(how = How.ID, using = "timeout_id")
	public WebElement txtTimeOut;
	
	// createCircle attributes.
	@FindBy(how = How.ID, using = "number_id")
	public WebElement txtGeoNumber;
	
	@FindBy(how = How.ID, using = "name_id")
	public WebElement txtGeoName;
	
	@FindBy(how = How.ID, using = "newFenceName_id")
	public WebElement txtgeoNewName;
	
	@FindBy(how = How.ID, using = "select-enabled_id")
	public WebElement drpEnabled;
	
	@FindBy(how = How.XPATH, using = "//li/em[contains(text(),'True')]")
	public WebElement drpSelectEnabled;
	
	@FindBy(how = How.ID, using = "select-notifyCondition_id")
	public WebElement drpNotifyCondition;

	@FindBy(how = How.XPATH, using = "//li/em[contains(text(),'BOTH')]")
	public WebElement drpSelectNotifyCondition;
	
	@FindBy(how = How.XPATH, using = "//li/em[contains(text(),'ENTER')]")
	public WebElement drpSelectNotifyConditionEnter;
	
	@FindBy(how = How.ID, using = "centerLat_id")
	public WebElement txtCircleLat;
	
	@FindBy(how = How.ID, using = "centerLong_id")
	public WebElement txtCircleLon;
	
	@FindBy(how = How.ID, using = "radius_id")
	public WebElement txtCircleRadius;
	
	@FindBy(how = How.ID, using = "topLeftLat_id")
	public WebElement txtTopLeftLat;
	
	@FindBy(how = How.ID, using = "topLeftLong_id")
	public WebElement txtTopRightLong;
	
	@FindBy(how = How.ID, using = "bottomRightLat_id")
	public WebElement txtBottomLeftLat;
	
	@FindBy(how = How.ID, using = "bottomRightLong_id")
	public WebElement txtBottomRightLong;

	// updatePassword attribute.
	@FindBy(how = How.ID, using = "password_id")
	public WebElement txtupdatePass;

	// readPin attribute.
	@FindBy(how = How.ID, using = "select-pinNumber_id")
	public WebElement drpPinNumber;

	@FindBy(how = How.XPATH, using = "//li/em[contains(text(),'GPIO_2')]")
	public WebElement drpSelectPinNumber;

	// getProperties attributes.
	@FindBy(how = How.ID, using = "sn_id")
	public WebElement txtServiceNumber;

	@FindBy(how = How.ID, using = "pn_id")
	public WebElement txtPropertyNumber;

	// getMessage attribute.
	@FindBy(how = How.ID, using = "mid_id")
	public WebElement txtMessageId;
	
	@FindBy(how = How.XPATH, using = "//span[@class='MuiButton-label'][contains(text(),'Add row')]")
	public WebElement txtaddRow;
	
	@FindBy(how = How.ID, using = "coordinates0_id")
	public WebElement txtpolycood1;
	
	@FindBy(how = How.ID, using = "coordinates1_id")
	public WebElement txtpolycood2;
	
	@FindBy(how = How.ID, using = "coordinates2_id")
	public WebElement txtpolycood3;
	
	@FindBy(how = How.ID, using = "coordinates3_id")
	public WebElement txtpolycood4;
	
	@FindBy(how = How.ID, using = "coordinates4_id")
	public WebElement txtpolycood5;
	
	@FindBy(how = How.ID, using = "coordinates5_id")
	public WebElement txtpolycood6;
	
	@FindBy(how = How.ID, using = "coordinates6_id")
	public WebElement txtpolycood7;
	
	@FindBy(how = How.ID, using = "coordinates7_id")
	public WebElement txtpolycood8;

	public TraceMessagesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	public void selectPage(String custName) {
		btnMsgHistory.click();
		BtnTraceMsg.click();
		txtSelectCustomer.sendKeys(custName);
		txtSelectCustomer.sendKeys(Keys.DOWN);
		txtSelectCustomer.sendKeys(Keys.RETURN);
	}
	
	public void selectCommand(String deviceName, String command) {
		btnSendMsg.click();
		txtDevName.sendKeys(deviceName);
		txtDevName.sendKeys(Keys.DOWN);
		txtDevName.sendKeys(Keys.RETURN);
		txtMsgType.sendKeys(command);
		txtMsgType.sendKeys(Keys.DOWN);
		txtMsgType.sendKeys(Keys.RETURN);
	}

	public void selectGetMessageCommand(String deviceName, String command) {
		btnSendMsg.click();
		txtDevName.sendKeys(deviceName);
		txtDevName.sendKeys(Keys.DOWN);
		txtDevName.sendKeys(Keys.RETURN);
		txtMsgType.sendKeys(command);
		txtMsgType.sendKeys(Keys.DOWN);
		txtMsgType.sendKeys(Keys.DOWN);
		txtMsgType.sendKeys(Keys.RETURN);
	}

	public void addRow() {
		btnAddRow.click();
	}

	public void sendCommand() {
		// Using Action class as because the element not getting clicked due to
		// JavaScript/AJAX calls present
		WebElement sendMsg = btnSendCommand;
		Actions actions = new Actions(driver);
		actions.moveToElement(sendMsg).click().build().perform();
		btnConfirm.click();
	}

	public void setSetPropertiesAttribute(long SN, long PN, long value) throws InterruptedException {
		txtSn.sendKeys(Long.toString(SN));
		txtPn.sendKeys(Long.toString(PN));
		drpFieldType.click();
		Thread.sleep(1000);
		drpSelectEnum.click();
		txtValue.sendKeys(Long.toString(value));
		Thread.sleep(1000);
	}

	public void setSendReportAttribute(long SN, long MN, long maxAge, long timeout) {
		txtReportSn.sendKeys(Long.toString(SN));
		txtReportMn.sendKeys(Long.toString(MN));
		txtMaxAge.sendKeys(Long.toString(maxAge));
		txtTimeout.sendKeys(Long.toString(timeout));
	}

	public void setGetPropertiesAttributes(long SN, long PN) {
		txtServiceNumber.sendKeys(Long.toString(SN));
		txtPropertyNumber.sendKeys(Long.toString(PN));
	}

	public void setGetMessageAttribute(long mID) {
		txtMessageId.sendKeys(Long.toString(mID));
	}

	public void setPositionAttributes(long maxAgeId, long timeOut) {
		drpfixType.click();
		drpSelectFixType.click();
		txtMaxId.sendKeys(Long.toString(maxAgeId));
		String timeOutConverted = Long.toString(timeOut);
		txtTimeOut.sendKeys(timeOutConverted);
	}
	
	public void setCreateCircleAttributes(long number, String geoName, double lat, double lon, long radius) throws InterruptedException {
		txtGeoNumber.sendKeys(Long.toString(number));
		Random rand = new Random();
		int upperbound = 99;
		int int_random = rand.nextInt(upperbound);
		txtGeoName.sendKeys(geoName+int_random);
		drpEnabled.click();
		drpSelectEnabled.click();
		drpNotifyCondition.click();
		drpSelectNotifyCondition.click();
		txtCircleLat.sendKeys(Double.toString(lat));
		txtCircleLon.sendKeys(Double.toString(lon));
		txtCircleRadius.sendKeys(Long.toString(radius));
	}
	
	
	public void setCreateRectangleAttributes(long number, String geoName, double leftlat, double leftlong, double rightlat,double rightlong) throws InterruptedException {
		txtGeoNumber.sendKeys(Long.toString(number));
		Random rand = new Random();
		int upperbound = 99;
		int int_random = rand.nextInt(upperbound);
		txtGeoName.sendKeys(geoName+int_random);
		drpEnabled.click();
		drpSelectEnabled.click();
		drpNotifyCondition.click();
		Thread.sleep(1000);
		drpSelectNotifyCondition.click();
		Thread.sleep(1000);
		txtTopLeftLat.sendKeys(Double.toString(leftlat));
		txtTopRightLong.sendKeys(Double.toString(leftlong));
		txtBottomLeftLat.sendKeys(Double.toString(rightlat));
		txtBottomRightLong.sendKeys(Double.toString(rightlong));

	}
	
	
	public void setCreatePolygonAttributes(long number, String geoName, double cood1, double cood2, double cood3,double cood4,double cood5,double cood6,double cood7,double cood8) throws InterruptedException {
		
		txtGeoNumber.sendKeys(Long.toString(number));
		Random rand = new Random();
		int upperbound = 99;
		int int_random = rand.nextInt(upperbound);
		txtGeoName.sendKeys(geoName+int_random);
		drpEnabled.click();
		drpSelectEnabled.click();
		drpNotifyCondition.click();
		Thread.sleep(1000);
		drpSelectNotifyCondition.click();
		Thread.sleep(1000);
		txtaddRow.click();
		txtpolycood1.sendKeys(Double.toString(cood1));
		txtaddRow.click();
		txtpolycood2.sendKeys(Double.toString(cood2));
		txtaddRow.click();
		txtpolycood3.sendKeys(Double.toString(cood3));
		txtaddRow.click();
		txtpolycood4.sendKeys(Double.toString(cood4));
		txtaddRow.click();
		txtpolycood5.sendKeys(Double.toString(cood5));
		txtaddRow.click();
		txtpolycood6.sendKeys(Double.toString(cood6));
		txtaddRow.click();
		txtpolycood7.sendKeys(Double.toString(cood7));
		txtaddRow.click();
		txtpolycood8.sendKeys(Double.toString(cood8));

	}

	public void setUpdatePasswordAttributes(long password) {
		txtupdatePass.sendKeys(Long.toString(password));
	}

	public void setReadPinAttributes() throws InterruptedException {
		drpPinNumber.click();
		drpSelectPinNumber.click();
		Thread.sleep(1000);
	}

	public void searchMessages(String DeviceName) throws InterruptedException {
		txtDeviceName.sendKeys(DeviceName);
		txtDeviceName.sendKeys(Keys.DOWN);
		txtDeviceName.sendKeys(Keys.RETURN);

		// Select Start Date.
		calendarStartDate.click();
		Thread.sleep(1000);
		calendarStartDateArrow.click();
		Thread.sleep(1000);
		calendarSelectStartDate.click();
		calendarSelectOK.click();

		Thread.sleep(1000);

		// Select End Date.
		calendarEndDate.click();
		Thread.sleep(1000);
		calendarEndDateArrow.click();
		Thread.sleep(1000);
		calendarSelectEndDate.click();
		calendarSelectOK.click();
		Thread.sleep(1000);

		btnSubmit.click();
		Thread.sleep(2000);
	}

	public void setgetGeoFenceStausByNumberAttributes(long number) {
		txtGeoNumber.sendKeys(Long.toString(number));		
	}
	
	public void setdisableGeofenceAttributes(long number) {
		txtGeoNumber.sendKeys(Long.toString(number));		
			}
	
	public void setenableGeofenceAttributes(long number) {
		txtGeoNumber.sendKeys(Long.toString(number));		
			}
	
	
	public void setdeleteGeoAttributes(long number) {
		txtGeoNumber.sendKeys(Long.toString(number));		
	}
	
	public void setgetGeoFenceInfoByNumberAttributes(long number) {
		txtGeoNumber.sendKeys(Long.toString(number));		
	}
	
	
	
	public void setupdateGeofenceNameAttributes(long number,String geoName) {
		txtGeoNumber.sendKeys(Long.toString(number));
		Random rand = new Random();
		int upperbound = 99;
		int int_random = rand.nextInt(upperbound);
		txtgeoNewName.sendKeys(geoName+int_random);		
	}
	
	public void setupdateNotifyConditionAttributes(long number) throws InterruptedException {
		txtGeoNumber.sendKeys(Long.toString(number));
		drpNotifyCondition.click();
		drpSelectNotifyConditionEnter.click();
		Thread.sleep(1000);
	}

	public String getMessageType() {
		String msg_Type = msgType.getText();
		return msg_Type;
	}
	
	public String getMessageID() {
		String msg_ID = msgID.getText();
		return msg_ID;
	}

	public String getCorrelationID() {
		String coID = correlationID.getText();
		return coID;
	}

	public String getMOID() {
		String MOID = moId.getText();
		return MOID;
	}
	
	public String verifyMTIsDelivered() throws InterruptedException {

		String msgID = getMessageID();
		System.out.println("MT ID is: " + msgID);

		for (int i = 1; i < 20; i++) {
			// Wait for MO to arrive.
			Thread.sleep(10000);
			// Search if the MO has arrived and if correlation ID is same as MT message ID..
			btnSubmit.click();
			String msgType = getMessageType();
			System.out.println("Latest Message Type is: " + msgType);

			if (msgType.equals("MO")) {
				System.out.println("MO has arrived because the message type is: " + msgType);
				String moID = getMOID();
				System.out.println("MO message ID is: " + moID);
				return ("MO message ID is: " + moID);
			}

			else {
				System.out.println("Retry number: " + i);
				if (i > 18) {
					String msg = "MO did not arrive for the MT sent.";
					System.out.println(msg);
					return msg;
				}
			}
		}
		return "Test Passed!";
	}
	
	public String verifyCommandDelivery() throws InterruptedException {
		
	String msgID = getMessageID();
	System.out.println("MT ID is: " + msgID);
	
	for (int i = 1; i < 20; i++) {
		// Wait for MO to arrive.
		Thread.sleep(10000);
		// Search if the MO has arrived and if correlation ID is same as MT message ID..
		btnSubmit.click();
		String msgType = getMessageType();
		System.out.println("Latest Message Type is: " + msgType);

		if (msgType.equals("MO")) {
			System.out.println("MO has arrived because the message type is: " + msgType);
			String coID = getCorrelationID();
			if (coID.equals(msgID)) {
				System.out.println("Correlation ID is: " + coID);
				String moID = getMOID();
				System.out.println("MO message ID is: " + moID);
				return ("MO message ID is: " + moID);
			} else {
				String receivedAnotherMO = "A different MO has arrived which is not related to this test!";
				System.out.println(receivedAnotherMO);
				return receivedAnotherMO;
			}

		} else {
			System.out.println("Retry number: " + i);
			if (i > 18) {
				String msg = "MO did not arrive for the MT sent.";
				System.out.println(msg);
				return msg;
			}
		}
	}
	return "Test Passed!";
	}
}
