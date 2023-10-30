package com.wordpress.admin;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

public class User_01_View_User extends BaseTest{
	
	String adminUsername = "automationtest";
	String adminPassword = "automationtest";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String adminUrl, endUserUrl;	
	String currentDate = getCurrentDate();
	@Parameters({"browser", "adminUrl", "userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin site");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriverLocal(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.inputToTextboxByID(driver, adminUsername, "user_login");
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value: " + adminPassword);
		adminLoginPage.inputToTextboxByID(driver, adminPassword, "user_pass");
		
		log.info("Pre-Condition - Step 04: Click to 'Log In' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}
	
	@Test
	public void TC_01_View_User() {
		log.info("View_User - Step 01: Click to 'User' menu link");
		adminUserPage =  adminDashboardPage.clickToUserMenuLink();
		
		log.info("View_User - Step 02: Get all user from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
		
		log.info("View_User - Step 03: Get all user from DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
		
		log.info("View_User - Step 04: Verify users are matching");
		verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);
		
		log.info("View_User - Step 05: Verify only 1 user matching");
		verifyTrue(adminUserPage.checkTotalRecordFromDB(adminUsername, "roleAdmin"));
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	public static Set<Cookie> LoggedCookies;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminUserPO adminUserPage;
	
	
	
}
