package pageObjects.liveGuru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUserNameTextbox( String userName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, userName);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	}
	
	public void loginAsAdmin(String userName, String password) {
		inputToUserNameTextbox(userName);
		inputToPasswordTextbox(password);
		clickToLoginButton();
	}
	
	public void closeIncomingMessage() {
		waitForElementVisible(driver, AdminLoginPageUI.CLOSE_BUTTON);
		clickToElement(driver, AdminLoginPageUI.CLOSE_BUTTON);
	}
	
	public void enterToHeaderTextboxByName(String columnName, String value) {
		int columnIndex = getElementSize(driver, AdminLoginPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver,  AdminLoginPageUI.HEADER_TEXTBOX_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, AdminLoginPageUI.HEADER_TEXTBOX_BY_COLUMN_INDEX, value,String.valueOf(columnIndex));
		sendKeyBoardToElement(driver, AdminLoginPageUI.HEADER_TEXTBOX_BY_COLUMN_INDEX, Keys.ENTER, String.valueOf(columnIndex));
	}

	public boolean isNameAndEmailSearchedDisplayed(String name, String email) {
		waitForElementVisible(driver, AdminLoginPageUI.NAME_AND_EMAIL_SEARCHED, name, email);
		return isElementDisplayed(driver, AdminLoginPageUI.NAME_AND_EMAIL_SEARCHED, name, email);
	}
	
}
