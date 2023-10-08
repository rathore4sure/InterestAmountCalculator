package pageClasses;

import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.Status;

import baseClasses.BaseClass;
import utilityClasses.RunScriptWriteExcel;

public class HomePage extends BaseClass {

	// Finding and clicking Calculator Menu
	public void showMenu() {
		try {
			findByKey("calculatormenu_Xpath").click();
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Selecting Home Loan EMI from the Menu
	public HomeLoanEMI selectHomeLoanEmi() {
		try {
			findByKey("homeemicalculator_Xpath").click();
			RunScriptWriteExcel.write(7, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(7, 3, "Fail");
		}
		HomeLoanEMI emh = new HomeLoanEMI();
		return emh;
	}

	// Selecting Loan Calculator from the Menu
	public LoanCalculator selectLoanCalculator() {
		try {
			findByKey("loancalculator_Xpath").click();
			RunScriptWriteExcel.write(9, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(9, 3, "Fail");
		}
		LoanCalculator loan = new LoanCalculator();
		return loan;
	}

	// Selecting Car Loan on the Homepage
	public void selectCarLoan() {
		try {
			findByKey("carloanmenu_Id").click();
			RunScriptWriteExcel.write(5, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(5, 3, "Fail");
		}
	}

	// Filling Loan Amount in the text box
	public void fillLoanAmount() {
		try {
			clearAndFill("loanamount_Id", "amount");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Filling Loan Interest in the text box
	public void fillInterest() {
		try {
			clearAndFill("loaninterest_Id", "interest");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Filling Loan Tenure in the text box
	public void fillTenure() {
		try {
			clearAndFill("loanterm_Id", "tenure");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Print's the One month PRINCIPLE AMOUNT and INTEREST AMOUNT
	public void getdata() {
		try {
			logger = report.createTest("EMI Calculation for a Month");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)", "");
			findByKey("year_Id").click();
			String PA = findByKey("PA_Xpath").getText();
			String principle = PA.substring(1, PA.length());
			String IA = findByKey("IA_Xpath").getText();
			String interest = IA.substring(1, IA.length());
			String rupees = "Rs.";
			System.out.println("The Principal Amount for One Month is:" + rupees.concat(principle));
			System.out.println("The Interest Amount for One Month is:" + rupees.concat(interest));
			RunScriptWriteExcel.write(6, 3, "Pass");
			logger.log(Status.INFO, "EMI Calculated for a month");
			logger.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(6, 3, "Fail");
		}
	}
}
