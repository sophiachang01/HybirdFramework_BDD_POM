package com.qtpselenium.hybirdFramework.modules;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.HomePage;
import webDriverModule.WebConnector;

public class GeneralModule{

	HomePage homePage = null;
	
	public GeneralModule(WebDriver webDriver,ExtentTest scenario) {
		//super(webDriver,scenario);
		homePage = new HomePage(webDriver,scenario);
	}

	public void openHomePage(String URL) {
		System.out.println("GeneralModule " + URL);
		homePage.openHomePage(URL);
	}

}
