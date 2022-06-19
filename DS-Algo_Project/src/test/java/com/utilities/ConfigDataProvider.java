package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties properties;
	public ConfigDataProvider() {
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream file = new FileInputStream(src);
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	public String getApplicationURL()
	{
		String url=properties.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=properties.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=properties.getProperty("password");
	return password;
	}
	



}
