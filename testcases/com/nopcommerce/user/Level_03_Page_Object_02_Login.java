package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.HomePageUI;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_02_Login {
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
				
		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		invalidEmail = "abc@abc.123@132";
		notFoundEmail = "abc"+ generateFakeNumber() + "@gmail.vn";
		password = "123456";
		
		System.out.println("Pre-Condition - Step 01: Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		System.out.println("Pre-Condition - Step 02: Input data to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(password);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	public void Login_03_Email_Not_Found() {
		
	}
	public void Login_04_Existing_Email_Empty_Password() {
		
	}
	public void Login_05_Existing_Email_Incorrect_Password() {
		
	}
	public void Login_06_Valid_Email_Password() {
		
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
}
