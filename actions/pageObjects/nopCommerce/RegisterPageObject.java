package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.RegisterPageUI;
import commoms.BasePage;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickToGenderMaleRadio() {
		waitForElementClickAble(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void enterToFirstNameTextBox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	public void enterToLastNameTextBox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public void selectDayDropDown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);

	}

	public void enterToEmailTextBox(String emailaddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailaddress);

	}

	public void enterToCompanyTextBox(String company) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public void clickToRegisterButton() {
		waitForElementClickAble(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_MESSAGE);
		
	}

	public void clickToLogOutLink() {
		waitForElementClickAble(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);

	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextBox(String confirmpassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmpassword);
	}


}
