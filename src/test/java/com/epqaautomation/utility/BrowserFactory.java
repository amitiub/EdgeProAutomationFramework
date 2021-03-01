package com.epqaautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver localDriver, String browserName, String appURL) {
		
		if (browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			localDriver = new ChromeDriver();
		}
		
		else if (browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			localDriver = new FirefoxDriver();
		}
		
		else if (browserName.equals("Edge")) {
		
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			localDriver = new EdgeDriver();
		}
		
		else {
			
			System.out.println("We do not support this browser");
		}
		
		localDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		localDriver.manage().window().maximize();
		localDriver.get(appURL);
		localDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return localDriver;
	}
	
	public static void quitBrowser(WebDriver localDriver) {
		
		localDriver.close();
		localDriver.quit();
		
	}
	
}
