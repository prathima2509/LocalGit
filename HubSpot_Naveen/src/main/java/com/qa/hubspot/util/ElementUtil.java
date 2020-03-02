package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		wait= new WebDriverWait(driver,AppConstants.DEFAULT_TIMEOUT);
	}
	
	
	
	
	public boolean waitForTitlePresent(String title){
		 wait.until(ExpectedConditions.titleIs(title));
		 return true;
	}
	
	public boolean waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	public boolean waitForElementVisibility(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	public String doGetPageTitle(){
		try{
		return driver.getTitle();}
		catch(Exception e){
			System.out.println("some exception occured while getting the page title");
	}
	return null;
	}	
	
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
			//if(waitForElementPresent(locator))
				element= driver.findElement(locator);
			}
		catch(Exception e){
			System.out.println("some exception occured while creating the webelement");
		}
		return element;
	}

	public void doCLick(By locator){
		try{ 
		getElement(locator).click();	
	}
		catch(Exception e){
	System.out.println("some exception occured while clicking on the webelement");
		}
	
	}
	
	public void doSendKeys(By locator, String value){
		try{
		WebElement ele=getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
		catch(Exception e){
			System.out.println("some exception occured while entering values in a field");
		}
}
	

public boolean doIsDisplayed(By locator){
	try{
	return getElement(locator).isDisplayed();
}catch(Exception e){
	System.out.println("some exception occured while running method diIsDisplayed");
}
	return false;
}


public String doGetText(By locator){
	try{
	return getElement(locator).getText();
	}
	catch(Exception e){
		System.out.println("some exception occured while running method doGetText");
	}
	return null;
}


}

