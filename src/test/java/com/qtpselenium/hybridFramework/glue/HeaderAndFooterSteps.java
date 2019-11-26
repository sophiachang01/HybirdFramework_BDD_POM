package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.HeaderModule;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HeaderAndFooterSteps {

	HeaderModule headerModule;
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;

	public HeaderAndFooterSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		headerModule = new HeaderModule(webDriver,scenario);
	}

	@When("^The user searches for the product \"([^\"]*)\"$")
	public void theUserSearchesForTheProduct(String productName) {
		headerModule.searchForProduct(productName);
	}

	@When("^The guest user hovers above the link \"([^\"]*)\"$")
	public void The_guest_user_hovers_above_the_link(String categoryNameLink) throws InterruptedException {
		headerModule.hoverLink(categoryNameLink);
	}

	@Then("^The user clicks the sublinks and the Names of the categories are displayed$")
	public void the_user_clicks_the_sublinks_and_the_names_of_the_categories_are_displayed() throws InterruptedException {
		headerModule.clickLinks();
	}
}
