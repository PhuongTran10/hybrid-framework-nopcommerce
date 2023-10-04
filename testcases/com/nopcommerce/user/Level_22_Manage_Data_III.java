package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Common_01_Register_Cookie;
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
import utilities.DataHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_22_Manage_Data_III extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
				
		date = "7";
		month = "February";
		year = "2000";
		gender = "Male";
		
	}
	
	@Test
	public void User_01_Register() {	
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioBoxByLabel(driver, gender);
		
		registerPage.inputToTextboxByID(driver, firstName, "FirstName");
		
		registerPage.inputToTextboxByID(driver, lastName, "LastName");
		
		registerPage.selectToDropdownByName(driver, date, "DateOfBirthDay");
		registerPage.selectToDropdownByName(driver, month, "DateOfBirthMonth");
		registerPage.selectToDropdownByName(driver, year, "DateOfBirthYear");

		registerPage.inputToTextboxByID(driver, existingEmail, "Email");
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		registerPage.inputToTextboxByID(driver, validPassword, "Password");
		
		registerPage.inputToTextboxByID(driver, validPassword, "ConfirmPassword");

		registerPage.clickToButtonByText(driver, "Register");
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	}
	
	@Test
	public void User_02_Login() {
		
		if(!registerPage.isLoginLinkDisplayed()) {
			homePage = registerPage.clickToLogoutLink();
		}

		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void User_03_My_Account() {
		
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isCustomerInforHeaderDisplayed());
		
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), existingEmail);
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
		
	private WebDriver driver;
	private String firstName, lastName;
	private String date, month, year, gender;
	public static String existingEmail;
	public static String validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
}
