package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

public class AdminUserPO extends BasePage {

	private WebDriver driver;
	
	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

}
