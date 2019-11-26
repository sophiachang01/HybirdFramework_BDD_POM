package webDriverModule;

import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalCapabilities extends BasicCapabilities {

	public LocalCapabilities(String browser) {
		super(browser);
		this.capabilities = setBasicCapabilities(capabilities);
		this.capabilities = setPlatform(capabilities, "WINDOWS");
		this.capabilities = setBrowser(capabilities, browser);

	}

	public LocalCapabilities(String browser, String browserVersion, String platformOS) {
		this(browser);
		this.capabilities = setPlatform(this.capabilities, platformOS);
	}

	public DesiredCapabilities setBasicCapabilities(DesiredCapabilities capabilities) {
		capabilities.setCapability("acceptSslCerts", "true");
		return capabilities;
	}

	public DesiredCapabilities setPlatform(DesiredCapabilities capabilities, String platformOS) {
		capabilities.setCapability("os", platformOS);
		return capabilities;
	}

	public DesiredCapabilities setBrowser(DesiredCapabilities capabilities, String browser) {
		capabilities.setCapability("browser", browser);
		return capabilities;
	}

}
