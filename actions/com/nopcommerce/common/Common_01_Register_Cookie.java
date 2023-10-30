package com.nopcommerce.common;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Common_01_Register_Cookie extends BaseTest{
	
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
		
		if(!registerPage.isLoginLinkDisplayed()) {
			homePage = registerPage.clickToLogoutLink();
		}

		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		LoggedCookies = homePage.getAllCookies(driver);
		
		for (Cookie cookie : LoggedCookies) {
			System.out.println(cookie);
		}

				

	}
	
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName;
	public static String existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	public static Set<Cookie> LoggedCookies;
}
