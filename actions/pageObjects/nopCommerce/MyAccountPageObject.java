package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.MyAccountPageUI;
import commoms.BasePage;

public class MyAccountPageObject extends BasePage {
	
	private WebDriver driver;


	public MyAccountPageObject(WebDriver _driver) {
		driver = _driver; 
	}
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver, MyAccountPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, MyAccountPageUI.GENDER_MALE_RADIO);

	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttreibuteValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");
		
	}
	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttreibuteValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttreibuteValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}


	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getAttreibuteValue(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getYearDropDownValue() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.YEAR_DROPDOWN);
	}

	public String getMonthDropDownValue() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.MONTH_DROPDOWN);
	}

	public String getDateDropDownValue() {
		waitForElementVisible(driver, MyAccountPageUI.DATE_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.DATE_DROPDOWN);
	}



}
