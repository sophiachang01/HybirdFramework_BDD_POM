package com.qtpselenium.hybirdFramework.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import objects.Forms;
import objects.UserData;
import webDriverModule.WebConnector;

public class RegistrationPage extends WebConnector {

	private By login_links = By.cssSelector("a[class='login']");
	private By Email_Field = By.cssSelector("input[id='email_create']");
	private By Create_an_account = By.cssSelector("i[class='icon-user left']");
	private By LOCATOR_REGISTRATION_FROM_TITLE_MRS_FIELD = By.cssSelector("[id='id_gender2']");
	private By LOCATOR_REGISTRATION_FROM_TITLE_MR_FIELD = By.cssSelector("[id='id_gender1']");
	private By LOCATOR_REGISTRATION_FIRSTNAME_FIELD = By.cssSelector("[id='customer_firstname']");
	private By LOCATOR_REGISTRATION_LASTNAME_FIELD = By.cssSelector("[id='customer_lastname']");
	private By LOCATOR_REGISTRATION_EMAIL_FIELD = By.cssSelector("[id='email']");
	private By LOCATOR_REGISTRATION_PASSWORD_FIELD = By.cssSelector("[id='passwd']");
	private By LOCATOR_REGISTRATION_DAYS_DROPDOWN = By.cssSelector("[id='days']");
	private By LOCATOR_REGISTRATION_DAYS_DROPDOWN_VALUE = By.cssSelector("select[id='days'] option");
	private By LOCATOR_REGISTRATION_MONTHS_DROPDOWN = By.cssSelector("[id='months']");
	private By LOCATOR_REGISTRATION_MONTHS_DROPDOWN_VALUE = By.cssSelector("select[id='months'] option");
	private By LOCATOR_REGISTRATION_YEARS_DROPDOWN = By.cssSelector("[id='years']");
	private By LOCATOR_REGISTRATION_YEARS_DROPDOWN_VALUE = By.cssSelector("select[id='years'] option");
	private By LOCATOR_REGISTRATION_FIRSTNAME_FIELD1 = By.cssSelector("[id='firstname']");
	private By LOCATOR_REGISTRATION_LASTNAME_FIELD1 = By.cssSelector("[id='lastname']");
	private By LOCATOR_REGISTRATION_COMPANY_FIELD = By.cssSelector("[id='company']");
	private By LOCATOR_REGISTRATION_ADDRESS_FIELD = By.cssSelector("[id='address1']");
	private By LOCATOR_REGISTRATION_CITY_FIELD = By.cssSelector("[id='city']");
	private By LOCATOR_REGISTRATION_STATE_DROPDOWN = By.cssSelector("[id='id_state']");
	private By LOCATOR_REGISTRATION_STATE_DROPDOWN_VALUE = By.cssSelector("select[id='id_state'] option");
	private By LOCATOR_REGISTRATION_ZIPCODE_FIELD = By.cssSelector("[id='postcode']");
	private By LOCATOR_REGISTRATION_COUNTRY_DROPDOWN = By.cssSelector("[id='id_country']");
	private By LOCATOR_REGISTRATION_COUNTRY_DROPDOWN_VALUE = By.cssSelector("select[id='id_country'] option");
	private By LOCATOR_REGISTRATION_MOBILE_FIELD = By.cssSelector("[id='phone_mobile']");
	private By LOCATOR_REGISTRATION_SUBBIMT_BNT = By.cssSelector("[id='submitAccount']");
	private By LOCATOR_REGISTRATION_MYACCOUNT_TEXT = By.cssSelector("[class='page-heading']");

	// public WebDriver webDriver;

	public RegistrationPage(WebDriver webDriver,ExtentTest scenario) {
		super(webDriver,scenario);
	}

	public void goToRegisterPage() {
		goToLoginPage();
	}

	public void goToLoginPage() {
		click(login_links);
	}

	public void navigatoToRegistrationForm(String strValue) {
		if (isElementDisplayed(Email_Field)) {
			type(Email_Field, strValue);
			click(Create_an_account);
		}
	}

	public void register(UserData user, Forms forms) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		RegistrationPage r = new RegistrationPage(driver,scenario);
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

	public void title(UserData user, String type) {
		switch (user.getTitle()) {
		case "mrs":
			click(LOCATOR_REGISTRATION_FROM_TITLE_MRS_FIELD);
			break;
		case "mr":
			click(LOCATOR_REGISTRATION_FROM_TITLE_MR_FIELD);
			break;

		}
	}

	public void firstName(UserData user, String type) {
		type(LOCATOR_REGISTRATION_FIRSTNAME_FIELD, user.getFirstName());

	}

	public void lastName(UserData user, String type) {
		type(LOCATOR_REGISTRATION_LASTNAME_FIELD, user.getLastName());
	}

	// default email is the email for sign in
	public void email(UserData user, String type) {
		type(LOCATOR_REGISTRATION_EMAIL_FIELD, user.getEmail());
	}

	public void password(UserData user, String type) {
		type(LOCATOR_REGISTRATION_PASSWORD_FIELD, user.getPassword());
	}

	public void day(UserData user, String type) throws IOException {
		selectValueFromDropdown(LOCATOR_REGISTRATION_DAYS_DROPDOWN, LOCATOR_REGISTRATION_DAYS_DROPDOWN_VALUE,
				user.getDay());
	}

	public void month(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_REGISTRATION_MONTHS_DROPDOWN, LOCATOR_REGISTRATION_MONTHS_DROPDOWN_VALUE,
				user.getMonth());
	}

	public void year(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_REGISTRATION_YEARS_DROPDOWN, LOCATOR_REGISTRATION_YEARS_DROPDOWN_VALUE,
				user.getYear());
	}

	/*
	 * public void firstName1(UserData user, String type) {
	 * type(LOCATOR_REGISTRATION_FIRSTNAME_FIELD1, user.getFirstName1());
	 * 
	 * }
	 * 
	 * public void lastName1(UserData user, String type) {
	 * type(LOCATOR_REGISTRATION_LASTNAME_FIELD1, user.getLastName1()); }
	 */

	public void company(UserData user, String type) {
		type(LOCATOR_REGISTRATION_COMPANY_FIELD, user.getCompany());
	}

	public void address(UserData user, String type) {
		type(LOCATOR_REGISTRATION_ADDRESS_FIELD, user.getAddress());
	}

	public void city(UserData user, String type) {
		type(LOCATOR_REGISTRATION_CITY_FIELD, user.getCity());
	}

	public void state(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_REGISTRATION_STATE_DROPDOWN, LOCATOR_REGISTRATION_STATE_DROPDOWN_VALUE,
				user.getState());
	}

	public void zipCode(UserData user, String type) {
		type(LOCATOR_REGISTRATION_ZIPCODE_FIELD, user.getZipCode());
	}

	public void country(UserData user, String type) {
		selectValueFromDropdown(LOCATOR_REGISTRATION_COUNTRY_DROPDOWN, LOCATOR_REGISTRATION_COUNTRY_DROPDOWN_VALUE,
				user.getCountry());
	}

	public void mobile(UserData user, String type) {
		type(LOCATOR_REGISTRATION_MOBILE_FIELD, user.getMobile());
	}

	public void submitRegisterationForm() {
		click(LOCATOR_REGISTRATION_SUBBIMT_BNT);
		assertTrue(isElementPresented(LOCATOR_REGISTRATION_MYACCOUNT_TEXT),
				"Expected Element is presented on Page, please verify");
	}

}
