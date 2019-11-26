package webDriverModule;

import org.openqa.selenium.remote.DesiredCapabilities;

import webDriverModule.BasicCapabilities;

public class BrowserStackCapabilities extends BasicCapabilities {

	public static final String NETWORKING = System.getProperty("networkLogs", "true");

	public BrowserStackCapabilities(String browser, String browserVersion) {
		super(browser);
		this.capabilities = setBasicCapabilities(capabilities);
		this.capabilities = setPlatform(capabilities, "WINDOWS", "10.0");
		this.capabilities = setBrowser(capabilities, browser, browserVersion);
		//this.capabilities = setResoultion(capabilities, "1920*1080");

	}

	public BrowserStackCapabilities(String browser,String browserVersion,String platformOS, String platformVersion) {
		this(browser,browserVersion);
		this.capabilities = setPlatform(this.capabilities, platformOS, platformVersion);
	}
	
	public DesiredCapabilities setBasicCapabilities(DesiredCapabilities capabilities) {
		capabilities.setCapability("browserstack.debug", "true");
		capabilities.setCapability("acceptSslCerts", "true");
		capabilities.setCapability("browserstack.autoWait", 0);
		if (NETWORKING.equals("true")) {
			capabilities.setCapability("browserstack.networkLogs", "true");
		} else {
			capabilities.setCapability("browserstack.networkLogs", "false");
		}
		return capabilities;
	}

	public DesiredCapabilities setPlatform(DesiredCapabilities capabilities, String platformOS,
			String platformVersion) {
		capabilities.setCapability("os", platformOS);
		capabilities.setCapability("osVersion", platformVersion);
		return capabilities;
	}

	public DesiredCapabilities setBrowser(DesiredCapabilities capabilities, String browser, String browserVersion) {
		capabilities.setCapability("browser", browser);
		capabilities.setCapability("browser_version", browserVersion);
		return capabilities;
	}

	public DesiredCapabilities setResoultion(DesiredCapabilities capabilites, String resolution) {
		capabilities.setCapability("resolution", resolution);
		return capabilites;
	}

}
