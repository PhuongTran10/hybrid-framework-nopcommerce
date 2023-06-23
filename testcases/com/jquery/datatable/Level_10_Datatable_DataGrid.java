package com.jquery.datatable;

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
	
	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("18");
		

	}
	
	@Test
	public void Table_02_Enter_To_Header() {
		 homePage.enterToHeaderTextboxByLabel("Country","624");
		 homePage.enterToHeaderTextboxByLabel("Females","Seychelles");
		 homePage.enterToHeaderTextboxByLabel("Males","651");
		 homePage.enterToHeaderTextboxByLabel("Total","1270");
		 
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;
}
