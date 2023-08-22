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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_17_Share_Data_C extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "Testing";
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCookies);
		for (Cookie cookie : Common_01_Register_Cookie.LoggedCookies) {
			System.out.println("C class" + cookie);
		}
		
		loginPage.refreshCurrentPage(driver);

		homePage = loginPage.clickToNotificationCloseButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isCustomerInforHeaderDisplayed());
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
