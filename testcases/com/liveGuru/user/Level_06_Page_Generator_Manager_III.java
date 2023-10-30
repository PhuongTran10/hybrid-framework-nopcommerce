package com.liveGuru.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_III extends BaseTest{
	
	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String endUserUrl) {
		driver = getBrowserDriverLocal(browserName, endUserUrl);
		showBrowserConsoleLogs(driver);
		homePage = PageGeneratorManager.getHomPage(driver);
		
		emailValid = "abc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}
	
	@Test
	public void User_01_Register_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailAddressTextbox(emailValid);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		showBrowserConsoleLogs(driver);
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		
		
		myDashboardPage.clickToAccountLink();
		showBrowserConsoleLogs(driver);
		homePage = myDashboardPage.clickToLogoutlink();
		showBrowserConsoleLogs(driver);
		
	}
	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTextbox(emailValid);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickTologinButton();
		showBrowserConsoleLogs(driver);
		
		Assert.assertTrue(myDashboardPage.isAccountInformationLinkDisplayed());
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private String emailValid, password; 

	
}
