package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserPostDetailPageUI;

public class UserSearchPostPO extends BasePage{
	
	private WebDriver driver;
	
	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	


}
