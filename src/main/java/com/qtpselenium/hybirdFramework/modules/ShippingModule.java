package com.qtpselenium.hybirdFramework.modules;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.ShippingPage;

public class ShippingModule {
	
	public ShippingPage shippingPage;
	
	public ShippingModule(WebDriver webDriver, ExtentTest scenario) {
		shippingPage = new ShippingPage(webDriver,scenario);
	}
    
	public void the_shipping_page_is_displayed() {
	    shippingPage.the_shipping_page_is_displayed();
	}
}
