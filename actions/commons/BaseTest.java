package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	@BeforeSuite
	public void initBeforeSuit() {
		deleteAllFileInFolder("reportNGImages");
		deleteAllFileInFolder("allure-json");
		deleteAllFileInFolder("allure-results");
		deleteAllFileInFolder("logs");
	}

	protected BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:	
			driver = new FirefoxDriver();
			break;
		case CHROME:		
			ChromeOptions optionsChrome = new ChromeOptions();
			//Disable notifications
			optionsChrome.addArguments("--disable-notifications");
			
			//Disable automation info bar
			optionsChrome.setExperimentalOption("useAutomationExtension", false);
			optionsChrome.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			
			//Disable save password popup
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			optionsChrome.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(optionsChrome);
			break;
		case EDGE:
			ChromeOptions optionsEdge = new ChromeOptions();
			optionsEdge.addArguments("--lang=vi");
			driver = new EdgeDriver();
			break;
		case COCCOC:
			ChromeOptions optionsCoccoc = new ChromeOptions();
			optionsCoccoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsCoccoc);
			break;
		case H_FIREFOX:
			FirefoxOptions optionsHFirefox = new FirefoxOptions();
			optionsHFirefox.addArguments("--headless");
			optionsHFirefox.addArguments("window-size=1920X1080");
			driver = new FirefoxDriver(optionsHFirefox);
			break;	
		case SAFARI:
			driver = new SafariDriver();
			break;
			
		default:
			throw new RuntimeException("Browser name invalid");
		}
		//driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(GlobalConstants.USER_DEV_URL);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
	
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920X1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", GlobalConstants.PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "chromedriver");
			//WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("coccoc")) {
			//WebDriverManager.chromedriver().driverVersion("112.0.5615.49").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
	
	protected WebDriver getBrowserDriverGrid(String browserName, String appUrl, String osName, String ipAddress, String port) {
		
		DesiredCapabilities capability = null;
        Platform platform = null;

        if (osName.contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox" :
                FirefoxOptions options = new FirefoxOptions();
                capability.setBrowserName("firefox");
                capability.setPlatform(platform);
                options.merge(capability);
                break;
            case "chrome" :
                ChromeOptions cOptions = new ChromeOptions();
                capability.setBrowserName("chrome");
                capability.setPlatform(platform);
                cOptions.merge(capability);
                break;
            case "edge" :
                EdgeOptions eOptions = new EdgeOptions();
                capability.setBrowserName("edge");
                capability.setPlatform(platform);
                eOptions.merge(capability);
                break;
            default :
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            // new browser Driver here
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}

	public WebDriver getDriverInstance() {
		return driver;
	}

	protected String getEnvironmentUrl(String environmentName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch (environment) {
		case DEV:
			envUrl = GlobalConstants.USER_DEV_URL;
			break;
		case TESTING:
			envUrl = GlobalConstants.USER_DEMO_URL;
			break;
		case STAGING:
			envUrl = GlobalConstants.USER_DEMO_URL;
			break;
		case PRE_PROD:
			envUrl = GlobalConstants.USER_DEMO_URL;
			break;
		case PROD:
			envUrl = GlobalConstants.USER_DEMO_URL;
			break;
		default:
			envUrl = null;
			break;
		}
		return envUrl;
	}

	public static int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName ;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentMonthText() {
		DateTime currentDateTime = DateTime.now();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MMMM").withLocale(Locale.ENGLISH);
		String monthName = currentDateTime.toString(formatter);
		return monthName;
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDate() {
		return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
	
	protected void showBrowserConsoleLogs(WebDriver driver) {
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(), logEntry -> {
			log.info(logEntry.getText() + "\n");
			log.info(logEntry.getLevel()+ "\n");
		});
	}

	private WebDriver driver;
	protected final Logger log;
}
