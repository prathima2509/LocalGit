package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;

public class HomePageTest extends TestBase{
	
	Properties prop;
	WebDriver driver;
	Credentials userCred;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		prop = init_properties();
		driver = init_WebDriber(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"),prop.getProperty("password"));
		homepage = loginpage.doLogin(userCred);
		Thread.sleep(10000);
		
		Thread.sleep(10000);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException
	
	{	Thread.sleep(5000);
		homepage.clickOnLogo();
		Thread.sleep(5000);
		String title = homepage.getHomePagetitle();
		System.out.println("home page title is: "+title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifyhomepageheader() throws InterruptedException
	{	Thread.sleep(5000); 
	homepage.clickOnLogo();
	Thread.sleep(5000);
	String header = homepage.getHomePageHeader();
		System.out.println(header+" this is the header");
		Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER);
	}
	@Test(priority=3)
	public void verifyLoggedinUser() throws InterruptedException
	{	Thread.sleep(5000);
	homepage.clickOnLogo();
	Thread.sleep(5000);
	String user = homepage.getLoggedInUserAccountName();
		System.out.println(user+" this is the user");
		Assert.assertEquals(user, prop.getProperty("accountname"));
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
