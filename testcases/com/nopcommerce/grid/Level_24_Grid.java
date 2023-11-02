package com.nopcommerce.grid;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData_No_SubClass;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class Level_24_Grid extends BaseTest{
	
	Environment environment;
	@Parameters({"envName", "serverName", "browser", "ipAddress", "port", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local")String envName, @Optional("dev")String serverName, @Optional("chrome")String browserName, @Optional("localhost")String ipAddress, @Optional("4444")String portNumber, @Optional("Windows")String osName, @Optional("10")String osVersion) {
		ConfigFactory.setProperty("env", serverName);
		//Create instance of Environment interface (Owner)
		environment = ConfigFactory.create(Environment.class);
		System.out.println(environment.Url());
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		System.out.println(environment.dbHostName());
		System.out.println(environment.dbUserName());
				
		firstName = UserData_No_SubClass.FIRSTNAME;
		lastName = UserData_No_SubClass.LASTNAME;
		existingEmail = UserData_No_SubClass.EMAIL + generateFakeNumber() + "@gmail.com";
		validPassword = UserData_No_SubClass.PASSWORD;
		date = UserData_No_SubClass.DATE;
		month = UserData_No_SubClass.MONTH;
		year = UserData_No_SubClass.YEAR;
		gender = UserData_No_SubClass.GENDER;
		
		System.out.printf("Luồng: %s - id: %d \n", Thread.currentThread().getName(), Thread.currentThread().getId());
		
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
