package pageClasses;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseClasses.BaseClass;
import utilityClasses.RunScriptWriteExcel;

public class LoanCalculator extends BaseClass {

	// Select EMI calculator on the Loan Calculator Page
	public void selectEMICalculator() {
		try {
			logger = report.createTest("Select Loan EMI calculator");
			findByKey("emiCalculator_Id").click();
			logger.log(Status.INFO, "EMI Calculator selected successfully");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(7, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(7, 3, "Fail");
		}
	}

	// Select Loan Amount calculator on the Loan calculator Page
	public void selectAmountCalculator() {
		try {
			logger = report.createTest("Select Loan Amount calculator");
			findByKey("loanAmountCalculator_Id").click();
			logger.log(Status.INFO, "Loan Amount Calculator selected successfully");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(23, 3, "Pass");
		} catch (Exception e) {
			RunScriptWriteExcel.write(23, 3, "Fail");
			reportFail(e.getMessage());
		}
	}

	// Select Loan Tenure Calculator on the Loan Calculator Page
	public void selectTenureCalculator() {
		try {
			logger = report.createTest("Select Loan Tenure calculator");
			findByKey("LoanTenure_Id").click();
			logger.log(Status.INFO, "Loan Tenure Calculator selected successfully");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(27, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(27, 3, "Fail");
		}
	}

	// loan amount text box is visible or not
	public void loanamttextbox() {
		try {
			logger = report.createTest("Loan Amount Text Box");
			boolean iselementpresent = findByKey("loanamount_Id").isDisplayed();
			if (iselementpresent) {
				System.out.println("Loan Amount Text Box is Visible");
			} else {
				System.out.println("Loan Amount Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(10, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// loan amount slider is visible or not
	public void loanamtslider() {
		try {
			logger = report.createTest("Loan Amount Slider");
			boolean iselementpresent = findByKey("loanamountslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Amount Slider is Visible");
			} else {
				System.out.println("Loan Amount Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(11, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(11, 3, "Fail");
		}
	}

	// checking whether loan amount slider and corresponding text box value matches
	// on sliding to the maximum
	public void loanamtslidercheck() {
		try {
			logger = report.createTest("Loan Amount Check Slider");
			dragSliderToMax("loanamountslider_Id");
			String value = findByKey("loanamount_Id").getAttribute("value");
			Assert.assertEquals(value, "2,00,00,000");
			System.out.println("Loan Amount Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(12, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(12, 3, "Fail");
		}
	}

	// checking whether interest rate textbox is visible or not
	public void interestratetextbox() {
		try {
			logger = report.createTest("Interest Rate Text Box");
			boolean iselementpresent = findByKey("loaninterest_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Text Box is Visible");
			} else {
				System.out.println("Interest Rate Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(13, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(13, 3, "Fail");
		}
	}

	// checking whether interest rate slider is visible or not
	public void interestrateslider() {
		try {
			logger = report.createTest("Interest Rate Slider");
			boolean iselementpresent = findByKey("loaninterestslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Slider is Visible");
			} else {
				System.out.println("Interest Rate Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(14, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(14, 3, "Fail");
		}
	}

	// checking whether interest rate slider and corresponding text box value
	// matches on sliding to the maximum
	public void interestrateslidercheck() {
		try {
			logger = report.createTest("Interest Rate Check Slider");
			dragSliderToMax("loaninterestslider_Id");
			String value = findByKey("loaninterest_Id").getAttribute("value");
			Assert.assertEquals(value, "20");
			System.out.println("Interest Rate Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(15, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(15, 3, "Fail");
		}
	}

	// checking whether loan tenure textbox visible or not
	public void loantermtextbox() {
		try {
			logger = report.createTest("Loan Term Text Box");
			boolean iselementpresent = findByKey("loanterm_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Text Box is Visible");
			} else {
				System.out.println("Loan Tenure Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(16, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(16, 3, "Fail");
		}
	}

	// checking whether loan tenure slider visible or not
	public void loantermslider() {
		try {
			logger = report.createTest("Loan Tenure Slider");
			boolean iselementpresent = findByKey("loantermslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Slider is Visible");
			} else {
				System.out.println("Loan Tenure Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(17, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(17, 3, "Fail");
		}
	}

	// checking whether loan tenure slider and corresponding text box value matches
	// on sliding to the maximum
	public void loantermslidercheck() {
		try {
			logger = report.createTest("Loan Term Check Slider");
			dragSliderToMax("loantermslider_Id");
			String value = findByKey("loanterm_Id").getAttribute("value");
			Assert.assertEquals(value, "30");
			System.out.println("Loan Tenure Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(18, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(18, 3, "Fail");
		}
	}
	
	public void loantermtogglebutton() {
		try {
			logger = report.createTest("Loan Term Year/Month Toggle button Check");
			toggle("loanmonthstoggle_Id");
			String value = findByKey("loanterm_Id").getAttribute("value");
			Assert.assertEquals(value, "360");
			System.out.println("Loan Tenure Toggle Button is Checked");
			logger.log(Status.PASS, "Test Passed");	
			RunScriptWriteExcel.write(19, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(19, 3, "Fail");
		}
	}

	// checking whether fee & charges textbox is visible or not
	public void feechargestextbox() {
		try {
			logger = report.createTest("Fees & Charges Text Box");
			boolean iselementpresent = findByKey("loanfees_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Text Box is Visible");
			} else {
				System.out.println("Fees & Charges Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(20, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(20, 3, "Fail");
		}
	}

	// checking whether fee & charges slider is visible or not
	public void feechargesslider() {
		try {
			logger = report.createTest("Fees & Charges Slider");
			boolean iselementpresent = findByKey("loanfeesslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Slider is Visible");
			} else {
				System.out.println("Fees & Charges Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(21, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(21, 3, "Fail");
		}
	}

	// checking whether fee & charge slider and corresponding text box value matches
	// on sliding to the maximum
	public void feeslidercheck() {
		try {
			logger = report.createTest("Fees & Charges Check Slider");
			dragSliderToMax("loanfeesslider_Id");
			String value = findByKey("loanfees_Id").getAttribute("value");
			Assert.assertEquals(value, "1,00,000");
			System.out.println("Loan Fees Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(22, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(22, 3, "Fail");
		}
	}

	// checking whether emi textbox is visible or not
	public void emitextbox() {
		try {
			logger = report.createTest("Fees & Charges Text Box");
			boolean iselementpresent = findByKey("emiTextBox_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("EMI Text Box is Visible");
			} else {
				System.out.println("EMI Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(24, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(24, 3, "Fail");
		}

	}

	// checking whether emi slider is visible or not
	public void emislider() {

		try {
			logger = report.createTest("Fees & Charges Slider");
			boolean iselementpresent = findByKey("emiSlider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan EMI Slider is Visible");
			} else {
				System.out.println("Loan EMI Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(25, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(25, 3, "Fail");
		}

	}

	// checking whether emi slider and corresponding text box value matches on
	// sliding to the maximum
	public void emislidercheck() {

		try {
			logger = report.createTest("Fees & Charges Check Slider");
			dragSliderToMax("emiSlider_Id");
			String value = findByKey("emiTextBox_Id").getAttribute("value");
			Assert.assertEquals(value, "1,00,000.01");
			System.out.println("Loan EMI Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(26, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(26, 3, "Fail");
		}

	}

	// checking whether Loan tenure EMI slider and corresponding text box value
	// matches on sliding to the maximum
	public void tenureemislidercheck() {

		try {
			logger = report.createTest("Fees & Charges Check Slider");
			dragSliderToMax("emiSlider_Id");
			String value = findByKey("emiTextBox_Id").getAttribute("value");
			Assert.assertEquals(value, "3,34,203.74");
			System.out.println("Loan EMI Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(28, 3, "Pass");
		} catch (Exception e) {
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(28, 3, "Fail");
		}

	}

}
