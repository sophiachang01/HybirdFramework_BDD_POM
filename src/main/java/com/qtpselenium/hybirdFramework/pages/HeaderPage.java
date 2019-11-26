package com.qtpselenium.hybirdFramework.pages;

import static org.testng.Assert.assertTrue;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import webDriverModule.WebConnector;

public class HeaderPage extends WebConnector {

	private By LOCATOR_SEARCH_BOX = By.cssSelector("[id='search_query_top']");
	private By LOCATOR_SEARCH_SUBMIT_BUTTON = By.cssSelector("[name='submit_search']");
	private By subsLinksCount = By.xpath("(//ul[@class='submenu-container clearfix first-in-line-xs'])[2]//a");
	private By dressesLink = By.xpath("(//a[@class='sf-with-ul' and text()='Dresses'])[2]");
	private By womanLink = By.xpath("//a[@class='sf-with-ul' and text()='Women']");

	Actions builder = new Actions(driver);

	public HeaderPage(WebDriver webDriver,ExtentTest scenario) {
		super(webDriver,scenario);
	}

	public void searchForProduct(String productName) {
        type(LOCATOR_SEARCH_BOX, productName);
		click(LOCATOR_SEARCH_SUBMIT_BUTTON);
	}

	public void hoverLink(String categoryNameLink) throws InterruptedException {

		if (categoryNameLink.equalsIgnoreCase("dresses")) {
			// Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(dressesLink)).build().perform();
			Thread.sleep(2000);
		} else if (categoryNameLink.equalsIgnoreCase("woman")) {
			// Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(womanLink)).build().perform();
			Thread.sleep(2000);
		}
		
	}
	
	public void clickLinks() throws InterruptedException {

		List<WebElement> subLinks = driver.findElements(subsLinksCount);
		System.out.println("Number of the links present is " + subLinks.size());

		for (int i = 0; i < subLinks.size(); i++) {

			builder.moveToElement(driver.findElement(dressesLink)).build().perform();
			Thread.sleep(2000);
			// define one more time to avoid StaleElementReferenceException
			subLinks = driver.findElements(subsLinksCount);
			String subLinkText = subLinks.get(i).getText();
			subLinks.get(i).click();
			Thread.sleep(2000);
			String categoryName = driver.findElement(By.xpath("//span[@class='category-name']")).getText().toString();
			assertTrue(subLinkText.equalsIgnoreCase(categoryName), "Category is not load, please verify");
			System.out.println(driver.getCurrentUrl());
		}
	}
}
