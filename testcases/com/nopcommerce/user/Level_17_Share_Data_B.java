package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_17_Share_Data_B extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		validPassword = "123456";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inputToEmailTextbox(existingEmail);
		
		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 07: Click to 'Register' button");
		homePage = registerPage.clickToRegisterButton();
		
		log.info("Pre-condition - Step 08: Verify success register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		log.info("Pre-condition - Step 10: Click to Logout link");
		if(!registerPage.isLoginLinkDisplayed()) {
			homePage = registerPage.clickToLogoutLink();
		}	
		
		log.info("Pre-condition - Step 01: Navigate to Login Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-condition - Step 02: Enter to Email textbox with value is '" + firstName + "'");
		loginPage.inputToEmailTextbox(existingEmail);
		
		log.info("Pre-condition - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 04: Click to 'Login' button");		
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-condition - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		log.info("Pre-condition - Step 06: Navigate to 'Customer infor' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Pre-condition - Step 07: Verify 'Customer infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforHeaderDisplayed());
	}
	
	@Test
	public void Search_01_Empty_Data() {

		
	}
	
	@Test
	public void Search_02_Relative_Product_Name() {
		
		
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
		
		
	}
	
	@Test
	public void Search_04_Parent_Category() {
		
		
	}
	
	@Test
	public void Search_05_Correct_Manufactorer() {
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
	private WebDriver driver;
	private String firstName, lastName;
	public static String existingEmail;
	public static String validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
}
