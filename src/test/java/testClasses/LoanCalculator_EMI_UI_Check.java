package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pageClasses.HomePage;
import pageClasses.LoanCalculator;

public class LoanCalculator_EMI_UI_Check extends LoanCalculator{

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

	
	@Test(priority=6, groups="Smoke Test")
	public void navigateToEMICalculator() {
		home = new HomePage();
		home.showMenu();
		home.selectLoanCalculator();
		driver.navigate().to("https://emicalculator.net/loan-calculator/");
		selectEMICalculator();
	}
	
	@Test(priority=7, groups="Regression Test")
	public void loanAmountUICheck() {
		loanamtslider();
		loanamtslidercheck();
		loanamttextbox();
	}
	
	@Test(priority=8, groups="Regression Test")
	public void interestRateUICheck() {
		interestrateslider();
		interestrateslidercheck();
		interestratetextbox();
	}
	
	@Test(priority=9, groups="Regression Test")
	public void loanTermUICheck() {
		loantermslider();
		loantermslidercheck();
		loantermtextbox();
		loantermtogglebutton();
		
	}
	
	@Test(priority=10, groups="Regression Test")
	public void feeChargeUICheck() {
		feechargesslider();
		feechargestextbox();
		feeslidercheck();
	}	
	
}
