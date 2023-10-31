package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;;

public class EdgeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {	
		if(!IS_OS_WINDOWS || !IS_OS_MAC) {
			throw new BrowserNotSupportedException("Edge is not supported on " +System.getProperty("os.name"));
		}
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--lang=vi");
		return new EdgeDriver(options);
	}

}
