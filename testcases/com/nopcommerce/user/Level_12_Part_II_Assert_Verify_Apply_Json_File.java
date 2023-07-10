package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserDataMapper;
import com.nopcommerce.data.UserDataMapper.Profile;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_12_Part_II_Assert_Verify_Apply_Json_File extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		

		existingEmail = userData.getEmail()+ generateFakeNumber() + "@gmail.com";
		System.out.println(userData.getProfiles().get(0).getLastName());
		System.out.println(userData.getProfiles().get(1).getFirstName());
		System.out.println(userData.getEmail());

	}
	
	@Test(dataProvider = "Data")
	public void User_01_Register_Login(Profile userData, Method method ) {
		String validEmail = userData.getEmail()+ generateFakeNumber() + "@gmail.com";
		ExtentTestManager.startTest(method.getName(), "User_01_Register_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to RegisterLink");
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(userData.getFirstName());
		registerPage.inputToLastnameTextbox(userData.getLastName());
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(userData.getValidPassword());
		registerPage.inputToConfirmPasswordTextbox(userData.getValidPassword());
		homePage = registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		if(!registerPage.isLoginLinkDisplayed()) {
			homePage = registerPage.clickToLogoutLink();
		}	
	
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(userData.getValidPassword());
				
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertFalse(customerInforPage.isCustomerInforHeaderDisplayed());
		customerInforPage.clickToLogoutLinkAtUserPage(driver);

	}
	
	 @DataProvider(name = "Data")
	    public Object[] testData() {
		 Object[] data = new Object[userData.getProfiles().size()];
		 for (int i = 0; i < userData.getProfiles().size(); i++) {
             data[i] = userData.getProfiles().get(i);
         }
         return data;
	    }
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserDataMapper userData;
}
