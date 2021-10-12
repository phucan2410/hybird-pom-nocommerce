package com.nocommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commoms.BasePage;
import commoms.BaseTest;
//import org.openqa.selenium.WebDriver;  
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myaccountPage;
	RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	String firstName, lastName, day, month, year, emailAddress, companyName, password, confirmpassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeclass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		System.out.println("Driver ID at Page Object Class: " + driver.toString());
		// 1 Open URL => navigate tới home page
		driver.get("http://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
 
		firstName = "An";
		lastName = "Nguyen";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + getRandomNumber() + "@gmail.com";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpassword = "phucan1!";

	}

	@Test
	public void Tc_01_Register() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderMaleRadio();
		registerPage.enterToFirstNameTextBox(firstName);
		registerPage.enterToLastNameTextBox(lastName);
		registerPage.selectDayDropDown(day);
		registerPage.selectMonthDropDown(month);
		registerPage.selectYearDropDown(year);
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToCompanyTextBox(companyName);
		registerPage.enterToPasswordTextBox(password);
		registerPage.enterToConfirmPasswordTextBox(confirmpassword);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());

		registerPage.clickToLogOutLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Tc_02_Login() {
		// Home page click vao Login Link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendkeyToEmailTextBox(emailAddress);
		loginPage.sendkeyToPasswordTextBox(password);
		loginPage.clickToLoginbutton();

		homePage = new HomePageObject(driver);
	}

	@Test
	public void Tc_03_Verifymyaccount() {
		homePage.clickToMyAccountLink();
		myaccountPage = new MyAccountPageObject(driver);

		Assert.assertTrue(myaccountPage.isGenderMaleRadioSelected());
		Assert.assertEquals(myaccountPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(myaccountPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(myaccountPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(myaccountPage.getCompanyTextboxValue(), companyName);
		Assert.assertEquals(myaccountPage.getDateDropDownValue(), day);
		Assert.assertEquals(myaccountPage.getMonthDropDownValue(), month);
		Assert.assertEquals(myaccountPage.getYearDropDownValue(), year);
	}

	@AfterClass
	public void affterClass() {
		driver.close();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	public void sleepInSecond(long timeoutInsecond) {
		try {
			Thread.sleep(timeoutInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
