package com.qtpselenium.hybirdFramework.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import webDriverModule.WebConnector;


public class CartPage extends WebConnector {

	private By isCartPageDisplayed = By.xpath("//span[text()='Your shopping cart']");
	private By productIds = By.xpath("//a[text()='Printed Chiffon Dress']");
	private By checkOut = By.xpath("(//span[normalize-space(text())='Proceed to checkout'])[2]");

	public CartPage(WebDriver webDriver, ExtentTest scenario) {
		super(webDriver, scenario);
	}

	public boolean isCartShowPageDisplayed() {
		try {
			waitForElementToBePresent(isCartPageDisplayed, 60);

		} catch (Exception e) {
			infoLog("Having issue to displaying the Element- isCartPageDisplayed, please verify ");
		}
		return isElementDisplayed(isCartPageDisplayed);
	}

	public boolean isProductIdShow(String productId) {
		try {
			for (WebElement e : findElements(this.productIds)) {
				if (e.getAttribute("text").contains(productId))
					return true;
			}
		} catch (Exception e) {
			infoLog(e.getMessage());
			e.printStackTrace();
			fail();
		}
		return false;
	}

	public void clickCheckOutOnCartPage() {
		waitForAjaxCall();
		click(checkOut);
	}
	
}
