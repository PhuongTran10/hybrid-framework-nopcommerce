package factoryEnvironment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.CoccocDriverManager;
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
			driver = new CoccocDriverManager().getBrowserDriver();
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
		driver.get(GlobalConstants.getGlobalConstants().getUser_dev_url());
		return driver;
	}
	
}
