package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.TestBase;

public class LoginPage extends TestBase{
	
	
	WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public boolean checksignupLink()
	{
		return driver.findElement(signupLink).isDisplayed();
	}
	public HomePage doLogin(String un, String pwd)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		
		return new HomePage(driver);
	}
}
