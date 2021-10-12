package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.LoginPageUI;
import commoms.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void sendkeyToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendkeyToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public void clickToLoginbutton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_LINK);
		clickToElement(driver, LoginPageUI.LOGIN_LINK);

	}

	public boolean isLoginSuccessMessageDisplayed() {

		return false;
	}

}
