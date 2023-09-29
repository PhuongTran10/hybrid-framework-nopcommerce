package pageObjects.saurcelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saurcelab.ProductPageUI;

public class ProductPO extends BasePage{
	
	WebDriver driver;
	
	public ProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemText) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, itemText);
	}

	public boolean isProductNameSortByAscending() {
		List<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		
		List<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productUIList);
		
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		List<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		
		List<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productUIList);
		Collections.reverse(productUIList);
		
		return productSortList.equals(productUIList);
	}

	public boolean isPriceSortByAscending() {
		List<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productUIList);
		
		return productSortList.equals(productUIList);
	}

	public boolean isPriceSortByDescending() {
		List<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productUIList);
		Collections.reverse(productUIList);
		
		return productSortList.equals(productUIList);
	}
	
}
