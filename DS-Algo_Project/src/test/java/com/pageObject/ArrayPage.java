package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
WebDriver ldriver;

	public ArrayPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	 @FindBy (how = How.XPATH, using= "//a[@class= 'nav-link dropdown-toggle']")  WebElement Dropdown;
	 @FindBy (how = How.XPATH, using= "//a[@class='dropdown-item' and @href='/array']")   WebElement ArrayPage;
	 @FindBy (how = How.XPATH, using= "//a[@class='list-group-item' and @href='arrays-in-python']") WebElement ArraysPython;
	 @FindBy (how = How.XPATH, using= "//a[@href='/array/arrays-using-list/']")WebElement ArraysList  ;  
	 @FindBy (how = How.XPATH, using= "//a[@href='/array/basic-operations-in-lists/']")WebElement BasicOpLists ;
	 @FindBy (how = How.XPATH, using= "//a[@href='/array/applications-of-array/']")WebElement ApplArray ;
	 @FindBy (how = How.XPATH, using= "//a[@class='btn btn-info']") WebElement Tryhere ;
	 @FindBy (how = How.XPATH, using= "//button[@type='button']")WebElement RunButtn ;
	 @FindBy (how = How.XPATH, using= "//a[@href= '/logout'] ") WebElement logout ;
	 

	 public void clickDropdown()
		{
		 Dropdown.click();
		}
	 
	 public void clickArrayPage()
		{
		 ArrayPage.click();
		}
	 public void clickArraysPython() {
		 ArraysPython.click();
	 }
	 public void clickArraysList()
		{
		 ArraysList.click();
		}
	 public void clickBasicOpLists()
		{
		 BasicOpLists.click();
		}
	 public void clickApplArray()
		{
		 ApplArray.click();
		}
	 public void clickTryhere()
		{
		 Tryhere.click();
		}
	 public void clickRunButtn()
		{
		 RunButtn.click();
		}

	 public void clicklogout() {
			logout.click();
		}
}
