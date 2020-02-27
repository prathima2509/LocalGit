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

public class HomePageTest extends TestBase{
	
	Properties prop;
	WebDriver driver;
	
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		prop = init_properties();
		driver = init_WebDriber(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		
		Thread.sleep(10000);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{	homepage.clickOnLogo();
		String title = homepage.getHomePagetitle();
		System.out.println("home page title is: "+title);
		Assert.assertEquals(title, "Reports Dashboards");
	}
	@Test(priority=2)
	public void verifyhomepageheader()
	{	homepage.clickOnLogo();
		String header = homepage.getHomePageHeader();
		System.out.println(header+" this is the header");
		Assert.assertEquals(header, "sales Dashboard");
	}
	@Test(priority=3)
	public void verifyLoggedinUser()
	{	homepage.clickOnLogo();
		String user = homepage.getLoggedInUserAccountName();
		System.out.println(user+" this is the user");
		Assert.assertEquals(user, "AccountNo1");
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
