package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import graphql.Assert;
import pageObjects.saurcelab.LoginPO;
import pageObjects.saurcelab.PageGeneratorManager;
import pageObjects.saurcelab.ProductPO;

public class Level_20_Sort_Asc_Desc extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String saurcelabUrl) {
		driver = getBrowserDriver(browserName, saurcelabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToTextboxByID(driver, "standard_user", "user-name");
		loginPage.inputToTextboxByID(driver, "secret_sauce", "password");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(2);
		
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(2);
		
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(2);
		
		Assert.assertTrue(productPage.isPriceSortByAscending());

		// Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(2);
		
		Assert.assertTrue(productPage.isPriceSortByDescending());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	LoginPO loginPage;
	ProductPO productPage;
}
