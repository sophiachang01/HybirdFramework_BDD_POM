package com.qtpselenium.hybirdFramework.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import webDriverModule.WebConnector;

public class AddressPage extends WebConnector {

	private By AddressTitle = By.xpath("//span[text()=' Address']");
	private By AddressSelector = By.cssSelector("[name='id_address_delivery']");
	private By AddressSelectorOption = By.cssSelector("[name='id_address_delivery'] option");
	private By CheckOutBnt = By.xpath("//span[text()='Proceed to checkout']");
	
	

	public AddressPage(WebDriver driver, ExtentTest scenario) {
		super(driver, scenario);
	}
	
	public boolean isAddressPageDispalyed() {
		try {
			waitForElementToBePresent(AddressTitle, 60);

		} catch (Exception e) {
			infoLog("Having issue to displaying the Element- AddressTitle, please verify");
		}
		return isElementDisplayed(AddressTitle);
	}
	
	public void the_user_choose_the_delivery_address(String deliveryaddress) {
	    selectValueFromDropdown(AddressSelector, AddressSelectorOption, deliveryaddress);
	}
	
}