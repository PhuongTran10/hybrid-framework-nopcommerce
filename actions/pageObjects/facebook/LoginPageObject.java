package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToCreatNewAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}
	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
	}
	public void clickToCloseIconAtRegisterForm() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}
	public boolean isConfirmEmailTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
	}

}
