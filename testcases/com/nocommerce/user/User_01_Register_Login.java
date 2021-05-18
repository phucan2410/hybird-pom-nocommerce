package com.nocommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.WebDriver;  


public class User_01_Register_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void beforeclass() {
		//System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");
		
	}
	
	@Test
	public void Tc_01_Register_Empty_Data() {
		
		
	}

}
