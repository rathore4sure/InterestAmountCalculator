package pageClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import baseClasses.BaseClass;
import utilityClasses.RunScriptWriteExcel;

public class HomeLoanEMI extends BaseClass {

	// Filling the input data

	public void fillData() {
		try {
			logger = report.createTest("Filling data on the HomeLoan EMI page");
			clearAndFill("homeValue_Id", "homeprice");
			clearAndFill("downPayment_Id", "downpayment");
			clearAndFill("homeLoanInsurance_Id", "insurance");
			clearAndFill("homeLoanAmount_Id", "loan");
			clearAndFill("interestRate_Id", "interest_home");
			clearAndFill("homeLoanTenure_Id", "loantenure");
			clearAndFill("homeLoanFees_Id", "loanfees");
			clearAndFill("oneTimeExpenses_Id", "onetimeexpenses");
			clearAndFill("propertyTaxes_Id", "propertytaxes");
			clearAndFill("homeInsurance_Id", "homeinsurance");
			clearAndFill("maintenanceExpenses_Id", "maintenanceexpenses");
			logger.log(Status.INFO, "Data filled successfully");
			logger.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Copying data from the years table and pasting it into an Excel sheet

	public void storeDataInExcel() throws IOException {

		try {
			logger = report.createTest("Copying data from the years table into Excel");
			String years = prop.getProperty("loantenure");

			File file = new File(System.getProperty("user.dir") + "\\output-Excel\\HomeLoanEMI.xlsx");

			// Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);

			// Create workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);

			// Create a Sheet object using the sheet Name
			XSSFSheet sheet = wb.getSheet("Sheet1");

			// Create a row object to retrieve row at index 1
			XSSFRow row = sheet.createRow(1);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)", "");

			List<WebElement> column = driver.findElements(By.xpath("//table[@class='noextras']/tbody/tr[1]/th"));
			int yearcount = Integer.parseInt(years);
			yearcount = (yearcount * 2);

			for (int i = 1; i <= column.size(); i++) {
				String xpath = "//table[@class='noextras']/tbody/tr[1]/th[" + i + "]";
				String header = driver.findElement(By.xpath(xpath)).getText();
				row.createCell(i).setCellValue(header);
			}

			XSSFRow row1 = null;
			for (int i = 2; i <= yearcount; i++) {
				row1 = sheet.createRow(i);
				for (int j = 1; j <= column.size(); j++) {
					String xpath1 = "//table[@class='noextras']/tbody/tr[" + i + "]/td[" + j + "]";
					String data = driver.findElement(By.xpath(xpath1)).getText();
					row1.createCell(j).setCellValue(data);
				}
				i = i + 1;
			}

			// Write's the HOME LOAN RESULT TABLE to excel using output stream

			FileOutputStream outputStream = new FileOutputStream(
					System.getProperty("user.dir") + "\\output-Excel\\HomeLoanEMI.xlsx");
			wb.write(outputStream);
			wb.close();

			logger.log(Status.INFO, "Data stored successfully");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(8, 3, "Pass");

		} catch (NumberFormatException e) {
			RunScriptWriteExcel.write(8, 3, "Fail");
			reportFail(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			RunScriptWriteExcel.write(8, 3, "Fail");
			reportFail(e.getMessage());
		} catch (IOException e) {
			RunScriptWriteExcel.write(8, 3, "Fail");
			reportFail(e.getMessage());
		}

	}

}
