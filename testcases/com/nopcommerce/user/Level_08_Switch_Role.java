package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role extends BaseTest{
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environment) {
		driver = getBrowserDriver(browserName,environment);
		useHomePage = PageGeneratorManager.getUserHomePage(driver);
				
		firstName = "Automation";
		lastName = "Testing";
		userEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		userPassword = "123456";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		userRegisterPage = useHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(userEmail);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		useHomePage = userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
		
		if(!userRegisterPage.isLoginLinkDisplayed()) {
			useHomePage = userRegisterPage.clickToLogoutLink();
		}	
	}
	
	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = useHomePage.clickToLoginLink();
		useHomePage = userLoginPage.loginAsUser(userEmail,userPassword);
		Assert.assertTrue(useHomePage.isMyAccountLinkDisplayed());
		userCustomerInforPage = useHomePage.clickToMyAccountLink();
		userMyProductReviewPage = userCustomerInforPage.openMyProductReviewPage(driver);
		useHomePage = useHomePage.clickToLogoutLinkAtUserPage(driver);
		
		useHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}
	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_DEV_URL);
		useHomePage = PageGeneratorManager.getUserHomePage(driver);
		userLoginPage = useHomePage.clickToLoginLink();
		useHomePage = userLoginPage.loginAsUser(userEmail,userPassword);
		Assert.assertTrue(useHomePage.isMyAccountLinkDisplayed());
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName, userEmail, userPassword, adminEmail, adminPassword;
	private UserHomePageObject useHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private UserMyProductReviewPageObject userMyProductReviewPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
}
