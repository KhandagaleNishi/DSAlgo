package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter; // Looks of report
	public ExtentReports extent; // Specify the location (Environment) of the report
	public ExtentTest logger; // what details to be populated on report
	public static WebDriver driver;
	public static String screenshotPath;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specify
																											// location
																											// of the
																											// report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "USER Mackbook");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("OS", "Mac OS X");
		extent.setSystemInfo("Build", "");

		htmlReporter.config().setDocumentTitle("DS-ALGO Test Project"); // Tile of report
		htmlReporter.config().setReportName("Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
		
		
		screenshotPath= System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File f = new File(screenshotPath);

		if (f != null) {
			try {
				// System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
				// screenshotPath = Listeners.captureScreen(driver, tr.getName());
				logger.pass("Pass : " + logger.addScreenCaptureFromPath(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult tr) {
		// create new entry in the report
		// send the passed information
		// to the report with GREEN
		// color highlighted

		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable());
		screenshotPath= System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File f = new File(screenshotPath);

		if (f != null) {
			try {
				// System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
				// screenshotPath = Listeners.captureScreen(driver, tr.getName());
				logger.fail("Failed : " + logger.addScreenCaptureFromPath(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
