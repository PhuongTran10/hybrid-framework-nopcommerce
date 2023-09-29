package pageObjects.saurcelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saurcelab.LoginPageUI;

public class LoginPO extends BasePage{
	
	WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public ProductPO clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
	
}
