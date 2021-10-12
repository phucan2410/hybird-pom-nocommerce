package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import PageUIs.alada.LoginPageUI;
import commoms.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSOWRD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSOWRD_TEXTBOX, password);
	}

	public void clickToButtonSubmit() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSGAE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSGAE);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, LoginPageUI.PASSOWRD_ERROR_MESSGAE);
		return getElementText(driver, LoginPageUI.PASSOWRD_ERROR_MESSGAE);
	}

	public String getErrorMessageAtLoginForm() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM_MESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_FORM_MESSAGE);
	}

}
