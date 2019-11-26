package com.qtpselenium.hybridFramework.glue;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.modules.RegistrationModule;
import objects.UserData;
import froms.RegisterForm;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {

	RegistrationModule registrationModule;
	RegisterForm registerForm;
	private UserData user;
	private Hooks hook;
	private WebDriver webDriver;
	private ExtentTest scenario;



	public RegistrationSteps(Hooks hook) {
		this.hook = hook;
		this.webDriver = hook.getDriver();
		this.scenario = hook.getReport();
		registrationModule = new RegistrationModule(webDriver,scenario);
		registerForm = new RegisterForm();
	}

	@When("^The user goes on Registration page, enter registration details as \"([^\"]*)\" on \"([^\"]*)\"$")
	public void theUserEnterRegistrationDetailsAs(String registrationDetails, String Market)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		user = new UserData(registrationDetails, registerForm.getForm(Market));
		String email = registrationModule.generateUserEmail();
		user.setEmail(email);
		registrationModule.goToRegisterPage(user.getEmail());
		registrationModule.enterRegistrationDetails(user, registerForm.getForm(Market));
	}
	
	
	@Then("^The user verify has registered with application$")
	public void verifyRegistrationAccount() {
		registrationModule.verifyRegistrationAccount();
	}

}
