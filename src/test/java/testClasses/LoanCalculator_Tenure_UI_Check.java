package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pageClasses.HomePage;
import pageClasses.LoanCalculator;

public class LoanCalculator_Tenure_UI_Check extends LoanCalculator {

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

	@Test(priority = 16, groups="Smoke Test")
	public void navigateToTenureCalculator() {
		home = new HomePage();
		home.showMenu();
		home.selectLoanCalculator();
		driver.navigate().to("https://emicalculator.net/loan-calculator/");
		selectTenureCalculator();
	}

	@Test(priority=17, groups="Regression Test")
	public void loanAmountUICheck() {
		loanamtslider();
		loanamtslidercheck();
		loanamttextbox();
	}

	@Test(priority=18, groups="Regression Test")
	public void interestRateUICheck() {
		interestrateslider();
		interestrateslidercheck();
		interestratetextbox();
	}

	@Test(priority=19, groups="Regression Test")
	public void emiUICheck() {
		emislider();
		tenureemislidercheck();
		emitextbox();
	}
	
	@Test(priority=20, groups="Regression Test")
	public void feeChargeUICheck() {
		feechargesslider();
		feechargestextbox();
		feeslidercheck();
	}


}
