package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_WebDriber(String browsername){
		if(browsername.equals("chrome")){
			WebDriverManager.chromedriver().version("80.0").setup();
			if(prop.getProperty("headless").equals("yes")){    //if headless is yes then execute below code
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
			}
			else{
			driver = new ChromeDriver();	}		
		}
		else if(browsername.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();			
		}
		else{
			System.out.println("Please pass the correct browser name");
	}
	
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		
		//driver.get(url);
		
		return driver;
		
	}


public Properties init_properties()
{
	prop= new Properties();
	String path = ".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
	try {
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
	} catch (FileNotFoundException e) {
		System.out.println("please correct your config file");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return prop;
	}


}
