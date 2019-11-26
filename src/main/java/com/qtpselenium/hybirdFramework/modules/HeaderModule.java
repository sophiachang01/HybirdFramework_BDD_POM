package com.qtpselenium.hybirdFramework.modules;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.HeaderPage;
import webDriverModule.WebConnector;

public class HeaderModule  extends WebConnector {
	
	HeaderPage headerPage;
	WebDriver webDriver;
	ExtentTest scenario;
	
	public HeaderModule(WebDriver webDriver,ExtentTest scenario) {
		super(webDriver,scenario);
		headerPage = new HeaderPage(webDriver,scenario);
	}
	
	public void searchForProduct(String productName) {
		headerPage.searchForProduct(productName);
	}
	
	public void hoverLink(String categoryNameLink) throws InterruptedException {
		headerPage.hoverLink(categoryNameLink);
	}
	
	public void clickLinks() throws InterruptedException {
		headerPage.clickLinks();
	}
}
