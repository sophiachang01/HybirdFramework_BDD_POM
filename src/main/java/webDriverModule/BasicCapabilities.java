package webDriverModule;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasicCapabilities {

	private static final Map<String, DesiredCapabilities> DRIVERS;

	static {
		DRIVERS = new HashMap<>();
		DRIVERS.put("IE", DesiredCapabilities.internetExplorer());
		DRIVERS.put("firefox", DesiredCapabilities.firefox());
		DRIVERS.put("chrome", DesiredCapabilities.chrome());
		DRIVERS.put("Edge", DesiredCapabilities.edge());
		DRIVERS.put("safari", DesiredCapabilities.safari());
	}

	DesiredCapabilities capabilities;

	public BasicCapabilities(String browser) {
		this.capabilities = new DesiredCapabilities(DRIVERS.get(browser));
		this.capabilities = configureCapabilities(capabilities);
		// this.capabilities = new DesiredCapabilities(DRIVERS.get(isMobile));
	}

	public DesiredCapabilities getCapabilities() {
		return this.capabilities;
	}

	private DesiredCapabilities configureCapabilities(DesiredCapabilities basicCapabilities) {
		DesiredCapabilities advancedCapabilities = basicCapabilities;
		String browserName = advancedCapabilities.getBrowserName();
		switch (browserName) {
		case "firefox":
			advancedCapabilities = configureFirefox(advancedCapabilities);
			break;
		case "chrome":
			advancedCapabilities = configureChrome(advancedCapabilities);
			break;
		case "MicrosoftEdge":
			advancedCapabilities = configureEdge(advancedCapabilities);
			break;
		default:
			advancedCapabilities = configureChrome(advancedCapabilities);

		}
		return advancedCapabilities;
	}

	private DesiredCapabilities configureEdge(DesiredCapabilities edge) {
		EdgeOptions options = new EdgeOptions();
		options.setCapability("acceptInsecureCerts", true);
		return edge;
	}

	private DesiredCapabilities configureFirefox(DesiredCapabilities firefox) {
		firefox.setCapability("acceptInsecureCerts", true);
		return firefox;
	}

	private DesiredCapabilities configureChrome(DesiredCapabilities chrome) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("ignore-certificate-errors");

		if (Boolean.valueOf(System.getProperty("chromeHeadless"))) {
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
		}

		options.setCapability("goog:loggingPrefs", WebDriverInstance.getLogPreference());
		chrome.setCapability(ChromeOptions.CAPABILITY, options);
		return chrome;
	}

}
