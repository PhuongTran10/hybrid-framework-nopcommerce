package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Page UI
	@FindBy(className = "email")
	private WebElement emailTextbox;
	@FindBy(className = "password")
	private WebElement passwordTextbox;
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement unsuccessErrorMessage;
	
	//Page Object
	public void clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(driver, loginButton);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);	
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unsuccessErrorMessage);
		return getElementText(driver, unsuccessErrorMessage);
	}
	
}
