package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	
	private WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}

	public void clickToPublishButtonOnPanel() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_ON_PANEL);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_ON_PANEL);
	}
	
	public boolean isPostPublishedMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_POST_MESSAGE);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_POST_MESSAGE, postPublishedMessage);
	}


}
