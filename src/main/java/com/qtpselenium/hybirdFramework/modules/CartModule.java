package com.qtpselenium.hybirdFramework.modules;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.CartPage;

public class CartModule {

	
	public CartPage cartPage;
	
	public CartModule(WebDriver webDriver, ExtentTest scenario) {
		cartPage = new CartPage(webDriver,scenario);
	}

	
	public void assertCartShowPageIsDisplayed() {
		assertTrue(cartPage.isCartShowPageDisplayed(),"The Cart Page is not shown");
	}
	
	public void assertProductIdIsShow(String id) {
		assertTrue(cartPage.isProductIdShow(id),"The Product with ID : "+ id + "is not shown on Cart Page");
	}
	
	
	public void goToDeliveryFromCart() {
		cartPage.clickCheckOutOnCartPage();
	}
	
	
}
