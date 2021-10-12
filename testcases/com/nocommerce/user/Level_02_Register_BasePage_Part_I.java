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


public class Level_02_Register_BasePage_Part_I {
	WebDriver driver;
	BasePage basePage;
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
		
		basePage.openPageUrl(driver, "http://demo.nopcommerce.com/");
		
		firstName = "An";
		lastName = "Nguyen";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + getRandomNumber() + "@gmail.com";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpasswork = "phucan1!";
		
	}
	
	@Test
	public void Tc_01_Register() {
		
		basePage.clickToElement(driver, "//a[text()='Register']");
		basePage.sleepInSecond(2);
		basePage.checkToCheckBox(driver, "//input[@id='gender-male']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);	
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);	
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyName);	
		basePage.checkToCheckBox(driver, "//input[@name='Newsletter']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmpasswork);
		basePage.clickToElement(driver, "//button[@id='register-button']");

		
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
	
		
		

		
	}
	
	@Test
	public void Tc_02_Login() {
		basePage.sleepInSecond(2);
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	
		basePage.clickToElement(driver, "//a[@class='ico-login']");
		
		basePage.sendkeyToElement(driver, "//input[@class='email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@class='password']", password);
		basePage.clickToElement(driver, "//button[text()='Log in']");
		Assert.assertEquals(basePage.getElementText(driver, "//h2[text()='Welcome to our store']"), "Welcome to our store");
		
		
	}
	
	@Test
	public void Tc_03_Verifymyaccount() {
		basePage.clickToElement(driver, "//a[@class='ico-account']");
		Assert.assertTrue(basePage.isElementSelected(driver, "//label[text()='Male']"));
		Assert.assertEquals(basePage.getAttreibuteValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(basePage.getAttreibuteValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(basePage.getAttreibuteValue(driver, "//input[@id='Company']", "value"), companyName);
		Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='Newsletter']"));
		
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
		
	
		
	}
	@AfterClass
	public void affterClass() {
		
	}
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	

}
