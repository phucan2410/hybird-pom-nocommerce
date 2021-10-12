package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import PageUIs.alada.HomePageUI;
import commoms.BasePage;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver _driver) {
		driver = _driver;
	
	}

	public boolean isMyCourseDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_COURSE_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_COURSE_LINK);
	}
}

