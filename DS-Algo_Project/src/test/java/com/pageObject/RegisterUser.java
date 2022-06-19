package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterUser {
	WebDriver ldriver;

	public RegisterUser(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	 @FindBy (how = How.XPATH, using= "//a[@href= '/register']") WebElement register ;
	 @FindBy (how = How.XPATH, using= "//input[@id= 'id_username']") WebElement registername;
	 @FindBy (how = How.XPATH, using= "//input[@id= 'id_password1']") WebElement registerpasswd1;
	 @FindBy (how = How.XPATH, using= "//input[@id= 'id_password2']") WebElement registerpasswd2;
	 @FindBy (how = How.XPATH, using= "//input[@type= 'submit']") WebElement submitbtn;
	 @FindBy (how = How.XPATH, using= "//a[@href= '/logout'] ") WebElement logout ;

	
	public void clickRegister() {
		register.click();
	}
	
	public void setRegistername(String name) {
		registername.sendKeys(name);
	}
	
	public void setRegisterpasswd1(String passwd1) {
		registerpasswd1.sendKeys(passwd1);;
	}
	
	public void setRegisterpasswd2(String passwd2) {
		registerpasswd2.sendKeys(passwd2);
	}
	
	public void clickSubmitbtn() {
		submitbtn.click();
	}
	public void clicklogout() {
		logout.click();
	}
}
