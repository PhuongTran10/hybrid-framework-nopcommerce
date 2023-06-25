package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NAME = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NAME = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
	
}
