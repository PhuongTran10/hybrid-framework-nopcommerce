package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLink() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LINK);
	}

	public HomePageObject clickToLogoutlink() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomPage(driver);
	}

	public boolean isAccountInformationLinkDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_INFORMATION_LINK);
		return isElementDisplayed(driver, MyDashboardPageUI.ACCOUNT_INFORMATION_LINK);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	private WebDriver driver;

}
