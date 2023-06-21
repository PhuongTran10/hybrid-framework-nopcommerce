package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_Dynamic_Locator extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
				
		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
	}
	
	@Test
	public void User_01_Register_Login() {

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
		
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforHeaderDisplayed());

	}
	@Test
	public void User_02_Switch_Page() {
		 addressPage = customerInforPage.openAddressPage(driver);
		 Assert.assertEquals(addressPage.getAddressHeaderText(),"My account - Addresses");
		 
		 myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		 addressPage = myProductReviewPage.openAddressPage(driver);
		 rewardPointPage = addressPage.openRewardPointPage(driver);
		 customerInforPage = rewardPointPage.openCustomerInforPage(driver);
	}
	@Test
	public void User_03_Dynamic_Page_01() {
		addressPage = (UserAddressPageObject) customerInforPage.openPagesAtMyAccountsByName(driver, "Addresses");
		Assert.assertEquals(addressPage.getAddressHeaderText(),"My account - Addresses");
		
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountsByName(driver, "My product reviews");
		addressPage = (UserAddressPageObject) myProductReviewPage.openPagesAtMyAccountsByName(driver, "Addresses");
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountsByName(driver, "Reward points");
		customerInforPage = (UserCustomerInforPageObject) rewardPointPage.openPagesAtMyAccountsByName(driver, "Customer info");
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		customerInforPage.openPagesAtMyAccountsByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		Assert.assertEquals(addressPage.getAddressHeaderText(),"My account - Addresses");
		
		addressPage.openPagesAtMyAccountsByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		Assert.assertEquals(myProductReviewPage.getHeaderText(driver),"My account - My product reviews");
		
		myProductReviewPage.openPagesAtMyAccountsByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		Assert.assertEquals(addressPage.getHeaderText(driver),"My account - Addresses");
		
		addressPage.openPagesAtMyAccountsByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		Assert.assertEquals(rewardPointPage.getHeaderText(driver),"My account - Reward points");
		
		rewardPointPage.openPagesAtMyAccountsByName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		Assert.assertEquals(customerInforPage.getHeaderText(driver),"My account - Customer info");
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
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
}
