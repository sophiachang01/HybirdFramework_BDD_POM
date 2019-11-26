package com.qtpselenium.hybirdFramework.modules;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybirdFramework.pages.PaymentPage;

public class PaymentModule {

	public PaymentPage paymentPage;

	public PaymentModule(WebDriver webDriver, ExtentTest scenario) {
		paymentPage = new PaymentPage(webDriver, scenario);
	}

	public void the_payment_page_is_displayed() {
		assertTrue(paymentPage.isPaymentPageDisplayed(),"The Payment Page is not shown");
	}
	
    public void the_user_choose_the_payment_method(String paymentmethod) {
        paymentPage.the_user_choose_the_payment_method(paymentmethod);
    }
	
}
