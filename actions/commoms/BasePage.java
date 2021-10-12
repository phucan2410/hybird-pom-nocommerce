package commoms;

import java.awt.Desktop.Action;
import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	// Action click/open/sendkeys/Select => void

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
		// Cái này dùng để verify mình get ra thì mình phải return lại dữ liệu
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backtoPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public Alert waitForAlertpersence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void accpectAltert(WebDriver driver) {
		alert = waitForAlertpersence(driver);
		alert.accept();
	}

	public void canceltAltert(WebDriver driver) {
		alert = waitForAlertpersence(driver);
		alert.dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertpersence(driver);
		alert.sendKeys(value);
	}

	public String getTextInArlert(WebDriver driver, String value) {
		alert = waitForAlertpersence(driver);
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void clickToElement(WebDriver driver, String locator) {
		waitForElementClickAble(driver, locator).click();
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getWebElements(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(value);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public String getFirstSelectedItemInDefaultDropdown(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public void sleepInSecond(long timeoutInsecond) {
		try {
			Thread.sleep(timeoutInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {

		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAttreibuteValue(WebDriver driver, String locator, String attributname) {
		return getWebElement(driver, locator).getAttribute(attributname);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	public String getlementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}

	public int getelementSize(WebDriver driver, String locator) {
		return getWebElements(driver, locator).size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			waitForElementClickAble(driver, locator).click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			waitForElementClickAble(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		
		return waitForElementVisible(driver, locator).isDisplayed();
	}

	public boolean isElemenEnabled(WebDriver driver, String locator) {
		waitForElementVisible(driver, locator);
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));

	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void moveMouseElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator)).perform();
	}

	public void DragDrop(WebDriver driver, String sourceLocator, String targetLocation) {
		action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocation)).perform();
	}

	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public String convertRGBAToHexa(String rgbValue) {
		return Color.fromString(rgbValue).asHex();

	}

	public void uploadToElement(WebDriver driver, String locator, String filePath) {
		getWebElement(driver, locator).sendKeys(filePath);

	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public WebElement waitForElementClickAble(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	

	private long shortTimeout = 5;
	private long longTimeout = 30;
	private Alert alert;
	private Select select;
	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
