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
		driver = getBrowserDriverLocal(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		validPassword = "123456";

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstnameTextbox(firstName);
		
		registerPage.inputToLastnameTextbox(lastName);

		registerPage.inputToEmailTextbox(existingEmail);

		registerPage.inputToPasswordTextbox(validPassword);
	
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		homePage = registerPage.clickToRegisterButton();
	
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		driver.quit();
	}
	
	
	private WebDriver driver;
	private String firstName, lastName;
	public static String existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
