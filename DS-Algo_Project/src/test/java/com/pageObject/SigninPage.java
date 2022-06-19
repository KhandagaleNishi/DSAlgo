package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
WebDriver ldriver;
	
	public SigninPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy (how = How.XPATH, using= "//a[contains(text(),'Sign in')]")private @CacheLookup WebElement Signin;
	@FindBy (how = How.XPATH, using= "//input[@id='id_username']") private @CacheLookup WebElement Username;
	@FindBy (how = How.XPATH, using=  "//input[@id='id_password']") private @CacheLookup WebElement Password;
	@FindBy (how = How.XPATH, using=  "//input[@type='submit']") private @CacheLookup WebElement LoginBtn;
//	@FindBy (how = How.XPATH, using=  "//a[contains(text(),'Sign out']") private @CacheLookup WebElement LogoutLink;

	 @FindBy (how = How.XPATH, using= "//a[@href= '/logout'] ") WebElement logout ;


	
	public void setUserName(String username)
	{
		Username.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	
	public void clickSubmit()
	{
		LoginBtn.click();
	}	
	
//	public void clickLogout()
//	{
//		LogoutLink.click();
//	}
//	

	public void clickSingin()
	{
		Signin.click();
	}	
	public void clicklogout() {
		logout.click();
	}

}
