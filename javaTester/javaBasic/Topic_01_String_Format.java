package javaBasic;

public class Topic_01_String_Format {
	public static String CUSTOMER_INFOR_LINK = "//div[contains(@class,'account-navigation')]//a[contains(text(),'Customer info')]";
	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[contains(text(),'Addresses')]";
	public static String REWARD_POINTS_LINK= "//div[contains(@class,'account-navigation')]//a[contains(text(),'Reward points')]";
	public static String MY_PRODUCT_REVIEWS_LINK = "//div[contains(@class,'account-navigation')]//a[contains(text(),'My product reviews')]";
	
	//1 biến cho cả n page (format giống nhau - chỉ khác nhau bởi tên page)
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[contains(text(),'%s')]";
	
	//1 locator để đại diện cho các page (Header/ Sidebar/ Footer)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[contains(text(),'%s')]";
	
	public static void main(String[] args) {
		
		clickToLink(ADDRESS_LINK);
		clickToLink(MY_PRODUCT_REVIEWS_LINK);
		System.out.println("-----------");
		
		clickToLink(CUSTOMER_INFOR_LINK, "Addresses");
		clickToLink(CUSTOMER_INFOR_LINK, "My product reviews");
		System.out.println("-----------");
		
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Customer info");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My account");
	
	}
//	//1 tham số động
//	public static void clickToLink(String locator) {
//		System.out.println("Click to + " + locator);
//	}
//	//2 tham số động
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		String locator = String.format(dynamicLocator, pageName);
//		System.out.println("Click to + " + locator);
//	}
//	//3 tham số động
//	public static void clickToLink(String dynamicLocator,String areaName, String pageName) {
//		String locator = String.format(dynamicLocator, areaName, pageName);
//		System.out.println("Click to + " + locator);
//	}
	//1-n tham số động
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to + " + locator);
	}
}
