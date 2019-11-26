package com.qtpselenium.hybridFramework.glue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.PaymentModule;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentSteps {
	
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;
	PaymentModule paymentModule;
	
	public PaymentSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		paymentModule = new PaymentModule(webDriver,scenario);
	}
	
	@Then("^The Payment page is displayed$")
    public void the_payment_page_is_displayed() {
        paymentModule.the_payment_page_is_displayed();
    }
	
	@When("^The user choose the payment method as \"([^\"]*)\"$")
    public void the_user_choose_the_payment_method(String paymentmethod) {
        paymentModule.the_user_choose_the_payment_method(paymentmethod);
    }

}
