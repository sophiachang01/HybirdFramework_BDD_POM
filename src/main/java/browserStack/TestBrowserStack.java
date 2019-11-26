package browserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBrowserStack {

	
	
	//static String URL = "https://qtpselenium1:5pUxNdYUrsszJxM7oswN@hub-cloud.browserstack.com/wd/hub";
	static String URL = "https://qatester136:X1z2WXBKNG1uV6wPsjU9@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "11");
		caps.setCapability("device", "iPhone 8 Plus");
		caps.setCapability("real_mobile", "true");
		caps.setCapability("browserstack.local", "false");
		
		
	WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	
	driver.get("http://automationpractice.com/index.php");
	//driver.findElement(By.name("q")).sendKeys("Selenium webdriver");
	driver.findElement(By.cssSelector("[id='search_query_top']")).sendKeys("Selenium WebDriver");
	Thread.sleep(5000);
	
	driver.quit();
	}
}
