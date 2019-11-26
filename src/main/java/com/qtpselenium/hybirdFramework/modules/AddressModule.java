package com.qtpselenium.hybirdFramework.modules;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.AddressPage;

public class AddressModule {
	
	public AddressPage addressPage;
	
	public AddressModule(WebDriver webDriver, ExtentTest scenario) {
		addressPage = new AddressPage(webDriver, scenario);
	}
	
	public void assertAddressPageIsDisplayed() {
		assertTrue(addressPage.isAddressPageDispalyed(), "The Address Page is not shown");
	}
	
	public void the_user_choose_the_delivery_address(String deliveryaddress) {
	    addressPage.the_user_choose_the_delivery_address(deliveryaddress); 
	}

}
