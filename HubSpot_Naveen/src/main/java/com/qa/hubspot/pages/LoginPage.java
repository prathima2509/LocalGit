package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends TestBase{
	
	ElementUtil elementUtil;
	WebDriver driver;
	
	//page object pattern with encapsulated approach
	//shoudl not write driver.find element in page class
	//should not write assert in pagetest class
	//[page factory will be deprecated soon - ex @findBy }--- so we are using "By" locator
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");
	By loginErrorText = By.xpath("//div[@class='private-alert__inner']");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}

	public String getPageTitle(){
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public boolean checksignupLink()
	{	elementUtil.waitForElementPresent(signupLink);
		return elementUtil.doIsDisplayed(signupLink);
	}
	public HomePage doLogin(Credentials userCred)
	{	elementUtil.waitForElementPresent(username);
		elementUtil.doSendKeys(username, userCred.getAppUserName());					//driver.findElement(username).sendKeys(un);
		elementUtil.doSendKeys(password, userCred.getAppPassword());					//driver.findElement(password).sendKeys(pwd);
		elementUtil.doCLick(loginButton);						//driver.findElement(loginButton).click();
		return new HomePage(driver);
	}
	
	public boolean checkLoginErrorMessage(){
		return elementUtil.doIsDisplayed(loginErrorText);
	}
}
