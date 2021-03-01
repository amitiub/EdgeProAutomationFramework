package com.epqaautomation.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epqaautomation.pages.BaseClass;
import com.epqaautomation.pages.TraceMessagesPage;
import com.epqaautomation.pages.ViewMessagesPage;
public class TraceMessagesTest extends BaseClass {

	// -----------setProperties----------

	@Test(priority = 1, testName = "setProperties")
	public void setProperties(ITestContext context) throws InterruptedException {

		String testCaseId1 = "40444";
		String testCaseId2 = "40445";
		String testCaseId3 = "40446";
		String testCaseId4 = "40447";
		String testCaseId5 = "40922";
		
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		list.add(testCaseId5);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 1, 1));
		TraceMsg.addRow();
		TraceMsg.setSetPropertiesAttribute(excel.getNumericData("Commands", 1, 2),
				excel.getNumericData("Commands", 1, 3), excel.getNumericData("Commands", 1, 4));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 2, testName = "verifysetPropertiesMsgIsDelivered",dependsOnMethods = { "setProperties" })
	public void verifysetPropertiesMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40448";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 3, testName = "verifysetPropertiesMO",dependsOnMethods = { "verifysetPropertiesMsgIsDelivered" })
	public void verifysetPropertiesMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40885";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		driver.navigate().to(config.getURL());
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 1, 1));
		System.out.println(attribute);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "resultCode:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//-----------getMessages----------

	@Test(priority = 4, testName = "getMessages")
	public void getMessages(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40449";
		String testCaseId2 = "40450";
		String testCaseId3 = "40923";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 2, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 5, testName = "verifygetMessagesMsgIsDelivered",dependsOnMethods = { "getMessages" })
	public void verifygetMessagesMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40451";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 6, testName = "verifygetMessagesMO",dependsOnMethods = { "verifygetMessagesMsgIsDelivered" })
	public void verifygetMessagesMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40452";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		driver.navigate().to(config.getURL());
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 2, 1));
		System.out.println(attribute);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "status:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------sendReport----------

	@Test(priority = 7, testName = "sendReport")
	public void sendReport(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40453";
		String testCaseId2 = "40454";
		String testCaseId3 = "40455";
		String testCaseId4 = "40924";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 3, 1));
		TraceMsg.setSendReportAttribute(excel.getNumericData("Commands", 3, 2), excel.getNumericData("Commands", 3, 3),
				excel.getNumericData("Commands", 3, 4), excel.getNumericData("Commands", 3, 5));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 8, testName = "verifysendReportMsgIsDelivered",dependsOnMethods = { "sendReport" })
	public void verifysendReportMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40456";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyMTIsDelivered();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 9, testName = "verifysendReportMO",dependsOnMethods = { "verifysendReportMsgIsDelivered" })
	public void verifysendReportMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40457";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 3, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "pin1Config:\"DIGITAL_INPUT\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------getPosition----------

	@Test(priority = 10, testName = "getPosition")
	public void getPosition(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40458";
		String testCaseId2 = "40459";
		String testCaseId3 = "40460";
		String testCaseId4 = "40925";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 4, 1));
		TraceMsg.setPositionAttributes(excel.getNumericData("Commands", 4, 2), excel.getNumericData("Commands", 4, 3));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 11, testName = "verifygetPositionMsgIsDelivered",dependsOnMethods = { "getPosition" })
	public void verifygetPositionMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40461";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 12, testName = "verifygetPositionMO",dependsOnMethods = { "verifygetPositionMsgIsDelivered" })
	public void verifygetPositionMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40462";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 4, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "fixGnssMode:\"GPS_GLONASS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}
	
	//----------readTemperature----------

	@Test(priority = 13, testName = "readTemperature")
	public void readTemperature(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40476";
		String testCaseId2 = "40477";
		String testCaseId3 = "40926";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 7, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 14, testName = "verifyreadTemperatureMsgIsDelivered",dependsOnMethods = { "readTemperature" })
	public void verifyreadTemperatureMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40478";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 15, testName = "verifyreadTemperatureMO",dependsOnMethods = { "verifyreadTemperatureMsgIsDelivered" })
	public void verifyreadTemperatureMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40479";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 7, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "temperature:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------updatePassword----------

	@Test(priority = 16, testName = "updatePassword")
	public void updatePassword(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40735";
		String testCaseId2 = "40736";
		String testCaseId3 = "40737";
		String testCaseId4 = "40738";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 8, 1));
		TraceMsg.setUpdatePasswordAttributes(excel.getNumericData("Commands", 8, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 17, testName = "verifyupdatePasswordMsgIsDelivered",dependsOnMethods = { "updatePassword" })
	public void verifyupdatePasswordMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40739";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 18, testName = "verifyupdatePasswordMO",dependsOnMethods = { "verifyupdatePasswordMsgIsDelivered" })
	public void verifyupdatePasswordMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40740";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 8, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "response:\"Success\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------readAcceleration----------

	@Test(priority = 19, testName = "readAcceleration")
	public void readAcceleration(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40488";
		String testCaseId2 = "40489";
		String testCaseId3 = "40927";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 9, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 20, testName = "verifyreadAccelerationMsgIsDelivered",dependsOnMethods = { "readAcceleration" })
	public void verifyreadAccelerationMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40490";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 21, testName = "verifyreadAccelerationMO",dependsOnMethods = { "verifyreadAccelerationMsgIsDelivered" })
	public void verifyreadAccelerationMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40491";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 9, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "accelerationX:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------readPin----------

	@Test(priority = 22, testName = "readPin")
	public void readPin(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40496";
		String testCaseId2 = "40497";
		String testCaseId3 = "40498";
		String testCaseId4 = "40929";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 11, 1));
		TraceMsg.setReadPinAttributes();
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 23, testName = "verifyreadPinMsgIsDelivered",dependsOnMethods = { "readPin" })
	public void verifyreadPinMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40499";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 24, testName = "verifyreadPinMO",dependsOnMethods = { "verifyreadPinMsgIsDelivered" })
	public void verifyreadPinMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40500";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 11, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "pinNumber:\"GPIO_2\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getProperties----------

	@Test(priority = 25, testName = "getProperties")
	public void getProperties(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40516";
		String testCaseId2 = "40517";
		String testCaseId3 = "40518";
		String testCaseId4 = "40933";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);

		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 15, 1));
		TraceMsg.addRow();
		TraceMsg.setGetPropertiesAttributes(excel.getNumericData("Commands", 15, 2),
				excel.getNumericData("Commands", 15, 3));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 26, testName = "verifygetPropertiesMsgIsDelivered",dependsOnMethods = { "getProperties" })
	public void verifygetPropertiesMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40519";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 27, testName = "verifygetPropertiesMO",dependsOnMethods = { "verifygetPropertiesMsgIsDelivered" })
	public void verifygetPropertiesMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40520";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 15, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "value:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getMessage----------

	@Test(priority = 28, testName = "getMessage")
	public void getMessage(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40521";
		String testCaseId2 = "40522";
		String testCaseId3 = "40523";
		String testCaseId4 = "40934";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectGetMessageCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 16, 1));
		TraceMsg.setGetMessageAttribute(excel.getNumericData("Commands", 16, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 29, testName = "verifygetMessageMsgIsDelivered",dependsOnMethods = { "getMessage" })
	public void verifygetMessageMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40524";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 30, testName = "verifygetMessageMO",dependsOnMethods = { "verifygetMessageMsgIsDelivered" })
	public void verifygetMessageMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40525";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 16, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "resultCode:\"MESSAGE_NOT_FOUND\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------getDeviceInfo----------

	@Test(priority = 31, testName = "getDeviceInfo")
	public void getDeviceInfo(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40546";
		String testCaseId2 = "40547";
		String testCaseId3 = "40548";
		String testCaseId4 = "40938";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 22, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 32, testName = "verifygetDeviceInfoMsgIsDelivered",dependsOnMethods = { "getDeviceInfo" })
	public void verifygetDeviceInfoMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40549";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 33, testName = "verifygetDeviceInfoMO",dependsOnMethods = { "verifygetDeviceInfoMsgIsDelivered" })
	public void verifygetDeviceInfoMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40550";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 22, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "deviceId:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getLastKnownPosition----------

	@Test(priority = 34, testName = "getLastKnownPosition")
	public void getLastKnownPosition(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40551";
		String testCaseId2 = "40552";
		String testCaseId3 = "40553";
		String testCaseId4 = "40939";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 23, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 35, testName = "verifygetLastKnownPositionMsgIsDelivered",dependsOnMethods = { "getLastKnownPosition" })
	public void verifygetLastKnownPositionMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40554";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 36, testName = "verifygetLastKnownPositionMO",dependsOnMethods = { "verifygetLastKnownPositionMsgIsDelivered" })
	public void verifygetLastKnownPositionMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40555";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 23, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "fixGnssMode:\"GPS_GLONASS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getDeviceStatus----------

	@Test(priority = 37, testName = "getDeviceStatus")
	public void getDeviceStatus(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40562";
		String testCaseId2 = "40563";
		String testCaseId3 = "40564";
		String testCaseId4 = "40940";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 27, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 38, testName = "verifydeviceStatusMsgIsDelivered",dependsOnMethods = { "getDeviceStatus" })
	public void verifydeviceStatusMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40565";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 39, testName = "verifygetDeviceStatusMO",dependsOnMethods = { "verifydeviceStatusMsgIsDelivered" })
	public void verifygetDeviceStatusMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40566";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 27, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "inputVoltage:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------resetOdometer----------

	@Test(priority = 40, testName = "resetOdometer")
	public void resetOdometer(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40573";
		String testCaseId2 = "40574";
		String testCaseId3 = "40575";
		String testCaseId4 = "40942";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 29, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 41, testName = "verifyresetOdometerMsgIsDelivered",dependsOnMethods = { "resetOdometer" })
	public void verifyresetOdometerMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40576";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 42, testName = "verifyresetOdometerMO",dependsOnMethods = { "verifyresetOdometerMsgIsDelivered" })
	public void verifyresetOdometerMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40577";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 29, 1));
		System.out.println("Printing attribute value from Test:" + attribute);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "success:true");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------createCircle----------

	@Test(priority = 43, testName = "createCircle")
	public void createCircle(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40471";
		String testCaseId2 = "40472";
		String testCaseId3 = "40473";
		String testCaseId4 = "40919";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 6, 1));
		TraceMsg.setCreateCircleAttributes(excel.getNumericData("Commands", 6, 2), excel.getStringData("Commands", 6, 3), 
				excel.getDecimalData("Commands", 6, 4), excel.getDecimalData("Commands", 6, 5), excel.getNumericData("Commands", 6, 6));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 44, testName = "verifycreateCircleMsgIsDelivered",dependsOnMethods = { "createCircle" })
	public void verifycreateCircleMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40474";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 45, testName = "verifycreateCircleMO",dependsOnMethods = { "verifycreateCircleMsgIsDelivered" })
	public void verifycreateCircleMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40475";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 6, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "result:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------createRectangle----------

	@Test(priority = 46, testName = "createRectangle")
	public void createRectangle(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40531";
		String testCaseId2 = "40532";
		String testCaseId3 = "40533";
		String testCaseId4 = "40920";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 19, 1));
		TraceMsg.setCreateRectangleAttributes(excel.getNumericData("Commands", 19, 2), excel.getStringData("Commands", 19, 3), 
				excel.getDecimalData("Commands", 19, 4), excel.getDecimalData("Commands", 19, 5), excel.getDecimalData("Commands", 19, 6),excel.getDecimalData("Commands", 19, 7));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 47, testName = "verifycreateRectangleMsgIsDelivered",dependsOnMethods = { "createRectangle" })
	public void verifycreateRectangleMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40534";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 48, testName = "verifycreateRectangleMO",dependsOnMethods = { "verifycreateRectangleMsgIsDelivered" })
	public void verifycreateRectangleMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40535";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 19, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "result:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------createPolygon----------

	@Test(priority = 49, testName = "createPolygon")
	public void createPolygon(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40556";
		String testCaseId2 = "40557";
		String testCaseId3 = "40558";
		String testCaseId4 = "40559";
		String testCaseId5 = "40921";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		list.add(testCaseId5);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 25, 1));
		TraceMsg.setCreatePolygonAttributes(excel.getNumericData("Commands", 25, 2), excel.getStringData("Commands", 25, 3), 
				excel.getDecimalData("Commands", 25, 4), excel.getDecimalData("Commands", 25, 5), excel.getDecimalData("Commands", 25, 6),excel.getDecimalData("Commands", 25, 7),excel.getDecimalData("Commands", 25, 8),excel.getDecimalData("Commands", 25, 9),excel.getDecimalData("Commands", 25, 10),excel.getDecimalData("Commands", 25, 11));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 50, testName = "verifycreatePolygonMsgIsDelivered",dependsOnMethods = { "createPolygon" })
	public void verifycreatePolygonMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40560";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 51, testName = "verifycreatePolygonMO",dependsOnMethods = { "verifycreatePolygonMsgIsDelivered" })
	public void verifycreatePolygonMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40561";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 25, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "result:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getGeofenceStatusByNumber----------

	@Test(priority = 52, testName = "getGeofenceStatusByNumber")
	public void getGeofenceStatusByNumber(ITestContext context) throws InterruptedException {

		String testCaseId1 = "40626";
		String testCaseId2 = "40627";
		String testCaseId3 = "40628";
		String testCaseId4 = "40946";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 44, 1));
		TraceMsg.setgetGeoFenceStausByNumberAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 53, testName = "verifygetGeofenceStatusByNumberMsgIsDelivered",dependsOnMethods = { "getGeofenceStatusByNumber" })
	public void verifygetGeofenceStatusByNumberMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40629";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 54, testName = "verifygetGeofenceStatusByNumberMO",dependsOnMethods = { "verifygetGeofenceStatusByNumberMsgIsDelivered" })
	public void verifygetGeofenceStatusByNumberMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40630";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 44, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "number:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------disableGeofence----------

	@Test(priority = 55, testName = "disableGeofence")
	public void disableGeofence(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40741";
		String testCaseId2 = "40742";
		String testCaseId3 = "40743";
		String testCaseId4 = "40970";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 40, 1));
		TraceMsg.setdisableGeofenceAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 56, testName = "verifydisableGeofenceMsgIsDelivered",dependsOnMethods = { "disableGeofence" })
	public void verifydisableGeofenceMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40745";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 57, testName = "verifydisableGeofenceMO",dependsOnMethods = { "verifydisableGeofenceMsgIsDelivered" })
	public void verifydisableGeofenceMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40746";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 40, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "state:false");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------enableGeofence----------

	@Test(priority = 58, testName = "enableGeofence")
	public void enableGeofence(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40604";
		String testCaseId2 = "40605";
		String testCaseId3 = "40606";
		String testCaseId4 = "40949";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 36, 1));
		TraceMsg.setenableGeofenceAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 59, testName = "verifyenableGeofenceMsgIsDelivered",dependsOnMethods = { "enableGeofence" })
	public void verifyenableGeofenceMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40607";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 60, testName = "verifyenableGeofenceMO",dependsOnMethods = { "verifyenableGeofenceMsgIsDelivered" })
	public void verifyenableGeofenceMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40608";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 36, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "state:true");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getGeofenceInfoByNumber----------

	@Test(priority = 61, testName = "getGeofenceInfoByNumber")
	public void getGeofenceInfoByNumber(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40886";
		String testCaseId2 = "40887";
		String testCaseId3 = "40888";
		String testCaseId4 = "40975";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 53, 1));
		TraceMsg.setgetGeoFenceInfoByNumberAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 62, testName = "verifygetGeofenceInfoByNumberMsgIsDelivered",dependsOnMethods = { "getGeofenceInfoByNumber" })
	public void verifygetGeofenceInfoByNumberMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40889";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 63, testName = "verifygetGeofenceInfoByNumberMO",dependsOnMethods = { "verifygetGeofenceInfoByNumberMsgIsDelivered" })
	public void verifygetGeofenceInfoByNumberMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40890";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 53, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "number:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------updateGeofenceName----------

	@Test(priority = 64, testName = "updateGeofenceName")
	public void updateGeofenceName(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40667";
		String testCaseId2 = "40668";
		String testCaseId3 = "40669";
		String testCaseId4 = "40670";
		String testCaseId5 = "40959";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		list.add(testCaseId5);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 60, 1));
		TraceMsg.setupdateGeofenceNameAttributes(excel.getNumericData("Commands", 6, 2),
				excel.getStringData("Commands", 60, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 65, testName = "verifyupdateGeofenceNameMsgIsDelivered",dependsOnMethods = { "updateGeofenceName" })
	public void verifyupdateGeofenceNameMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40671";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 66, testName = "verifyupdateGeofenceNameMO",dependsOnMethods = { "verifyupdateGeofenceNameMsgIsDelivered" })
	public void verifyupdateGeofenceNameMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40672";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 60, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "result:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------getGeofenceStatusList----------

	@Test(priority = 67, testName = "getGeofenceStatusList")
	public void getGeofenceStatusList(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40728";
		String testCaseId2 = "40729";
		String testCaseId3 = "40730";
		String testCaseId4 = "40731";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 50, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 68, testName = "verifygetGeofenceStatusListMsgIsDelivered",dependsOnMethods = { "getGeofenceStatusList" })
	public void verifygetGeofenceStatusListMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40733";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 69, testName = "verifygetGeofenceStatusListMO",dependsOnMethods = { "verifygetGeofenceStatusListMsgIsDelivered" })
	public void verifygetGeofenceStatusListMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40734";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 50, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "geofenceStatusList:");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------updateNotifyCondition----------

	@Test(priority = 70, testName = "updateNotifyCondition")
	public void updateNotifyCondition(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40652";
		String testCaseId2 = "40653";
		String testCaseId3 = "40655";
		String testCaseId4 = "40658";
		String testCaseId5 = "40957";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		list.add(testCaseId5);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 58, 1));
		TraceMsg.setupdateNotifyConditionAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 71, testName = "verifyupdateNotifyConditionMsgIsDelivered",dependsOnMethods = { "updateNotifyCondition" })
	public void verifyupdateNotifyConditionMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40659";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 72, testName = "verifyupdateNotifyConditionMO",dependsOnMethods = { "verifyupdateNotifyConditionMsgIsDelivered" })
	public void verifyupdateNotifyConditionMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40660";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 58, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "notifyCondition:\"ENTER\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------deleteGeoFence----------

	@Test(priority = 73, testName = "deleteGeoFence")
	public void deleteGeoFence(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40578";
		String testCaseId2 = "40579";
		String testCaseId3 = "40580";
		String testCaseId4 = "40943";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 31, 1));
		TraceMsg.setdeleteGeoAttributes(excel.getNumericData("Commands", 6, 2));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 74, testName = "verifydeleteGeoFenceMsgIsDelivered",dependsOnMethods = { "deleteGeoFence" })
	public void verifydeleteGeoFenceMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40581";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 75, testName = "verifydeleteGeoFenceMO",dependsOnMethods = { "verifydeleteGeoFenceMsgIsDelivered" })
	public void verifydeleteGeoFenceMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40582";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 31, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "result:\"SUCCESS\"");
		softAssert.assertAll();
		Reporter.log("The following attribute is verified: " + attribute);
	}

	// ----------getDeviceHealth----------

	@Test(priority = 76, testName = "getDeviceHealth")
	public void getDeviceHealth(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40631";
		String testCaseId2 = "40632";
		String testCaseId3 = "40633";
		String testCaseId4 = "40953";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 45, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 77, testName = "verifygetDeviceHealthMsgIsDelivered",dependsOnMethods = { "getDeviceHealth" })
	public void verifygetDeviceHealthMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40634";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 78, testName = "verifygetDeviceHealthMO",dependsOnMethods = { "verifygetDeviceHealthMsgIsDelivered" })
	public void verifygetDeviceHealthMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40635";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 45, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "threadCount:");
		softAssert.assertAll();
		System.out.println("The following attribute is verified: " + attribute);

		Reporter.log("The following attribute is verified: " + attribute);
	}

	//----------syncTime----------

	@Test(priority = 79, testName = "syncTime")
	public void syncTime(ITestContext context) throws InterruptedException {
		String testCaseId1 = "40722";
		String testCaseId2 = "40723";
		String testCaseId3 = "40724";
		String testCaseId4 = "40969";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId1);
		list.add(testCaseId2);
		list.add(testCaseId3);
		list.add(testCaseId4);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case.............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		driver.navigate().to(config.getTraceMsgURL());
		TraceMsg.selectCommand(excel.getStringData("Devices", 0, 0), excel.getStringData("Commands", 71, 1));
		TraceMsg.sendCommand();
		TraceMsg.wait.until(ExpectedConditions.visibilityOf(TraceMsg.msgSuccess));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TraceMsg.msgSuccess.getText(), "Message was sent successfully");
		softAssert.assertAll();
		Reporter.log("Message was sent successfully");
	}

	@Test(priority = 80, testName = "verifysyncTimeMsgIsDelivered",dependsOnMethods = { "syncTime" })
	public void verifysyncTimeMsgIsDelivered(ITestContext context) throws InterruptedException {
		String testCaseId = "40725";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		TraceMessagesPage TraceMsg = PageFactory.initElements(driver, TraceMessagesPage.class);
		TraceMsg.searchMessages(excel.getStringData("Devices", 0, 0));
		String msg = TraceMsg.verifyCommandDelivery();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "MO message ID is: " + msg.substring(18));
		softAssert.assertAll();
		Reporter.log("MO ID for the corresponding MT is: " + msg);
	}

	@Test(priority = 81, testName = "verifysyncTimeMO",dependsOnMethods = { "verifysyncTimeMsgIsDelivered" })
	public void verifysyncTimeMO(ITestContext context) throws InterruptedException {
		String testCaseId = "40726";
		List<String> list = new ArrayList<String>();
		list.add(testCaseId);
		context.setAttribute("testCaseId", list);
		System.out.println("Running Test Case............: " + list);
		ViewMessagesPage viewMessage = PageFactory.initElements(driver, ViewMessagesPage.class);
		viewMessage.goToViewMsgPage();
		viewMessage.viewMessage(excel.getStringData("Devices", 0, 0));
		String attribute = viewMessage.verifyMO(excel.getStringData("Commands", 71, 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(attribute, "resultCode:\"SUCCESS\"");
		Reporter.log("The following attribute is verified: " + attribute);
	}
}