package webDriverModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import reports.ExtentManager;

public class WebConnector1 {

	protected WebDriver driver;
	public ExtentTest scenario;

	public WebConnector1(WebDriver driver,ExtentTest scenario) {
		this.driver = driver;
		this.scenario =scenario;
	
		// wb = new WebDriverInstance();
		/*
		 * if (prop == null) {
		 * 
		 * try { prop = new Properties(); FileInputStream fs = new FileInputStream(
		 * System.getProperty("user.dir") +
		 * "\\src\\test\\resources\\configs\\config.properties"); prop.load(fs); } catch
		 * (Exception e) { e.printStackTrace(); // report } }
		 */
	}

	/*
	 * public WebDriver WebConnector(WebDriver driver) { if(driver == null) {
	 * WebConnector.driver = driver; } return driver;
	 */

	/*
	 * if (prop == null) {
	 * 
	 * try { prop = new Properties(); FileInputStream fs = new FileInputStream(
	 * System.getProperty("user.dir") ); prop.load(fs); } catch (Exception e) {
	 * e.printStackTrace(); // report } } }
	 */

	public RemoteWebDriver getRemoteWebDriver() {
		return (RemoteWebDriver) driver;
	}

	public boolean isChrome() {
	
		return "chrome".equals(getRemoteWebDriver().getCapabilities().getBrowserName());
	}

	public boolean isInternetExplorer() {
		return "internetExplorer".equals(getRemoteWebDriver().getCapabilities().getBrowserName());
	}

	public boolean isEdge() {
		return "edge".equals(getRemoteWebDriver().getCapabilities().getBrowserName());
	}

	public boolean isFirefox() {
		return "firefox".equals(getRemoteWebDriver().getCapabilities().getBrowserName());
	}

	/*
	 * public void openBrowser(String bType) {
	 * 
	 * //System.out.println(prop.getProperty("appurl")); if
	 * (bType.equals("Mozilla")) { driver = new FirefoxDriver(); } else if
	 * (bType.equals("Chrome")) { System.setProperty("webdriver.chrome.driver",
	 * "C:\\jarsRepository\\chromedriver.exe"); driver = new ChromeDriver(); } else
	 * if (bType.equals("IE")) { System.setProperty("webdriver.chrome.driver",
	 * "path of chromedriver"); driver = new InternetExplorerDriver(); }
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * driver.manage().window().maximize(); }
	 */

	public void navigate(String urlKey) {
		// System.out.println(prop.getProperty(urlKey));
		scenario.log(Status.INFO,"Navigating URL "+ urlKey);
		driver.get(urlKey);
		
	}

	public void click(By objectKey) {
		infoLog("WebConnector Looking for Element to click "+ objectKey);
		driver.findElement(objectKey).click();
		infoLog("WebConnector Clicked on Element successfully "+ objectKey);
	}

	public void type(By locatorKey, String data) {
		
		infoLog("WebConnector Looking for Element to Type "+ locatorKey + " with Data "+ data );
		driver.findElement(locatorKey).sendKeys(data);
		infoLog("WebConnector Entered Data Successfully on  "+ locatorKey + " with Data "+ data );
	}

	public boolean isElementDisplayed(final By locator) {
		
		return isElementPresented(locator) ? driver.findElement(locator).isDisplayed() : false;
	}

	public boolean isElementPresented(final By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	public void selectValueFromDropdown(By dropdownSelector, By variationSelectors, String data) {
		infoLog("WebConnector Looking for Element to select "+ dropdownSelector + " & " + variationSelectors + "with Option "+data);
		click(dropdownSelector);
		List<WebElement> allSelectors = driver.findElements(variationSelectors);
		for (WebElement selector : allSelectors) {
			if (selector.getText().trim().equalsIgnoreCase(data)) {
				selector.click();
				break;
			}
		}
		infoLog("WebConnector selected the expected Option Seccessfully "+data);
	}
	
	public String getTextFromLocator(By locatorKey) {
		String getActualText = driver.findElement(locatorKey).getText().trim();
		return getActualText;
	}
	
	public void wait(int timeWaitSec) {
		try {
			Thread.sleep(timeWaitSec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void hoverMouseOverOn(By locatorKey) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locatorKey)).build().perform();
		wait(2);
	}
	
/************************************************ Report ********************************************************/
	
	public void takeScreenshot() {
		// FileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		System.out.println("Date " + screenshotFile);
		// Store screenshot in that file
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenShotFolderPath + screenshotFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// put screenshot file in reports
		try {
			scenario.log(Status.INFO, "Screenshot-> "
					+ scenario.addScreenCaptureFromPath(ExtentManager.screenShotFolderPath + screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void infoLog(String msg) {
		scenario.log(Status.INFO,msg);
		takeScreenshot();
	}
	
}
