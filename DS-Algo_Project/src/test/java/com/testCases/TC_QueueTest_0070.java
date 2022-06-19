package com.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.ArrayPage;
import com.pageObject.QueuePage;
import com.pageObject.SigninPage;
import com.utilities.BaseClass;
import com.utilities.ExcelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC_QueueTest_0070 extends BaseClass {
	SigninPage signin;
	QueuePage queue ;
	public Actions action;
	
	
	@Test(dataProvider="QueueCodeData", priority = 1)
	@Description("User Login") 
	@Epic("0070")
	@Feature("Array")
	@Step("Getting Queue Page report Steps")
	@Story("Story:Queue Page Navigation")
	@Severity (SeverityLevel.NORMAL)
	public void arrayPageNavigation(String codedata) throws InterruptedException, IOException {
		
		
		signin=new SigninPage(driver);
		signin.clickSingin();
		logger.info("Signin Page Displayed");
		signin.setUserName(username);
		logger.info("Username Entered");
		signin.setPassword(password);
		logger.info("Password Entered");
		signin.clickSubmit();
		
		Thread.sleep(500);
		
		queue = new QueuePage(driver) ;
		action = new Actions(driver);
		queue.clickDropdown();
		queue.clickQueuePage();
		logger.info("Queue page clicked");
		
		queue.clickImplementationLists();
		queue.clickTryhere();
	
		action.sendKeys(codedata).perform();
		
		queue.clickRunButtn();
		logger.info("First Run Arrays in Python completed");
		JavascriptExecutor jsback = (JavascriptExecutor) driver; 
		jsback.executeScript("window.history.go(-1)");
		
		
		queue.clickImpCollectiondeque();
		queue.clickTryhere();
		
		action.sendKeys(codedata).perform();
		
	
		queue.clickRunButtn();
		logger.info("Second Run Output Arrays Using List completed");
		jsback.executeScript("window.history.go(-1)");
		
		//Basic Operations in Lists
		queue.clickImplementationArray();
		queue.clickTryhere();
		action.sendKeys(codedata).perform();
		queue.clickRunButtn();
		logger.info("Third Run Output Basic Operations in Lists completed");
		jsback.executeScript("window.history.go(-1)");
		
		
		queue.clickQueueOperations();
		queue.clickTryhere();
		action.sendKeys(codedata).perform();
		queue.clickRunButtn();
	//	driver.switchTo().alert().dismiss(); 
		logger.info("Fourth Run Output Applications of Array completed");
		Thread.sleep(500);
		driver.navigate().back();
		queue.clicklogout();
		captureScreen(driver,"queuePageNavigation");
		Thread.sleep(500);
		
	}
	@Test(priority = 2)
	@Description("Failed Test case") 
	@Epic("0033")
	@Feature("Login Page")
	@Step("Failed testcase for screenshot")
	@Severity (SeverityLevel.NORMAL)
	public void pageFailedTestCase() throws IOException {
		
		signin=new SigninPage(driver);
		signin.clickSingin();
		logger.info("Signin Page Displayed");
		signin.setUserName(username);
		logger.info("Username Entered");
		captureScreen(driver,"pageFailedTestCase");
		//AssertJUnit.assertTrue(false);
		Assert.assertEquals(false,false,"Page Failed TestCase");

	}
	
	public boolean isAlertPresent() throws IOException //user defined method created to check alert is presetn or not
	{
		try
		{
		captureScreen(driver,"isAlertPresent");
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="QueueCodeData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/Data.xlsx";
		
		int rownum=ExcelDataProvider.getRowCount(path, "Sheet2");
		int colcount=ExcelDataProvider.getCellCount(path,"Sheet2",1);
		
		String codedata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)  //for(int j=1;j<=colcount;j++)
			{
				codedata[i-1][j]=ExcelDataProvider.getCellData(path,"Sheet2", i,j);//1 0
			}
				
		}
	return codedata;
	}
}
