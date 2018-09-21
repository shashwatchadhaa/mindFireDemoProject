package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {

	
	
	
	
	
	
	
	
	private static ExtentReports extent;
	private static ExtentHtmlReporter extentHtmlReporter;
	private static String filePath = "report.htlm";
	
	
	private static 	ExtentTest test;
	
	
	public static void startExtent()
	{
		extentHtmlReporter = new ExtentHtmlReporter(filePath);
		extentHtmlReporter.setAppendExisting(false);
		extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\extentUtil\\extentConfig.xml");
		extent = new ExtentReports();
		extent.attachReporter(extentHtmlReporter);
	
	}
	
	
	
	
	public static void createTest(String testName,String description)
	{
	test = extent.createTest(testName, description);
	}
	
	
	
	
	
	public static void logInReport(Status status,String description)
	{
		test.log(status, description);
	}
	
	
	public static ExtentTest getTest()
	{
		return test;
	}
	
	public static void  flushReport()
	{
		
		extent.flush();
	}
	
	
}
