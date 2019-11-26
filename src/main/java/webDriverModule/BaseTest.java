package webDriverModule;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.LogStatus;

/*import com.qtpselenium.core.ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/

public class BaseTest {

	public static WebDriver driver;
	public Properties prop= null;
	/*public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;*/
	
	String propFilePath="\\src\\test\\resources\\projectconfig.properties";
	
	
	/*public void init() {
		//init the prop file
				if(prop == null) {
					prop = new Properties();
					try {
						FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+propFilePath);
						prop.load(fis);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}*/
	
	public WebDriver BaseTest(WebDriver driver) {
		if(driver == null) {
			BaseTest.driver = driver;
		}
		return driver;
	}
	
	
	public void openBrowser(String bType) {	

		//System.out.println(prop.getProperty("appurl"));
		if(bType.equals("Mozilla")) {
			driver = new FirefoxDriver();
		}else if(bType.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver_exe"));
			driver = new ChromeDriver();
		}else if(bType.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","path of chromedriver");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void navigate(String url) {
		driver.get(url);
	}

	/*public void click(String locatorKey) {
		getElement(locatorKey).click();
		
	}*/
	
	public void click(By locatorKey) {
		//getElement(locatorKey).click();
		driver.findElement(locatorKey).click();
		
	}

	public void type(By locatorKey, String data) {
		//getElement(locatorKey).sendKeys(data);
		driver.findElement(locatorKey).clear();
		driver.findElement(locatorKey).sendKeys(data);
	}
	
	public void selectValueFromDropdown(By dropdownSelector, By variationSelectors, String data) {
	click(dropdownSelector);
	List<WebElement> allSelectors = driver.findElements(variationSelectors);
	for (WebElement selector : allSelectors) {
	    if (selector.getText().trim().equalsIgnoreCase(data)) {
	    	selector.click();
	        break;
	    }
	  }
	}
	
	public void hoverAndClick(By hoverLocator, By clickLocator, String data) {
	Actions builder = new Actions(driver);
	WebElement hl = driver.findElement(hoverLocator);
	if(driver.findElement(clickLocator).getText().trim().equalsIgnoreCase(data))
	builder.moveToElement(hl).build().perform();
	List<WebElement> subLinks = driver.findElements(clickLocator);
	for(int i=0;i<subLinks.size();i++) {
		click(clickLocator);
	}
   }

	public WebElement getElement(String locatorKey) {
		WebElement e = null;
		try {
			if(locatorKey.endsWith("_id")) 
				e = driver.findElement(By.id(prop.getProperty(locatorKey)));
			else if(locatorKey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else if(locatorKey.endsWith("_name"))
				e =driver.findElement(By.name(prop.getProperty(locatorKey)));

			else {
				reportFailure("Locator not correct -" + locatorKey);
				//Assert.fail("Locator not correct - " + locatorKey);
			}

		}catch(Exception ex) {
			//fail the test and report the error
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			//Assert.fail("failed the test "+ ex.getMessage());
		}
		return e;
	}

	public void selectByVisibleText(By locator, String value) throws IOException {
		try {
			Select sc = new Select(driver.findElement(locator));
			sc.selectByVisibleText(value);
			//log.info("SelectByVisibleText", "Successfully selected value :- " + value + " from :- " + locatorName);
		} catch (Exception e) {
			//log.error("SelectByVisibleText", "Unable to select value :- " + value + " from :- " + locatorName);
		}
	}
	
	
	/******************************************Validations******************************************************/

	
	public boolean isElementDisplayed(final By locator) {
		return isElementPresented(locator) ? driver.findElement(locator).isDisplayed():false;
	}
	
	
	public boolean isElementPresented(final By locator) {
		return !driver.findElements(locator).isEmpty();
	}
	


	public boolean verifyTitle() {
		return false;
	}

	public boolean isElementPresent(String locatorKey) {
		List<WebElement> elementList= null;
		if(locatorKey.endsWith("_id")) 
			elementList = driver.findElements(By.id(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			elementList = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			elementList =driver.findElements(By.name(prop.getProperty(locatorKey)));

		else {
			reportFailure("Locator not correct -" + locatorKey);
		//	Assert.fail("Locator not correct - " + locatorKey);
		}

		if(elementList.size()==0)
			return false;
		else
			return true;

	}
	
	public void verifyText(By locator, String data) {
		String actualText = driver.findElement(locator).getText().trim();
		if(actualText.equalsIgnoreCase(data));
		System.out.println("The page group for- " + actualText + " was succefully verified");
	}
	

//	public boolean verifyText(String locatorKey,String expectedText) {
//
//		String actualText = getElement(locatorKey).getText();
//		/*expectedText = ;
//		System.out.println("expectedText "+expectedText);*/
//		if(actualText.equals(prop.getProperty(expectedText))) {
//			return true;
//		}else {
//			return false;
//		
//		}
//	}

	/********************************************Reporting*********************************************************/
	public void reportPass(String msg) {
		//test.log(LogStatus.PASS, msg);
	}

	public void reportFailure(String msg) {
		//test.log(LogStatus.FAIL,msg);
		takeScreenshot();
		//Assert.fail();
	}

	public void takeScreenshot() {
		//FileName of the screenshot
		Date d =new Date();
		String screenshotFile=d.toString().replace(":","_").replace(" ","_")+".png";
		System.out.println("Date "+screenshotFile);
		//Store screenshot in that file
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//screenShot//"+screenshotFile));
		}catch(Exception e) {
			e.printStackTrace();
		}

		//put screenshot file in reports
		//test.log(LogStatus.INFO,"Screenshot-> "+test.addScreenCapture(System.getProperty("user.dir")+"//screenShot//"+screenshotFile));
	}

}
