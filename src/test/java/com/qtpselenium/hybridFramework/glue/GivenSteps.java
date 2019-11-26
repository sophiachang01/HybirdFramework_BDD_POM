package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qtpselenium.hybirdFramework.modules.GeneralModule;


import cucumber.api.java.en.Given;

public class GivenSteps {

	GeneralModule generalModule;
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;

	
	public GivenSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();		
		generalModule = new GeneralModule(webDriver,scenario);
	}

	@Given("^The guest user Launches the application URL \"([^\"]*)\"$")
	public void theGuestUserLaunchesTheApplication(String URL) {
		generalModule.openHomePage(URL);
	}

}
