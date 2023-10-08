package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pageClasses.HomePage;

public class CarEMICalculator extends HomePage {

	@BeforeClass
	public void setUp() {
		openApp();
	}

	@AfterClass
	public void tearDown() {
		closeApp();
		endReport();
	}

	@Test(priority=0, groups="Smoke Test")
	public void navigateToCarEMI() {
		selectCarLoan();
	}
	
	@Test(priority=1, groups="Regression Test")
	public void fillData() {
		fillLoanAmount();
		fillInterest();
		fillTenure();
	}
	
	@Test(priority=2, groups="Regression Test")
	public void printResultOnConsole() {	
		getdata();
	}
}
