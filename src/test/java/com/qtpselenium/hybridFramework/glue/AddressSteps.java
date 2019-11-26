package com.qtpselenium.hybridFramework.glue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.AddressModule;
import com.qtpselenium.hybirdFramework.modules.CartModule;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddressSteps {

	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;
	AddressModule addressModule;

	public AddressSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		addressModule = new AddressModule(webDriver, scenario);
	}

	@Then("^The Address page is displayed$")
	public void the_address_page_is_displayed() {
		addressModule.assertAddressPageIsDisplayed();
	}

	@When("^The user choose the delivery address as \"([^\"]*)\"$")
	public void the_user_choose_the_delivery_address_as_something(String deliveryaddress) {
		addressModule.the_user_choose_the_delivery_address(deliveryaddress);
	}
	
}
