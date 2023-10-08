package utilityClasses;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {

	// Create WebDriver Instance

	private static WebDriver driver;

	public static WebDriver invokeBrowser(String browser) {
		
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		System.out.println("Opening " + browser + " browser...");

		// Check if parameter passed as 'Chrome'

		if (browser.equalsIgnoreCase("Chrome")) {

			// set path to chromedriver.exe

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

			// create Chrome instance

			driver = new ChromeDriver();

		}

		// Check if parameter passed as 'Edge'

		else if (browser.equalsIgnoreCase("Edge")) {

			// set path to msedgedriver.exe

			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe");

			// create Edge instance

			driver = new EdgeDriver();

		} else {

			// If no browser passed

			System.out.println("Browser name not found in ProjectConfig.properties file.");
		}

		// Maximize Browser Window

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
