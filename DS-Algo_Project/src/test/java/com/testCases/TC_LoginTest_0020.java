package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.pageObject.SigninPage;
import com.utilities.AllureListener;
import com.utilities.BaseClass;




@Listeners({AllureListener.class})
public class TC_LoginTest_0020 extends BaseClass{
	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		SigninPage signin=new SigninPage(driver);
		signin.setUserName(username);
		logger.info("Entered username");
		
		signin.setPassword(password);
		logger.info("Entered password");
		
		signin.clickSubmit();
		
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(false);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			logger.info("Login test failed");
		}
	
	}

	
  }

