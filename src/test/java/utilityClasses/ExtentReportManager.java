package utilityClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager 
{
	public static ExtentReports report;
    public static ExtentSparkReporter htmlReporter;
	public static ExtentReports getReportInstance() 
	{
       try
       {
		if (report==null) 
		{
			String reportName = DateUtils.getTimeStamp() + ".html";
			htmlReporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/ExtentReports/" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browser", "Chrome");

			htmlReporter.config().setDocumentTitle("Interest Amount Calculator Automation Results");
			htmlReporter.config().setReportName("Interest Amount Calculator Test Report");
//			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
       }
       catch(Exception e)
       {
    	   System.out.println(e);
       }

		return report;
     }
}
