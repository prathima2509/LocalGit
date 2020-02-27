package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;

public class HomePage extends TestBase{
	
	WebDriver driver;
	
	By homeLogo = By.id("nav-primary-home");
	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	

	public String getHomePageHeader(){
		return driver.findElement(header).getText();
	}
	
	public String getLoggedInUserAccountName(){
		return driver.findElement(accountName).getText();
	}
	
	public String getHomePagetitle(){
		return driver.getTitle();
	}
	
	public void clickOnLogo()
	{
		driver.findElement(homeLogo).click();
		
	}
}
