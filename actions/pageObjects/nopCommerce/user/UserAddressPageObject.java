package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserBasePageUI;

public class UserAddressPageObject extends BasePage{
	private WebDriver driver;
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getAddressHeaderText() {
		waitForElementVisible(driver, UserBasePageUI.PAGE_HEADER);
		return getElementText(driver, UserBasePageUI.PAGE_HEADER);
	}
}
