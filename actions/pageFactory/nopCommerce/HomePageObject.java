package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopCommerce.HomePageUI;

import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePageObject {
	 WebDriver driver;
	WebDriverWait explicitWait;
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		explicitWait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
		//Page UI: Locator
		@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
		private WebElement registerLink;
		@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
		private WebElement loginLink;
		@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
		private WebElement myAccountLink;
		
	// Page Object : Actiion
		public void clickToRegisterLink() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
		
		}
		
		public void clickToLoginLink() {
			explicitWait.until(ExpectedConditions.elementToBeClickable(loginLink	));
			loginLink.click();
		
		}
		public void clickToMyAccountLink() {
			explicitWait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
			myAccountLink.click();;
		}
}

