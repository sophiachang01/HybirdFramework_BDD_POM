package com.qtpselenium.hybridFramework.glue;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.CartModule;
import com.qtpselenium.hybirdFramework.modules.DeliveryModule;
import objects.UserData;
import froms.ShippingForm;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeliverySteps {

	DeliveryModule deliveryModule;
	private Hooks hook;
	private WebDriver webDriver;
	ShippingForm shippingForm;
	UserData deliveryData;
	private ExtentTest scenario;

	public DeliverySteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		shippingForm = new ShippingForm();
		deliveryModule = new DeliveryModule(webDriver, scenario);
	}
	
	
	@Then("^The delivery page is displayed to the user$")
	public void theDeliveryPageIsDisplayedToTheUser() {
		deliveryModule.assertDeliveryPage();
	}
	
	@When("^The user enters the delivery details \"([^\"]*)\"$")
	public void theUserEntersTheDeliveryDetails(String input) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		deliveryData = new UserData(input, shippingForm.getForm("global"));
		deliveryModule.fillDeliveryDetails(deliveryData,shippingForm.getForm("global"));
		
		
	}
}
