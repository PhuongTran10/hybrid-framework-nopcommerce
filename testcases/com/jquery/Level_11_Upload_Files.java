package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;



public class Level_11_Upload_Files extends BaseTest{
	String beachFileName = "beach.jpg";
	String BGName = "BG.jpg";
	String mountainFileName = "mountain.jpg";
	String sampleFileName = "sample.png";
	
	String[] multipleFileNames = {beachFileName, BGName, mountainFileName, sampleFileName};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, beachFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(beachFileName));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(multipleFileNames));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(multipleFileNames));
		Assert.assertTrue(homePage.isFileImageUploadedByName(multipleFileNames));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;
}
