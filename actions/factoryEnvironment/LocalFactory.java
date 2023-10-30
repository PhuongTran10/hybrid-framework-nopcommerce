package factoryEnvironment;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;

public class LocalFactory {
	private String browserName;
	private WebDriver driver;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
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
	
}
