package pageUIs.liveGuru;

public class AdminLoginPageUI {
	public static final String USER_NAME_TEXTBOX = "css=input#username";
	public static final String PASSWORD_TEXTBOX = "css=input#login";
	public static final String LOGIN_BUTTON = "css=input[title='Login']";
	public static final String CLOSE_BUTTON = "xpath=//a[@title='close']/span";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr[@class='headings']//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String HEADER_TEXTBOX_BY_COLUMN_INDEX = "xpath=//tr[@class='filter']/th[%s]//input";
}
