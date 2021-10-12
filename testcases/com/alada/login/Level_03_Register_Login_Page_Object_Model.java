package com.alada.login; 
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commoms.BasePage;
import pageObjects.alada.HomePageObject;
import pageObjects.alada.LoginPageObject;
//import org.openqa.selenium.WebDriver;  


public class Level_03_Register_Login_Page_Object_Model {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String projectPath = System.getProperty("user.dir");
	Select select;
	

	@BeforeClass
	public void beforeclass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//chromedriver");
//		}
		driver = new FirefoxDriver();
		
		//driver = new ChromeDriver();
		// 1 Open URL => navigate tới home page
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		loginPage = new LoginPageObject(driver);
	

	}

	@Test
	public void Tc_01_Login_With_Empty_Email_Password() {
	loginPage.enterToEmailTextBox("");
	loginPage.enterToPasswordTextbox("");
	loginPage.clickToButtonSubmit();
	Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Vui lòng nhập email");
	Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Vui lòng nhập mật khẩu");

	}

	@Test
	public void Tc_02_Login_With_Invalid_Email() {
		loginPage.enterToEmailTextBox("asdasd123");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToButtonSubmit();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Vui lòng nhập email hợp lệ");
	
	}

	@Test
	public void Tc_03_Login_With_Email_Not_Registered() {
		loginPage.enterToEmailTextBox("soidientan12@gmail.com");
		loginPage.enterToPasswordTextbox("123123123");
		loginPage.clickToButtonSubmit();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(), "Email này chưa được đăng ký.");
	}
	
	/**
	 * @author AN
	 * 
	 */
	@Test
	public void Tc_04_Login_With_Invalid_Password() {
		loginPage.enterToEmailTextBox("soidientan01@gmail.com");
		loginPage.enterToPasswordTextbox("12");
		loginPage.clickToButtonSubmit();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(), "Mật khẩu sai.");
		
		// Not Correct password >
		loginPage.enterToEmailTextBox("soidientan01@gmail.com");
		loginPage.enterToPasswordTextbox("123123123");
		loginPage.clickToButtonSubmit();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(), "Mật khẩu sai.");
		
		

	}
	@Test
	public void Tc_05_Login_With_Valid_Email_Password() {
		loginPage.enterToEmailTextBox("soidientan01@gmail.com");
		loginPage.enterToPasswordTextbox("pro123");
		loginPage.clickToButtonSubmit();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyCourseDisplayed());
	}

	@AfterClass
	public void affterClass() {
//		driver.close();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	

}
