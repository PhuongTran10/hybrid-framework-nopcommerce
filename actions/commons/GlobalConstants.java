package commons;

import java.io.File;

import lombok.Getter;


@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;
	private GlobalConstants() {
		
	}
	public static synchronized GlobalConstants getGlobalConstants() {
		if(globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}
	
	
	private final String user_dev_url = "https://demo.nopcommerce.com";
	private final String admin_dev_url = "https://admin-demo.nopcommerce.com";
	private final String user_demo_url = "https://demo.nopcommerce.com";
	private final String admin_demo_url = "https://admin-demo.nopcommerce.com";
	public static final String USER_DEV_URL_LIVE_GURU = "http://live.techpanda.org/index.php/";
	public static final String ADMIN_DEV_URL_LIVE_GURU  = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOGS = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_AND_DROP_HTML5 = PROJECT_PATH + File.separator + "dragAndDrop";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "AutomationTest";
	public static final String DB_DEV_PASS = "123456";
	public static final String DB_TEST_URL = "32.18.195.23:9860";
	public static final String DB_TEST_USER = "AutomationTest";
	public static final String DB_TEST_PASS = "123456";
	
	public static final String USERNAME = (System.getenv("BROWSERSTACK_USERNAME") != null) ? System.getenv("BROWSERSTACK_USERNAME") : "phuongtran_stdJlX";
	public static final String AUTOMATE_KEY = (System.getenv("BROWSERSTACK_ACCESS_KEY") != null) ? System.getenv("BROWSERSTACK_ACCESS_KEY") : "pXwTKcXqjHxNxEddZAXB";
	// declare remote URL in a variable
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	public static final  long SHORT_TIMEOUT = 5;
	public static final  long LONG_TIMEOUT = 30;
	public static final  long RETRY_TEST_FAIL = 3;
	
}
