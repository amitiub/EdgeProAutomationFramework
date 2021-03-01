package com.epqaautomation.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Helper {
	
    public static void CaptureScreenShot(WebDriver driver, String testName) throws IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
    	LocalDateTime now = LocalDateTime.now();  
    	//System.out.println(dtf.format(now)); 
    	
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	Reporter.log(testName + ": Test Failed!");
        	FileUtils.copyFile(scrFile, new File("./Screenshots/Fail" + "-" + testName + "_" + dtf.format(now) + ".png"));
        } catch (IOException e) {
        	Reporter.log("Unable to capture screenshot." + e.getMessage());
        }
    }

	public void alerts() {
		
	}
	
	public void frames() {
		
	}


}
