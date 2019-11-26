package com.qtpselenium.hybirdFramework.pages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import objects.Forms;
import objects.UserData;
import webDriverModule.WebConnector;

public class DeliveryPage extends WebConnector {

	private By checkOutDeliveryPage = By.xpath("//span[text()='Addresses']");
	private By LOCATOR_SHIPPINGPAGE_FIRSTNAME_FIELD = By.cssSelector("[id='firstname']");
	private By LOCATOR_SHIPPINGPAGE_LASTNAME_FIELD = By.cssSelector("[id='lastname']");
	private By LOCATOR_SHIPPINGPAGE_COMPANY_FIELD = By.cssSelector("[id='company']");
	private By LOCATOR_SHIPPINGPAGE_ADDRESS_FIELD = By.cssSelector("[id='address1']");
	private By LOCATOR_SHIPPINGPAGE_CITY_FIELD = By.cssSelector("[id='city']");
	private By LOCATOR_SHIPPINGPAGE_STATE_DROPDOWN = By.cssSelector("[id='id_state']");
	private By LOCATOR_SHIPPINGPAGE_STATE_DROPDOWN_VALUE = By.cssSelector("select[id='id_state'] option");
	private By LOCATOR_SHIPPINGPAGE_ZIPCODE_FIELD = By.cssSelector("[id='postcode']");
	private By LOCATOR_SHIPPINGPAGE_COUNTRY_DROPDOWN = By.cssSelector("[id='id_country']");
	private By LOCATOR_SHIPPINGPAGE_COUNTRY_DROPDOWN_VALUE = By.cssSelector("select[id='id_country'] option");
	private By LOCATOR_SHIPPINGPAGE_MOBILE_FIELD = By.cssSelector("[id='phone_mobile']");
	private By LOCATOR_SHIPPINGPAGE_SAVE_BUTTON = By.cssSelector("[id=submitAddress]");
	private By LOCATOR_SHIPPINGPAGE_ADDRESSALIAS_FIELD = By.cssSelector("[id='alias']");
	private By LOCATOR_SHIPPINGPAGE_ADDNEWADDRESS_BUTTON = By.xpath("//span[text()='Add a new address']");

	public DeliveryPage(WebDriver driver, ExtentTest scenario) {
		super(driver, scenario);
		// TODO Auto-generated constructor stub
	}

	public boolean assertDeliveryPage() {
		return waitForElementToBePresent(checkOutDeliveryPage, 60);
	}

	
	public void addNewAddress() {
		click(LOCATOR_SHIPPINGPAGE_ADDNEWADDRESS_BUTTON);
	}
	
	
	public void fillDeliveryDetails(UserData user, Forms forms) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DeliveryPage r = new DeliveryPage(driver, scenario);
		String[] allField = forms.getFields().split(",", -1);
		String[] allTypes = forms.getFieldsType().split(",", -1);
		for (int i = 0; i < allField.length; i++) {
			try {
				Method method = r.getClass().getMethod(allField[i], UserData.class, String.class);
				method.invoke(r, user, allTypes[i]);
			} catch (InvocationTargetException e) {
				System.out.println("Level.Warning " + "Method with name: " + allField[i] + "Cannot be invoked");
				throw e;
			} catch (NoSuchElementException e) {
				System.out.println("Level.Warning " + "Method with name: " + allField[i] + "Not implemented");
				throw e;
			}
		}
	}
	
	public void firstName(UserData user, String type) {
		clearAndType(LOCATOR_SHIPPINGPAGE_FIRSTNAME_FIELD, user.getFirstName());

	}

	public void lastName(UserData user, String type) {
		clearAndType(LOCATOR_SHIPPINGPAGE_LASTNAME_FIELD, user.getLastName());
	}
	

	public void company(UserData user, String type) {
		clearAndType(LOCATOR_SHIPPINGPAGE_COMPANY_FIELD, user.getCompany());
	}

	public void address(UserData user, String type) {
		type(LOCATOR_SHIPPINGPAGE_ADDRESS_FIELD, user.getAddress());
	}

	public void city(UserData user, String type) {
		type(LOCATOR_SHIPPINGPAGE_CITY_FIELD, user.getCity());
	}

	public void state(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_SHIPPINGPAGE_STATE_DROPDOWN, LOCATOR_SHIPPINGPAGE_STATE_DROPDOWN_VALUE,
				user.getState());
	}

	public void zipCode(UserData user, String type) {
		type(LOCATOR_SHIPPINGPAGE_ZIPCODE_FIELD, user.getZipCode());
	}

	public void country(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_SHIPPINGPAGE_COUNTRY_DROPDOWN, LOCATOR_SHIPPINGPAGE_COUNTRY_DROPDOWN_VALUE,
				user.getCountry());
	}

	public void mobile(UserData user, String type) {
		type(LOCATOR_SHIPPINGPAGE_MOBILE_FIELD, user.getMobile());
	}
	
	public void  addressAlias(UserData user, String type) {
		clearAndType(LOCATOR_SHIPPINGPAGE_ADDRESSALIAS_FIELD, user.getAddressAlias());
	}
	public void submit() {
		click(LOCATOR_SHIPPINGPAGE_SAVE_BUTTON);
	}
}
