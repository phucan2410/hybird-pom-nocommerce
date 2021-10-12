package com.nocommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import commoms.BasePage;
//import org.openqa.selenium.WebDriver;  


public class Level_02_Register_BasePage_Part_III extends BasePage {
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	String firstName, lastName, day, month, year, emailAddress, companyName, password, confirmpasswork;
	
	
	@BeforeClass
	public void beforeclass() {
	
		//System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
		} else
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//chromedriver");
		}
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		openPageUrl(driver, "http://demo.nopcommerce.com/");
		
		firstName = "An";
		day = "10";
		month = "May";
		year = "1999";
		lastName = "Nguyen";
		emailAddress = "soidientan" + getRandomNumber() + "@gmail.com";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpasswork = "phucan1!";
		
	}
	
	@Test
	public void Tc_01_Register() {
		
		clickToElement(driver, "//a[text()='Register']");
		sleepInSecond(2);
		checkToCheckBox(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);	
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);	
		sendkeyToElement(driver, "//input[@id='Company']", companyName);	
		checkToCheckBox(driver, "//input[@name='Newsletter']");
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmpasswork);
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}
	
	@Test
	public void Tc_02_Login() {
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-logout']");
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@class='email']", emailAddress);
		sendkeyToElement(driver, "//input[@class='password']", password);
		clickToElement(driver, "//button[text()='Log in']");
		Assert.assertEquals(getElementText(driver, "//h2[text()='Welcome to our store']"), "Welcome to our store");

	}
	
	@Test
	public void Tc_03_Verifymyaccount() {
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-account']");
		sleepInSecond(2);
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getAttreibuteValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getAttreibuteValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getAttreibuteValue(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
	
		
	}
	@AfterClass
	public void affterClass() {
		driver.close();
	}
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	

}
