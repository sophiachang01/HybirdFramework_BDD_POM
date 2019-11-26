package com.qtpselenium.hybirdFramework.modules;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import objects.Forms;
import objects.UserData;
import com.qtpselenium.hybirdFramework.pages.DeliveryPage;

public class DeliveryModule {

	
	DeliveryPage deliveryPage;
	
	public DeliveryModule(WebDriver webDriver, ExtentTest scenario) {
		deliveryPage = new DeliveryPage(webDriver,scenario);
	}

	
	public void assertDeliveryPage() {
		deliveryPage.assertDeliveryPage();
	}
	
	public void fillDeliveryDetails(UserData input, Forms forms) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		deliveryPage.addNewAddress();
		deliveryPage.fillDeliveryDetails(input, forms);
		deliveryPage.submit();
	}
	
	
	
	
}
