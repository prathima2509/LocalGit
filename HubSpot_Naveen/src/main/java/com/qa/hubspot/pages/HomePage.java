package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends TestBase{
	
	
	//Use elementUtils.wait instead of thread.sleep()
	//do not add wait in test.java class. always use wait in page classes
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By homeLogo = By.id("nav-primary-home");
	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(driver); 
		elementUtil.waitForElementVisibility(homeLogo);
	}
	

	public String getHomePageHeader(){
		return elementUtil.doGetText(header);
	}
	
	public String getLoggedInUserAccountName() throws InterruptedException{
		//Thread.sleep(5000);
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_HEADER);
		return elementUtil.doGetText(accountName);
	}
	
	public String getHomePagetitle(){
		//Thread.sleep(600);
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public void clickOnLogo()
	{	elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_HEADER);
		driver.findElement(homeLogo).click();
		
	}
}
