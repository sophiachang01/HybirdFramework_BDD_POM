package com.qtpselenium.hybirdFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import webDriverModule.WebConnector;

public class ShippingPage extends WebConnector{
	
	private By ServiceTermCheckbox = By.cssSelector("[id='cgv']");
	
	public ShippingPage(WebDriver driver, ExtentTest scenario) {
		super(driver, scenario);
	}
	
	public void the_shipping_page_is_displayed() {
		clickTheServiceTermCheckbox();
	}
	
    public void clickTheServiceTermCheckbox() {
    	click(ServiceTermCheckbox);
    }

}
