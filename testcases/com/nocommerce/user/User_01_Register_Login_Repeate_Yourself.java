package com.nocommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.WebDriver;  


public class User_01_Register_Login_Repeate_Yourself {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, date, month, year, emailAddress, companyName, password, confirmpasswork;
	
	@BeforeClass
	public void beforeclass() {
		//System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");
		firstName = "An";
		lastName = "Nguyen";
		date = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + getRandomNumber() + "@gmail.com";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpasswork = "phucan1!";
		
	}
	
	@Test
	public void Tc_01_Register() throws InterruptedException {
		driver.findElement(By.className("ico-register")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText(date);

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(month);

		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(year);

		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		
		//check newletter
		if(!driver.findElement(By.id("Newsletter")).isSelected()) {
			driver.findElement(By.id("Newsletter")).click();
		}
				
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmpasswork);

		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
		
		

		
	}
	
	@Test
	public void Tc_02_Login() {
		driver.findElement(By.className("ico-logout")).click();		
//		driver.findElement(By.)
		
	}
	
	@Test
	public void Tc_03_Verifymyaccount() {
		
		
	}
	@AfterClass
	public void affterClass() {
		
	}
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	

}
