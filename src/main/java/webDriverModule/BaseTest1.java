package webDriverModule;

import java.io.File;
import java.io.FileInputStream;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseTest1 {

	WebDriver driver;
	public Properties prop = null;
	/*
	 * public ExtentReports rep = ExtentManager.getInstance(); public ExtentTest
	 * test;
	 */

	String propFilePath = "\\src\\test\\resources\\projectconfig.properties";
	
	
	public BaseTest1() {
		// init the prop file
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propFilePath);
				prop.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	public void openBrowser(String bType) {

		//System.out.println(prop.getProperty("appurl"));
		if (bType.equals("Mozilla")) {
			driver = new FirefoxDriver();
		} else if (bType.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver = new ChromeDriver();
		} else if (bType.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "path of chromedriver");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void navigate(String url) {
		System.out.println("Navigate to URL");
		driver.get(url);
	}

	public void click(By locatorKey) {
		// getElement(locatorKey).click();
		driver.findElement(locatorKey).click();

	}

	public void type(By locatorKey, String data) {
		// getElement(locatorKey).sendKeys(data);
		driver.findElement(locatorKey).sendKeys(data);
	}

	public WebElement getElement(String locatorKey) {
		WebElement e = null;
		try {
			if (locatorKey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorKey)));

			else {
				reportFailure("Locator not correct -" + locatorKey);
				// Assert.fail("Locator not correct - " + locatorKey);
			}

		} catch (Exception ex) {
			// fail the test and report the error
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			// Assert.fail("failed the test " + ex.getMessage());
		}
		return e;
	}

	/******************************************
	 * Validations
	 ******************************************************/

	public boolean isElementDisplayed(final By locator) {
		return isElementPresented(locator) ? driver.findElement(locator).isDisplayed() : false;
	}

	public boolean isElementPresented(final By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	public boolean verifyTitle() {
		return false;
	}

	public boolean isElementPresent(String locatorKey) {
		List<WebElement> elementList = null;
		if (locatorKey.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_xpath"))
			elementList = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_name"))
			elementList = driver.findElements(By.name(prop.getProperty(locatorKey)));

		else {
			reportFailure("Locator not correct -" + locatorKey);
			// Assert.fail("Locator not correct - " + locatorKey);
		}

		if (elementList.size() == 0)
			return false;
		else
			return true;

	}

	public boolean verifyText(String locatorKey, String expectedText) {

		String actualText = getElement(locatorKey).getText();
		/*
		 * expectedText = ; System.out.println("expectedText "+expectedText);
		 */
		if (actualText.equals(prop.getProperty(expectedText))) {
			return true;
		} else {
			return false;

		}
	}

	/********************************************
	 * Reporting
	 *********************************************************/
	public void reportPass(String msg) {
		// test.log(LogStatus.PASS, msg);
	}

	public void reportFailure(String msg) {
		// test.log(LogStatus.FAIL, msg);
		takeScreenshot();
		// Assert.fail();
	}

	public void takeScreenshot() {
		// FileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		System.out.println("Date " + screenshotFile);
		// Store screenshot in that file
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "//screenShot//" + screenshotFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// put screenshot file in reports
		// test.log(LogStatus.INFO, "Screenshot-> "
		// + test.addScreenCapture(System.getProperty("user.dir") + "//screenShot//" +
		// screenshotFile));
	}

}
