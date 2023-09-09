package pageUIs.wordpress.admin;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_ID = "xpath=//table[contains(@class,'table-view-list')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list')]//tbody//a[text()='%s']";
	
}
