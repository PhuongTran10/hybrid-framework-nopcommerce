package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;


public class Level_10_Datatable_DataGrid extends BaseTest{
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriverLocal(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		showBrowserConsoleLogs(driver);
	}
	
	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		showBrowserConsoleLogs(driver);
		Assert.assertTrue(homePage.isPagenationPageActiveDisplayed("10"));
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		showBrowserConsoleLogs(driver);
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
	//@Test
	public void Table_03_Enter_To_Header_Verify_All_Data() {
		homePage.openAllPage();
	}
	
	@Test
	public void Table_04_Action_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "HVG");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Michael 97");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "4", "Sysney");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","5","Japan");
		homePage.sleepInSecond(2);
		homePage.selectDropdownByColumnNameAtRowNumber("Country","1","Hong Kong");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "4");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("3","Move Up");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;
}
