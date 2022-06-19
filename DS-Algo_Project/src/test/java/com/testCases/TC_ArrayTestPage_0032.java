package com.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObject.ArrayPage;
import com.pageObject.SigninPage;
import com.utilities.BaseClass;
import com.utilities.ExcelDataProvider;
import com.utilities.AllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class TC_ArrayTestPage_0032 extends BaseClass{
	SigninPage signin;
	ArrayPage array ;
	public Actions action;
	
	
	//@Issues({@Issue("AUTO-50"),@Issue("AUTO-60")})
	@Test(dataProvider="ArrayCodeData", priority = 1)
	@Description("User Login") 
	@Epic("0032")
	@Feature("Array")
	@Step("Getting Array Page report Steps")
	@Story("Story:Array Page Navigation")
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
		
		array = new ArrayPage(driver) ;
		action = new Actions(driver);
		array.clickDropdown();
		array.clickArrayPage();
		logger.info("Array page click");
		//Arrays in Python
		array.clickArraysPython();
		array.clickTryhere();
	
		action.sendKeys(codedata).perform();
		
		array.clickRunButtn();
		logger.info("First Run Arrays in Python completed");
		JavascriptExecutor jsback = (JavascriptExecutor) driver; 
		jsback.executeScript("window.history.go(-1)");
		
		//Arrays Using List
		array.clickArraysList();
		array.clickTryhere();
		
		action.sendKeys(codedata).perform();
		
	
		array.clickRunButtn();
		logger.info("Second Run Output Arrays Using List completed");
		jsback.executeScript("window.history.go(-1)");
		
		//Basic Operations in Lists
		array.clickBasicOpLists();
		array.clickTryhere();
		action.sendKeys(codedata).perform();
		array.clickRunButtn();
		logger.info("Third Run Output Basic Operations in Lists completed");
		jsback.executeScript("window.history.go(-1)");
		
		//Applications of Array
		array.clickBasicOpLists();
		array.clickTryhere();
		action.sendKeys(codedata).perform();
		array.clickRunButtn();
	//	driver.switchTo().alert().dismiss(); 
		logger.info("Fourth Run Output Applications of Array completed");
		Thread.sleep(500);
		driver.navigate().back();
		array.clicklogout();
		captureScreen(driver,"arrayPageNavigation");
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
	@DataProvider(name="ArrayCodeData")
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
