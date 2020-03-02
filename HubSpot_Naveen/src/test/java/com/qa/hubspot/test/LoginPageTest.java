package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	
	@BeforeTest
	public void setUp(){
		prop = init_properties();
		String browsername = prop.getProperty("browser");
		driver = init_WebDriber(browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		}
	
	@Test(priority=1)
	public void verifyLoginPagetitletest() throws InterruptedException{
		Thread.sleep(10000);
		String title=loginpage.getPageTitle();
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginpage.checksignupLink());
	}
	
	@Test(priority=3)
	public void LoginTest(){
	loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
