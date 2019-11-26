package com.qtpselenium.hybirdFramework.modules;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import objects.Forms;
import objects.UserData;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.RegistrationPage;
import webDriverModule.WebConnector;


public class RegistrationModule extends WebConnector{

	RegistrationPage registrationPage;
	WebDriver webDriver;
	ExtentTest scenario;

	public RegistrationModule(WebDriver webDriver,ExtentTest scenario) {
		super(webDriver,scenario);
		registrationPage = new RegistrationPage(webDriver,scenario);
	}

	public void goToRegisterPage(String strValue) {
		registrationPage.goToRegisterPage();
		registrationPage.navigatoToRegistrationForm(strValue);
	}

	public void enterRegistrationDetails(UserData user, Forms form) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		registrationPage.register(user, form);
		registrationPage.submitRegisterationForm();
	}
	
	//generate one email id at one iteration
	public String generateUserEmail() {
		return System.currentTimeMillis()+"@qaSelenium.com";
	}
	
	public void verifyRegistrationAccount() {
		registrationPage.submitRegisterationForm();
	}
}
