package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Helper {
	
	public static WebDriver launchBrowser(String browser, String url) {
		WebDriver driver = null;

		switch (browser) {
		case "Chrome":
		case "Chrome Browser":
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\Chrome Browser drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.get(url);
			driver.manage().window().maximize();
			break;

		case "Edge":
		case "edge":
		case "Edge Browser":
			System.setProperty("webdriver.edge.driver", ".\\Edge Browser Driver\\msedgedriver.exe");
			driver = new EdgeDriver();

			driver.get(url);
			driver.manage().window().maximize();
			break;

		default:
			throw new IllegalArgumentException("Browser Not Found ....");

		}
		return driver;
	}
	
	public static  void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
