package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QueuePage {
	WebDriver ldriver;

	public QueuePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	 @FindBy (how = How.XPATH, using= "//a[@class= 'nav-link dropdown-toggle']")  WebElement Dropdown;
	 @FindBy (how = How.XPATH, using= "//a[@class='dropdown-item' and @href='/queue']")   WebElement QueuePage;
	 @FindBy (how = How.XPATH, using= "//a[@class='list-group-item' and @href='implementation-lists']") WebElement ImplementationLists;
	 @FindBy (how = How.XPATH, using= "//a[@href='/queue/implementation-collections/']")WebElement ImpCollectiondeque  ;  
	 @FindBy (how = How.XPATH, using= "//a[@href='/queue/Implementation-array/']") WebElement ImplementationArray;
	 @FindBy (how = How.XPATH, using= "//a[@href='/queue/QueueOp/']") WebElement QueueOperations;
	 @FindBy (how = How.XPATH, using= "//a[@class='btn btn-info']") WebElement Tryhere ;
//	 @FindBy (how = How.XPATH, using= "//div[@class= 'CodeMirror-lines']")WebElement CodeInput ;
	 @FindBy (how = How.XPATH, using= "//button[@type='button']")WebElement RunButtn ;
	 @FindBy (how = How.XPATH, using= "//a[@href= '/logout'] ") WebElement logout ;

	 
	 public void clickDropdown()
		{
		 Dropdown.click();
		}
	 
	 public void clickQueuePage()
		{
		 QueuePage.click();
		}
	 public void clickImplementationLists() {
		 ImplementationLists.click();
	 }
	 public void clickImpCollectiondeque()
		{
		 ImpCollectiondeque.click();
		}
	 public void clickImplementationArray()
		{
		 ImplementationArray.click();
		}
	 public void clickQueueOperations()
		{
		 QueueOperations.click();
		}
	 public void clickTryhere()
		{
		 Tryhere.click();
		}
	 public void clickRunButtn()
		{
		 RunButtn.click();
		}
//	 public void setCodeInput(String codedata)
//		{
//		 CodeInput.sendKeys(codedata);
//		}
	 public void clicklogout() {
			logout.click();
		}
}
