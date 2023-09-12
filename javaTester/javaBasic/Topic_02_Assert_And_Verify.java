package javaBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;

@Listeners(commons.MethodListener.class)
public class Topic_02_Assert_And_Verify extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://www.facebook.com/");
		System.out.println("Assert 02");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook – log in or sign up");
		System.out.println("Assert 03");
		verifyFalse(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		System.out.println("Assert 04");
		verifyFalse(driver.findElement(By.xpath("//input[@name='jazoest']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}