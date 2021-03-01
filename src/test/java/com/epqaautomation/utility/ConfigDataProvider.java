package com.epqaautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/Config.properties");
		
		try {
		
			FileInputStream fis = new FileInputStream(src);
		
			pro = new Properties();  

			pro.load(fis);
		}
		catch (IOException e) {
			System.out.println("Not able to load config file >>" + e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getURL() {
		return pro.getProperty("QA_URL");
	}
	
	public String getTraceMsgURL() {
		return pro.getProperty("TraceMessage_URL");
	}

	public String getViewMsgURL() {
		return pro.getProperty("ViewMessage_URL");
	}
}
