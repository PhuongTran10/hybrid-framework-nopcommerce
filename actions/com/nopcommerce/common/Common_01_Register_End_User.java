package com.nopcommerce.common;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import commons.BaseTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.user.UserHomePageObject;

import pageObjects.nopCommerce.user.UserRegisterPageObject;


public class Common_01_Register_End_User extends BaseTest{
	
	@Parameters("browser")
	@BeforeTest(description = "Create new user for all test classes")
	public void Register(String browserName) {
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
		driver.quit();
	}
	
	
	private WebDriver driver;
	private String firstName, lastName;
	public static String existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
