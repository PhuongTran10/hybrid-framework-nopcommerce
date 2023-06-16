package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
	}
	public void inputToEmailAddressTextbox(String emailValid) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXT_BOX, emailValid);
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
	}
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, password);
	}
	public MyDashboardPageObject clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}
	private WebDriver driver;
}
