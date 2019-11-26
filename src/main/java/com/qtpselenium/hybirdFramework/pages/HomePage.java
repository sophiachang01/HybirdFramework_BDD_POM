package com.qtpselenium.hybirdFramework.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import webDriverModule.WebConnector;

public class HomePage extends WebConnector {

	

	public HomePage(WebDriver webDriver,ExtentTest scenario) {
		super(webDriver,scenario);
	}

	public void openHomePage(String URL) {
		System.out.println("HomePage " + URL);
		//openBrowser("Chrome");
				navigate(URL);
	}

}
