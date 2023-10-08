package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import pageClasses.HomeLoanEMI;
import pageClasses.HomePage;

public class HomeLoanEMICalculator extends HomeLoanEMI {
	HomePage home;

	@BeforeClass
	public void setUp() {
		openApp();
	}

	@AfterClass
	public void tearDown() {
		closeApp();
		endReport();
	}

	@Test(priority=3, groups="Smoke Test")
	public void navigateToHomeLoan() throws IOException {
		home = new HomePage();
		home.showMenu();
		home.selectHomeLoanEmi();
		driver.navigate().to("https://emicalculator.net/home-loan-emi-calculator/");
	}

	@Test(priority=4, groups="Regression Test")
	public void fillRelevantData() {
		fillData();
	}

	@Test(priority=5, groups="Regression Test")
	public void storeData() {
		try {
			storeDataInExcel();
		} catch (IOException e) {
			reportFail(e.getMessage());
		}
	}
}