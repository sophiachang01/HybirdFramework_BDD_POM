package com.qtpselenium.hybirdFramework.pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import webDriverModule.WebConnector;

public class ProductPage extends WebConnector {

	// public WebDriver webDriver;
	private By masterProduct = By.cssSelector("[itemprop='name'] a");
	private By productName = By.xpath("(//ul[@class='product_list grid row']//a[@title='Printed Chiffon Dress'])[2]");
	private By productVariation = By.cssSelector("[class='form-control attribute_select no-print']");
	private By quantityWanted = By.xpath("//*[@id='quantity_wanted']");
	private By addProductQuantity = By.cssSelector("[class='icon-plus']");
	private String selectProductColor = "[title='%s']";
	private By addToCartButton = By.xpath("//span[text()='Add to cart']");
	private By proceedToCart = By.cssSelector("[title='Proceed to checkout']");
	


	public ProductPage(WebDriver webDriver, ExtentTest scenario) {
		super(webDriver, scenario);
	}

	public void assertProductDetailsPage(String productName) {
		assertTrue(driver.findElement(masterProduct).getAttribute("title").contains(productName),
				"PLP is not load, Please Verify");
	}

	public void theUserChooseTheProductSizeAsAndQuantityAsAndColor(String productSize, String productQuantity,
			String productColor) {
		click(productName);
		try {
			selectVariation(productSize);
			addProductQuantity(Integer.valueOf(productQuantity));
			selectProductColor(productColor);

		} catch (Exception e) {
			scenario.log(Status.INFO, "Issue while select the product configuration, please verify");
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	public void selectVariation(String productSize) {
		selectValueFromDropdown(productVariation, productSize);
	}

	public void addProductQuantity(int productQuantity) {
		try {
			String defaultQuantity = findElement(quantityWanted).getAttribute("value");
			scenario.log(Status.INFO, "defaultQuantity --> "+defaultQuantity);
			if (!defaultQuantity.equals(String.valueOf(productQuantity))) {
				while (productQuantity > 1) {
					click(addProductQuantity);
					productQuantity--;
				}
				scenario.log(Status.INFO,"product Quantity select successfully "+productQuantity);
			}
		} catch (Exception e) {
			scenario.log(Status.INFO, "Not able to addProduct quantity");
			Assert.fail();
		}
	}

	public void selectProductColor(String productColor) {
		if (productColor.isEmpty()) {
			scenario.log(Status.INFO, "productColor is Empty, please verify");
			Assert.fail();
		}

		click(By.cssSelector(String.format(selectProductColor, productColor)));

	}
	
	public WebElement addToBagButton() {
		return findElement(addToCartButton);
	}
	
	public void proceedToCart() {
		click(proceedToCart);
	}

}
