package factoryBrowser;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
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
		
		//Download files
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups",0);
		chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE);
		optionsChrome.setExperimentalOption("prefs", chromePrefs);
		
		return new ChromeDriver(optionsChrome);
	}

}
