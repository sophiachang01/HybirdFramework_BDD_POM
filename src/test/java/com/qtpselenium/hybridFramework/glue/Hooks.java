package com.qtpselenium.hybridFramework.glue;

import java.net.MalformedURLException;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import webDriverModule.WebDriverInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends WebDriverInstance {

	private static final String SYSTEM_BROWSER_PROPERTY = "browser";
	private static final String SYSTEM_SELENIUM_HUB_URL_PROPERTY = "seleniumHub";
	private static final String DEFAULT_BROWSER = "chrome";
	private static final String IS_BROWSERSTACK = "browserstack";
	private boolean browserstack;

	public void browserIntialization() throws MalformedURLException {
		String browser = System.getProperty(SYSTEM_BROWSER_PROPERTY);
		String url = System.getProperty(SYSTEM_SELENIUM_HUB_URL_PROPERTY);
		this.browserstack = Boolean.parseBoolean(System.getProperty(IS_BROWSERSTACK));
		if (null == browser) {
			browser = DEFAULT_BROWSER;
		}
		startSelenium(browser, url,browserstack);
		infoLog("Opening Browser " + browser);

	}

	@Before
	public void openBrowser(Scenario s) throws MalformedURLException {
		LOGGER.log(Level.INFO, "Before " + s.getName());
		initReports(s.getName());
		browserIntialization();

	}

	public WebDriver getDriver() {
		return driver;
	}

	@After
	public void after() {
		System.out.println("After");
		quit();
		closeBrowser();

	}

	public ExtentTest getReport() {
		return scenario;
	}
	
	
	public void closeBrowser() {
		stopSelenium();
	}

}
