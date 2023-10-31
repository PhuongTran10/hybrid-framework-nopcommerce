package factoryEnvironment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.SafariDriverManager;

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
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME:		
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case COCCOC:
			ChromeOptions optionsCoccoc = new ChromeOptions();
			optionsCoccoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsCoccoc);
			break;
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			
		default:
			throw new BrowserNotSupportedException(browserName);
		}
		//driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(GlobalConstants.USER_DEV_URL);
		return driver;
	}
	
}
