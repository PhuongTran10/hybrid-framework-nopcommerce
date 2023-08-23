package pageUIs.nopCommerce.user;

public class UserBasePageUI {	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BOX_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Customer info')]";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Addresses')]";
	public static final String REWARD_POINTS_LINK= "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'Reward points')]";
	public static final String MY_PRODUCT_REVIEWS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'My product reviews')]";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]";
	public static final String PAGE_HEADER= "xpath=//div[@class='page-title']/h1";
	
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
}
