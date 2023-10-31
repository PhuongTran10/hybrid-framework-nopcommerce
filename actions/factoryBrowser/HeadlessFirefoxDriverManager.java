package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		FirefoxOptions optionsHFirefox = new FirefoxOptions();
		optionsHFirefox.addArguments("--headless");
		optionsHFirefox.addArguments("window-size=1920X1080");
		return new FirefoxDriver(optionsHFirefox);
	}

}
