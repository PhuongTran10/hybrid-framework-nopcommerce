package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
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

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;
	
	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Platform platform = null;

        if (GlobalConstants.OS_NAME.contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox" :
                desiredCapabilities.setBrowserName("firefox");
                desiredCapabilities.setPlatform(platform);
                break;
            case "chrome" :
                desiredCapabilities.setBrowserName("chrome");
                desiredCapabilities.setPlatform(platform);
                break;
            case "edge" :
                desiredCapabilities.setBrowserName("edge");
                desiredCapabilities.setPlatform(platform);
                break;
            default :
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            // new browser Driver here
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
		
		return driver;
	}

	
}
