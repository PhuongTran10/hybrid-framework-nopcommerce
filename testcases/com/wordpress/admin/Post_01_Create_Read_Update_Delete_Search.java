package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest{
	
	String adminUsername = "automationtest";
	String adminPassword = "automationtest";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitleValue = "Live Coding Title " + randomNumber;
	String postBodyValue = "Live Coding Body " + randomNumber;
	
	@Parameters({"browser", "urlAdminMac"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.inputToTextboxByID(driver, adminUsername, "user_login");
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value: " + adminPassword);
		adminLoginPage.inputToTextboxByID(driver, adminPassword, "user_pass");
		
		log.info("Pre-Condition - Step 04: Click to 'Log In' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
		
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage =  adminDashboardPage.clickToPostMenuLink();
		
		log.info("Create_Post - Step 02: Get 'Search Post' page Url");
		searchPostUrl = adminPostSearchPage.getCurrentPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click to 'Add New' button ");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);
		
		log.info("Create_Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBodyValue);
		
		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Click to 'Publish' button on Panel");
		adminPostAddNewPage.clickToPublishButtonOnPanel();
		
		log.info("Create_Post - Step 08: Verify 'Post published' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post published."));
	}
	
	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search_Post' page");
		adminPostSearchPage = adminPostSearchPage.openSearchPostPageUrl(searchPostUrl);
		
	}
	
	@Test
	public void Post_03_View_Post() {
		
	}
	
	@Test
	public void Post_04_Edit_Post() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	
}
