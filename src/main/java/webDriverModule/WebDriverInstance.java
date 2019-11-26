package webDriverModule;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import reports.ExtentManager;

public class WebDriverInstance {

	public static final Logger LOGGER = Logger.getLogger(WebDriverInstance.class.getName());
	protected WebDriver driver;
	public ExtentReports rep;
	public ExtentTest scenario;
	public static String reportPath = "C:\\CucucmberReport\\";
	String platform = "";
	String platformVersion = "";
	String browserVersion = "";

	public void startSelenium(String browser, String url, boolean browserStack) throws MalformedURLException {
		DesiredCapabilities capabilities = null;
		if (browserStack) {
			capabilities = new BrowserStackCapabilities(browser, browserVersion, platform, platformVersion)
					.getCapabilities();
			capabilities.setCapability("project", "AutomationPractice");
			capabilities.setCapability("build", "Regression_001");
			capabilities.setCapability("name", "Regression");
		} else {
			capabilities = new LocalCapabilities(browser).getCapabilities();

		}
		createDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public WebDriver createDriver(String url, DesiredCapabilities caps) throws MalformedURLException {
		caps.setCapability(CapabilityType.LOGGING_PREFS, getLogPreference());
		this.driver = new RemoteWebDriver(new URL(url), caps);
		this.driver.manage().timeouts().setScriptTimeout(180, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		return driver;
	}

	public static LoggingPreferences getLogPreference() {
		LOGGER.log(Level.INFO, "Trying to enable logging prefs");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
		LOGGER.log(Level.INFO, "Logging preferences enabled");
		return logPrefs;

	}

	public void initReports(String scenarioName) {
		rep = ExtentManager.getInstance(reportPath);
		scenario = rep.createTest(scenarioName);
		scenario.log(Status.INFO, scenarioName);
	}

	public void quit() {
		rep.flush();
	}

	public void infoLog(String msg) {
		scenario.log(Status.INFO, msg);
	}
	
	private void callStopSelenium() {
		if(driver !=null) {
			driver.quit();
			driver = null;
		}
	}
	
	public void stopSelenium() {
		try {
			callStopSelenium();
		}catch(Exception e){
			infoLog("Could not stop selenium.");
			throw e;
		}
	}
}
