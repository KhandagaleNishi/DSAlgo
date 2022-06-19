package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

public class BaseClass {

	ConfigDataProvider readconfig = new ConfigDataProvider();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

//	@BeforeMethod
//	@Parameters("browser")
//	@Description("Browser Configuration, Setup and Load URL")
//	public void setup(){
//		logger = Logger.getLogger("DS-ALGO Project");
//		PropertyConfigurator.configure("log4j.properties");
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get(baseURL);
//
//		driver.manage().window().maximize();
//
//
//	}
	@BeforeSuite
	public WebDriver initialize_driver() {

		logger = Logger.getLogger("DS-ALGO Project");
		PropertyConfigurator.configure("log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@Description("Close Browser")
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen1(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String captureScreen(WebDriver driver, String tname) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

}
