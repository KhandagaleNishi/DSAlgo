package com.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObject.SigninPage;
import com.utilities.AllureListener;
import com.utilities.BaseClass;
import com.utilities.ExcelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

@Listeners({AllureListener.class})
public class TC_LoginTestDDT_0020 extends BaseClass{
	SigninPage signin;
	@Issues({@Issue("AUTO-50"),@Issue("AUTO-60")})
	@Test(dataProvider="Data")
	@Description("User Login")  
	@Severity (SeverityLevel.BLOCKER)
	//@Step("Login with username : {0} and password : {1} step.. ")
	public void loginDDT(String username,String password) throws InterruptedException, IOException 
	{
		
		signin=new SigninPage(driver);
		signin.clickSingin();
		logger.info("Signin Page Displayed");
		signin.setUserName(username);
		logger.info("Username Entered");
		
		signin.setPassword(password);
		
		logger.info("Password Entered");
		signin.clickSubmit();
		
		Thread.sleep(500);

	 
		if(isAlertPresent()==true)
		{
			if(driver.getTitle().equals("Login")) {
				logger.info("Data-driven Login not passed");
				captureScreen(driver,"loginDDT");
				Assert.assertTrue(false);
			
			}else {
				
			logger.info("Data-driven Login passed");
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(true);
			}
		//	signin.clickLogout();
		}
		else
		{
		//	Assert.assertTrue(true);
			logger.warn("No Alert Message");
			
			signin.clicklogout();
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			
		}
	
	}	


	public Boolean isAlertPresent() //user defined method created to check alert is present or not	alertText(String string)
	{
		try {
		return true;
		} catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="Data")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/Data.xlsx";
		
		int rownum=ExcelDataProvider.getRowCount(path, "Sheet1");
		int colcount=ExcelDataProvider.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)  //for(int j=1;j<=colcount;j++)
			{
				logindata[i-1][j]=ExcelDataProvider.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
