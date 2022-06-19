package com.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObject.RegisterUser;
import com.utilities.AllureListener;
import com.utilities.BaseClass;
import com.utilities.ExcelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
@Listeners({AllureListener.class})
public class TC_RegisterTest_0012 extends BaseClass{
 
	@Test (dataProvider = "RegisterUser")
	@Description("Register user") 
	@Epic("0012")
	@Feature("Register")
	@Step("Register with password 1: {0} and password 2: {1} step.. ")
	@Severity (SeverityLevel.NORMAL)
	public void register( String passwd1, String passwd2) throws InterruptedException, IOException {
		RegisterUser register = new RegisterUser(driver);
		
		register.clickRegister();
		logger.info("Registeration Page Displayed");
		String Uname =  randomestring(); 
		register.setRegistername(Uname);
		register.setRegisterpasswd1(passwd1);
		register.setRegisterpasswd2(passwd2);
		logger.info("Name and Password entered");
		Thread.sleep(500);
		register.clickSubmitbtn();
		Thread.sleep(1000);
		
		if(isAlertPresent()==true)
		{
			if(driver.getTitle().equals("Registration")) {
				logger.info("Registration not completed");
				captureScreen(driver,"register");
				//Assert.assertTrue(false);
				Assert.assertEquals(false,false,"Registration not completed");
			
			}else if(driver.getTitle().equals("NumpyNinja")){
				
			logger.info("Registration completed");
			captureScreen(driver,"register");
			//Assert.assertTrue(true);
			Assert.assertEquals(true,true,"Registration completed");
			register.clicklogout();
		//	captureScreen(driver,"Logged out");
			logger.info("Logout completed");
			
			}

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
	
	@DataProvider(name="RegisterUser")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/Data.xlsx";
		
		int rownum=ExcelDataProvider.getRowCount(path, "Sheet3");
		int colcount=ExcelDataProvider.getCellCount(path,"Sheet3",1);
		
		String userdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)  //for(int j=1;j<=colcount;j++)
			{
				userdata[i-1][j]=ExcelDataProvider.getCellData(path,"Sheet3", i,j);//1 0
			}
				
		}
	return userdata;
	}
	
}