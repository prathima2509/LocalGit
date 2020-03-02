package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.TestBase;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;

public class LoginPageTest extends TestBase{
	
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	Credentials userCred;
	
	@BeforeTest
	public void setUp(){
		prop = init_properties();
		String browsername = prop.getProperty("browser");
		driver = init_WebDriber(browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	@Test(priority=1)
	public void verifyLoginPagetitletest() throws InterruptedException{
		//Thread.sleep(10000);
		String title=loginpage.getPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginpage.checksignupLink());
		
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException{
	HomePage homepage=loginpage.doLogin(userCred);
	String accname = homepage.getLoggedInUserAccountName();
	Assert.assertEquals(accname, prop.getProperty("accountname"));
	}
	
	@DataProvider
	public Object[][] getLoginWrongCredentials(){
		Object data[][]={{"test1@gmail.com","22dfsfsdf23"},
						{"abc@gmail.com","pwddfdsfs123"},
						{" ", "kpdfsw123"},
						{"abc@gmail.com"," "},
						{"",""}};
		
		return data;  				// always return 2DM array
	}
	
	
	@Test(priority=4, dataProvider="getLoginWrongCredentials", enabled=false) 
	public void LoginTest_WrongCredentials(String username, String password){
		userCred.setAppUserName(username);
		userCred.setAppPassword(password);
		loginpage.doLogin(userCred);
		Assert.assertTrue(loginpage.checkLoginErrorMessage());
	
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
