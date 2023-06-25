package com.jquery.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;


public class Level_10_Datatable_DataGrid extends BaseTest{
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPagenationPageActiveDisplayed("10"));
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPagenationPageActiveDisplayed("20"));
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPagenationPageActiveDisplayed("7"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPagenationPageActiveDisplayed("18"));

	}
	
	//@Test
	public void Table_02_Enter_To_Header() {
		 homePage.refreshCurrentPage(driver);
		 homePage.enterToHeaderTextboxByLabel("Country","Afghanistan");
		 homePage.enterToHeaderTextboxByLabel("Females","384187");
		 homePage.enterToHeaderTextboxByLabel("Males","407124");
		 homePage.enterToHeaderTextboxByLabel("Total","791312");
		 homePage.sleepInSecond(1);
		 homePage.enterToHeaderTextboxByLabel("Country","Angola");
		 homePage.enterToHeaderTextboxByLabel("Females","276880");
		 homePage.enterToHeaderTextboxByLabel("Males","2017");
		 homePage.enterToHeaderTextboxByLabel("Total","553353");
		 homePage.sleepInSecond(1);
	}
	@Test
	public void Table_03_Enter_To_Header_Verify_All_Data() {
		homePage.openAllPage();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;
}
