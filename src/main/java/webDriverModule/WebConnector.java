package webDriverModule;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentManager;

public class WebConnector {

	protected WebDriver driver;
	public ExtentTest scenario;

	public WebConnector(WebDriver driver, ExtentTest scenario) {
		this.driver = driver;
		this.scenario = scenario;

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
	/****************************************** Initialize the Remote WebDriver ***********************************/
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
	/****************************************** Navigate to the Application ***********************************/
	public void navigate(String urlKey) {
		// System.out.println(prop.getProperty(urlKey));
		try {
			driver.get(urlKey);
			scenario.log(Status.INFO, "Navigating URL " + urlKey);
		} catch (Exception e) {
			e.printStackTrace();
			failLog("Unable to Navigate to the URL " + urlKey);
		}
	}

	/*************************************************** Reporting ********************************************/

	public void takeScreenshot() {
		// FileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
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
		scenario.log(Status.INFO, msg);
		takeScreenshot();
	}

	public void errorLog(String msg) {
		scenario.log(Status.ERROR, msg);
		takeScreenshot();
	}

	public void passLog(String msg) {
		scenario.log(Status.PASS, msg);
		takeScreenshot();
	}

	public void failLog(String msg) {
		scenario.log(Status.FAIL, msg);
		takeScreenshot();
	}

	/*************************************************** General Methods ********************************************/
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public void click(By objectKey) {
		infoLog("WebConnector Looking for Element to click " + objectKey);
		driver.findElement(objectKey).click();
		infoLog("WebConnector Clicked on Element successfully " + objectKey);
	}

	public void type(By locatorKey, String data) {
		infoLog("WebConnector Looking for Element to Type " + locatorKey + " with Data " + data);
		driver.findElement(locatorKey).sendKeys(data);
		infoLog("WebConnector Entered Data Successfully on  " + locatorKey + " with Data " + data);
	}

	public void clearAndType(By locatorKey, String data) {
		driver.findElement(locatorKey).clear();
		infoLog("WebConnector Looking for Element to Type " + locatorKey + " with Data " + data);
		driver.findElement(locatorKey).sendKeys(data);
		infoLog("WebConnector Entered Data Successfully on  " + locatorKey + " with Data " + data);
	}

	public String getText(By locatorKey) {
		infoLog("Getting text from " + locatorKey);
		return findElement(locatorKey).getText().trim();
	}

	public void selectValueFromDropdown(By dropdownSelector, By variationSelectors, String data) {
		infoLog("WebConnector Looking for Element to select " + dropdownSelector + " & " + variationSelectors
				+ "with Option " + data);
		if (!dropdownSelector.toString().isEmpty()) {
			click(dropdownSelector);
		}
		List<WebElement> allSelectors = driver.findElements(variationSelectors);
		for (WebElement selector : allSelectors) {
			if (selector.getText().trim().equalsIgnoreCase(data)) {
				selector.click();
				break;
			}
		}
		infoLog("WebConnector selected the expected Option Seccessfully " + data);
	}

	public void selectValueFromDropdown(By dropdownSelector, String data) {
		infoLog("WebConnector Looking for Element to select " + dropdownSelector + "with Option " + data);
		new Select(findElement(dropdownSelector)).selectByVisibleText(data);
		infoLog("WebConnector selected the expected Option Seccessfully " + data);
	}
	
	//one way of implementation
	public void focusOnElement() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('elementid').focus();");
	}


	//other way of implementation
	public void FocusOnElement() {
	driver.findElement(By.xpath("ElementRequired")).sendKeys(Keys.SHIFT);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("element.focus();");
	}
	
	public void ScrollIntoView(By locator) {
	WebElement element = driver.findElement(locator);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	wait(1);
	}  
	
	/*************************************************** Verification Methods ********************************************/
	public boolean isElementDisplayed(final By locator) {

		return isElementPresented(locator) ? driver.findElement(locator).isDisplayed() : false;
	}

	public boolean isElementPresented(final By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	/*************************************************** Waits ********************************************/

	public void wait(int timeWaitSec) {
		try {
			Thread.sleep(timeWaitSec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean waitForElementToBePresent(By locator, long timeOutInSeconds) {
		boolean result = true;
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			result = false;
		}
		return result;
	}

	public void waitAndClick(int timeoutSec, By locatorKey) throws IOException {
		String clickOnText = findElement(locatorKey).getText();
		WebElement element = findElement(locatorKey);

		try {
			scenario.log(Status.INFO, "Trying to clicking on " + locatorKey + "---" + clickOnText);
			WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorKey));
			((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView();", element);
			findElement(locatorKey).click();
			scenario.log(Status.INFO, "Element clicked sucessfully:-" + locatorKey);
		} catch (Exception e) {
			scenario.log(Status.INFO, "Element is NOT clickable :-" + locatorKey);
			failLog("Failed to click the button :-" + locatorKey);
			e.printStackTrace();
		}
	}

	public void waitForAjaxCall() {

		Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
				.executeScript("return (typeof(jQuery) != 'undefined')");
		if (isJqueryUsed) {
			while (true) {
				// JavaScript test to verify jQuery is active or not
				Boolean ajaxIsComplete = (Boolean) (((JavascriptExecutor) driver)
						.executeScript("return jQuery.active == 0"));
				if (ajaxIsComplete)
					break;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
