package utilities;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;

public class Listners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		
		
		System.out.println(result.getMethod());
		System.out.println("On test success");
		
	}

	public void onTestFailure(ITestResult result) {
			ExtentReport.logInReport(Status.FAIL,"Test case method : "+result.getName()+" Failed.");
		
			ExtentReport.logInReport(Status.FAIL,"Exception Message : "	+result.getThrowable().toString());
			
			Utility.captureScreenShot();
		try {
			
			
		//	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			ExtentReport.getTest().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenShotPath()).build());
			//ExtentReport.getTest().fail("Fail").addScreenCaptureFromPath(Utility.getScreenShotPath());
						//ExtentReport.getTest().addScreencastFromPath(Utility.getScreenShotPath());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReport.logInReport(Status.FAIL,"Test case method : "+result.getName()+" Failed."+result.getThrowable().toString());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod());
		System.out.println("On test skip");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {

		
	}



}
