package com.qtpselenium.hybirdFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import webDriverModule.WebConnector;

public class PaymentPage extends WebConnector{
	
	private By PaymentTitle = By.xpath("//*[normalize-space(text()) = 'Payment']");
	private By PaymentOptions = By.cssSelector("[class='payment_module'] a");
	private By PayByBankWireOption = By.cssSelector("[title='Pay by bank wire']");
	private By PayByCheckOption = By.cssSelector("[title='Pay by check.']");
	private By ConfirmOrderBnt = By.xpath("//*[text()='I confirm my order']");
	
	public PaymentPage(WebDriver driver, ExtentTest scenario) {
		super(driver, scenario);
	}
	
	 public boolean isPaymentPageDisplayed() {
			try {
				waitForElementToBePresent(PaymentTitle, 60);

			} catch (Exception e) {
				infoLog("Having issue to displaying the Element- PaymentTitle, please verify ");
			}
			return isElementDisplayed(PaymentTitle);
		}
    
    public void the_user_choose_the_payment_method(String PaymentMethod) {
    	String PaymentOptionsTitles = findElement(PaymentOptions).getAttribute("title");
    	if (PaymentOptionsTitles.contains("Pay by bank wire")) {
    		System.out.println("PaymentOptionsTitles " + PaymentOptionsTitles);
			click(PayByBankWireOption);
			wait(2);
		} else if (PaymentOptionsTitles.contains("Pay by check")) {
			click(PayByCheckOption);
			wait(2);
		}
    	theUserClicksTheConfirmOrderBnt();
    }
    
    public void theUserClicksTheConfirmOrderBnt() {
    	click(ConfirmOrderBnt);
    }
}
