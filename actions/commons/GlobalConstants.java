package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_DEV_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	public static final String USER_DEMO_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_DEMO_URL = "https://admin-demo.nopcommerce.com";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOGS = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_AND_DROP = PROJECT_PATH + File.separator + "dragAndDrop";
	 
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "AutomationTest";
	public static final String DB_DEV_PASS = "123456";
	
	public static final String DB_TEST_URL = "32.18.195.23:9860";
	public static final String DB_TEST_USER = "AutomationTest";
	public static final String DB_TEST_PASS = "123456";
	
	public static final  long SHORT_TIMEOUT = 5;
	public static final  long LONG_TIMEOUT = 10;
	public static final  long RETRY_TEST_FAIL = 3;
	
}
