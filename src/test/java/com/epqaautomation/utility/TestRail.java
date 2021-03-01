package com.epqaautomation.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

public class TestRail {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH); // Specify your locale
	
	public static void createTestRun(WebDriver driver) throws IOException, APIException {

		APIClient client = new APIClient("https://metocean.testrail.com");
		client.setUser("akumardas@metocean.com");
		client.setPassword("amitkd123");
		Map data = new HashMap();
		String projectID = "34";
		String user_id = "8";

		String suiteID = "984";
		String testRunName = "OTA Messages Automated Tests";
		String description = "Edge Pro Soak and KPI Testing.";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		data.put("suite_id", suiteID);
		data.put("name", testRunName + " - " + dtf.format(now));
		data.put("description", description);
		data.put("include_all", true);
		data.put("assignedto_id", user_id);
		JSONObject r = (JSONObject) client.sendPost("add_run/" + projectID, data);
	}

	public static void setTestSuccessResult(WebDriver driver, List<String> testCaseID)
			throws IOException, APIException, ParseException {
		APIClient client = new APIClient("https://metocean.testrail.com");
		client.setUser("akumardas@metocean.com");
		client.setPassword("amitkd123");

		Map data = new HashMap();
		data.put("status_id", 1);
		data.put("comment", "This test worked fine!");
		// System.out.println("Test Case ID is: " + testCaseID);
		String runID = getRunID();
		for (int testCase = 0; testCase < testCaseID.size(); testCase++) {
			JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + runID + "/" + testCaseID.get(testCase),
					data);
		}
	}

	public static void setTestFailureResult(WebDriver driver, List<String> testCaseID)
			throws IOException, APIException, ParseException {

		APIClient client = new APIClient("https://metocean.testrail.com");
		client.setUser("akumardas@metocean.com");
		client.setPassword("amitkd123");

		Map data = new HashMap();
		data.put("status_id", 5);
		data.put("comment", "This test failed!");
		// System.out.println("Test Case ID is: " + testCaseID);
		String runID = getRunID();
		System.out.println("Test Run ID is: " + runID);
		for (int testCase = 0; testCase < testCaseID.size(); testCase++) {
			JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + runID + "/" + testCaseID.get(testCase),
					data);
		}
	}
	
	public static void setTestRetestResult(WebDriver driver, List<String> testCaseID)
			throws IOException, APIException, ParseException {

		APIClient client = new APIClient("https://metocean.testrail.com");
		client.setUser("akumardas@metocean.com");
		client.setPassword("amitkd123");

		Map data = new HashMap();
		data.put("status_id", 4);
		data.put("comment", "This test is skipped!");
		// System.out.println("Test Case ID is: " + testCaseID);
		String runID = getRunID();
		// System.out.println("Test Run ID is: " + runID);
		for (int testCase = 0; testCase < testCaseID.size(); testCase++) {
			JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + runID + "/" + testCaseID.get(testCase),
					data);
		}
	}


	public static String getRunID() throws MalformedURLException, IOException, APIException, ParseException {

		// Get the TestRun created.
		APIClient client = new APIClient("https://metocean.testrail.com");
		client.setUser("akumardas@metocean.com");
		client.setPassword("amitkd123");
		Map data = new HashMap();
		String projectID = "34";

		// Generate UNIX Timestamp from current date time (few minutes earlier).
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now().minusMinutes(5);
		String g = now.format(dtf).toString();
		System.out.println(g);
		long unixTime = 0;
		dateFormat.setTimeZone(TimeZone.getTimeZone("AST"));
		unixTime = dateFormat.parse(g).getTime() / 1000L;
		System.out.println("Unix Time: " + unixTime);

		JSONArray runs = (JSONArray) client.sendGet("get_runs/" + projectID + "&created_after=" + unixTime);
		JSONObject currentRun = (JSONObject) runs.get(0);
		String runId = currentRun.get("id").toString();
		System.out.println("Current Test Run ID: " + currentRun.get("id"));
		return runId;
	}
}