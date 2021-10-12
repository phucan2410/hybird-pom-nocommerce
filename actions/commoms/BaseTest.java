package commoms;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commoms.GlobalConstants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {



	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default:
				throw new RuntimeException("Browser name is not correct!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

//	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
//		Browser browser = Browser.valueOf(browserName.toUpperCase());
//		
//		//Check browser version hien tai 
//		// Tai ve
//		// Init browser len dung 
//		
//		if (browser == Browser.FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			System.out.println("Driver init at Bast Test = " + driver.toString());
//		} else if (browser == Browser.CHROME) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (browser == Browser.EDGE) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//
//		} else {
//			throw new RuntimeException("Browser name is not correct");
//		}
//		return driver;
//	}

	private String getSlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}

}
