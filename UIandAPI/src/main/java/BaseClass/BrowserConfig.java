package BaseClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {
	
	public static WebDriver driver;
	
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				String exePath = System.getProperty("user.dir") + "\\src\\main\\java\\BrowserDriver\\chromedriver.exe";
				System.out.println("Path ==> " + exePath);
				System.setProperty("webdriver.chrome.driver", exePath);
				ChromeOptions option = new ChromeOptions();
	            option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
//			reportStep("The browser "+browser+" launched successfully", "PASS");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

}
