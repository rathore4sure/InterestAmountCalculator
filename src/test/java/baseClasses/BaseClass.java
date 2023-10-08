package baseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import utilityClasses.RunScriptWriteExcel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilityClasses.ExtentReportManager;

import utilityClasses.DriverSetup;

public class BaseClass {

	public static ExtentTest logger;
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report = ExtentReportManager.getReportInstance();

	@BeforeTest
	public void loadConfig() {
			try {
				prop = new Properties();
				FileInputStream io = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\ProjectConfig.properties");
				prop.load(io);
			} catch (FileNotFoundException e) {
				reportFail(e.getMessage());
			} catch (IOException e) {
				reportFail(e.getMessage());
			}
	}
	
	// Opening URL in the selected browser

		public void openApp() {
			try {
				logger = report.createTest("Opening Application");
				String browserName = prop.getProperty("browserName");	
				driver = DriverSetup.invokeBrowser(browserName);
				driver.get(prop.getProperty("webURL"));
				logger.log(Status.INFO, "Application opened successfully");
				RunScriptWriteExcel.write(4,3,"Pass");
				logger.log(Status.PASS, "Test Passed");
			} catch (Exception e) {
				reportFail(e.getMessage());
				RunScriptWriteExcel.write(4,3,"Fail");
			}
		}
		
		//Closing URL and browser

		public void closeApp() {
			try {
				logger = report.createTest("Closing Application");
				driver.quit();
				logger.log(Status.INFO, "Application closed successfully");
				RunScriptWriteExcel.write(4,3,"Pass");
				logger.log(Status.PASS, "Test Passed");
			} catch (Exception e) {
				reportFail(e.getMessage());
				RunScriptWriteExcel.write(4,3,"Fail");
			}
		}

	
	// Finding element by Key from the properties file
	
	public WebElement findByKey(String locatorKey) {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
			return element;
	}


	// REPORTING FUNCTIONS
	
	/* 1.reportFail() */
	
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);
	}

	/* 2.reportPass() */
	
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	/* 3.Flush report and create a new one*/
	
	public void endReport() 
	{
		try
		{
			report.flush();
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}

	// Clear and Fill Data

	public void clearAndFill(String locatorKey, String InputDataKey) {
		try {
			findByKey(locatorKey).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			findByKey(locatorKey).sendKeys(prop.getProperty(InputDataKey));
			findByKey(locatorKey).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	// Moving Slider to the Maximum
	
	public void dragSliderToMax(String Key) {
		try {
			WebElement slider = findByKey(Key);
			Actions move = new Actions(driver);
			Action action = (Action) move.dragAndDropBy(slider, 350, 0).build();
			action.perform();
		} catch (Exception e) {
			 reportFail(e.getMessage());
		}
	}
	
	// Click year/months Toggle Button 
	
	public void toggle(String Key) {
		try {
			WebElement btn = findByKey(Key);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", btn);
			js.executeScript("arguments[0].click()", btn);
			} catch (Exception e) {
			 reportFail(e.getMessage());
		}
	}

}
