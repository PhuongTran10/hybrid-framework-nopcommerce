package com.facebook;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplay extends BaseTest{
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
				
		firstName = "Automation";
		lastName = "Testing";
		email = "abc"+ generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
	}
	
	@Test
	public void User_01_Verify_Element_Displayed() {
		loginPage.clickToCreatNewAccountButton();
		verifyTrue(loginPage.isEmailTextboxDisplayed());
	}
	
	@Test
	public void User_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailTextbox(email);
		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());
		loginPage.sleepInSecond(2);
		
		loginPage.enterToEmailTextbox("");
		loginPage.sleepInSecond(2);
		verifyFalse(loginPage.isConfirmEmailTextboxDisplayed());
	}
	
	@Test
	public void User_02_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToCloseIconAtRegisterForm();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName, email, validPassword;
	private LoginPageObject loginPage;
}
