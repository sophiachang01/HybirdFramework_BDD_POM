package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.ProductModule;

import cucumber.api.java.en.When;

public class ProductSteps {

	ProductModule productModule;
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;

	public ProductSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		productModule = new ProductModule(webDriver, scenario);
	}

	@When("^The Product page for product \"([^\"]*)\" is displayed$")
	public void theProductPageForProductIsDisplayed(String productName) {
		productModule.assertProductDetailsPage(productName);
	}

	@When("^The user choose the product size as \"([^\"]*)\" and quantity as \"([^\"]*)\" and Color as \"([^\"]*)\"$")
	public void theUserChooseTheProductSizeAsAndQuantityAsAndColor(String productSize, String productQuantity,
			String productColor) {
		productModule.theUserChooseTheProductSizeAsAndQuantityAsAndColor(productSize, productQuantity, productColor);
	}
	
	@When("^User selects Add to bag$")
	public void userSelectsAddTobag() {
		productModule.fromPDPAddToBag();
	}

	@When("^User selects View bag$")
	public void andViewBag() {
		productModule.fromBagOverLayToCart();
	}
	

}
