package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NAME, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NAME, pageNumber);
	}
	
	public boolean isPagenationPageActiveDisplayed(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NAME, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NAME, pageNumber);
	}
	
	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementClickable(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		senKeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.RETURN, headerLabel);
	}

	public List<String> openAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for(int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		for (String ValueEachPage : allRowValueAllPage) {
			System.out.println(ValueEachPage);
			System.out.println("---------");
		}
		return allRowValueAllPage;
	}
		
}
