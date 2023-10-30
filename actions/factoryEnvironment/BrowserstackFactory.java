package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;

public class BrowserstackFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;

	public BrowserstackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	public WebDriver createDriver() {
		// Add the following capabilities to your test script
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", "latest");
		if (osName.contains("Windows")) {
			capabilities.setCapability("resolution", "1920x1080");
		} else {
			capabilities.setCapability("resolution", "1920x1440");
		}
		capabilities.setCapability("name", "Run on " + osName + " - " + browserName);

		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", osName);
		browserstackOptions.put("osVersion", osVersion);

		capabilities.setCapability("bstack:options", browserstackOptions);

		try {
			// new browser Driver here
			MutableCapabilities Mcapabilities = new MutableCapabilities();
			driver = new RemoteWebDriver(new URL(GlobalConstants.URL), Mcapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
