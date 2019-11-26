package com.qtpselenium.hybirdFramework.modules;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.ProductPage;

public class ProductModule{

	ProductPage productPage;
	WebDriver webDriver;

	public ProductModule(WebDriver webDriver,ExtentTest scenario) {
		//super(webDriver);
		productPage = new ProductPage(webDriver,scenario);
	}
	
	public void assertProductDetailsPage(String productName) {
		productPage.assertProductDetailsPage(productName);
	}
	
	
	public void theUserChooseTheProductSizeAsAndQuantityAsAndColor(String productSize,String productQuantity,String productColor) {
		productPage.theUserChooseTheProductSizeAsAndQuantityAsAndColor(productSize, productQuantity, productColor);
	}
	
	public void fromPDPAddToBag() {
		addToBag();
	}
	
	public void addToBag() {
		productPage.addToBagButton().click();
	}
	
	public void fromBagOverLayToCart() {
		goToCart();
	}
	
	public void goToCart() {
		productPage.proceedToCart();
	}
}
