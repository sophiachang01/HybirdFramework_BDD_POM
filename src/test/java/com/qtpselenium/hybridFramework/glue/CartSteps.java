package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.CartModule;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSteps {

	
	CartModule cartModule;
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;

	public CartSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		cartModule = new CartModule(webDriver, scenario);
	}
	
	@Then("^The Cart page is displayed$")
	public void theCarPageIsDisplayed() {
		cartModule.assertCartShowPageIsDisplayed();
	}
	
	@Then("^Product \"([^\"]*)\" is displayed in cartPage$")
	public void productIsDisplayedInCartPage(String productId) {
		cartModule.assertProductIdIsShow(productId);
	}
	
	@When("^The user clicks on the Checkout Button$")
	public void theUserClicksOnTheCheckOutButton() {
		cartModule.goToDeliveryFromCart();	
	}
}
