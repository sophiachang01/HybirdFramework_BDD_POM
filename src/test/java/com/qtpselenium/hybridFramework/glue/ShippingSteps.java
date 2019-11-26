package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.ShippingModule;

import cucumber.api.java.en.Then;

public class ShippingSteps {

	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;
	ShippingModule shippingModule;
	
	public ShippingSteps (Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		shippingModule = new ShippingModule(webDriver,scenario);
	}
	
	@Then("^The Shipping page is displayed$")
    public void the_shipping_page_is_displayed() {
		shippingModule.the_shipping_page_is_displayed();
	}
	 
}
