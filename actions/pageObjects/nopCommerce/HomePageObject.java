package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.HomePageUI;
import commoms.BasePage;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	/**
	 * Hàm khởi tạo
	 * không có kiểu trả v�?
	 * Cùng tên với class
	 * Trong 1 class có thể có 1 hoặc nhi�?u hàm khởi tạo
	 * khi new class hàm khởi tạo được g�?i đầu tiên
	 * 
	 */
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		System.out.println("Driver ID at Page Object Class: " + driver.toString());
	}
	public void clickToRegisterLink() {
		waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	
	public void clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	
	}
	public void clickToMyAccountLink() {
	waitForElementClickAble(driver, HomePageUI.MYACCOUNT_LINK);
	clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
	}



}
