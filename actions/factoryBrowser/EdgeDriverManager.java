package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {	
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--lang=vi");
		return new EdgeDriver(options);
	}

}
