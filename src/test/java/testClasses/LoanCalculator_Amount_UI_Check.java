package testClasses;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pageClasses.HomePage;
import pageClasses.LoanCalculator;


public class LoanCalculator_Amount_UI_Check extends LoanCalculator {

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
		
		@Test(priority=11, groups="Smoke Test")
		public void navigateToAmountCalculator() {
			home = new HomePage();
			home.showMenu();
			home.selectLoanCalculator();
			driver.navigate().to("https://emicalculator.net/loan-calculator/");
			selectAmountCalculator();
		}
		
		@Test(priority=12, groups="Regression Test")
		public void emiUICheck() {
			emislider();
			emislidercheck();
			emitextbox();
		}
		
		@Test(priority=13, groups="Regression Test")
		public void interestRateUICheck() {
			interestrateslider();
			interestrateslidercheck();
			interestratetextbox();
		}
		
		@Test(priority=14, groups="Regression Test")
		public void loantermUICheck() {

			loantermslider();
			loantermslidercheck();
			loantermtextbox();
			loantermtogglebutton();
		}
		
		@Test(priority=15, groups="Regression Test")
		public void feeChargeUICheck() {
			feechargesslider();
			feechargestextbox();
			feeslidercheck();
		}
		
}