package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;

public class Utility {

	
	
	private static String screenShotPath;
	
	
	public static void clickElement(By locator,String name)
	{
		
		DriverManager.getDriver().findElement(locator).click();
		ExtentReport.logInReport(Status.INFO, "Clicked on : <b>"+name+"</b>");
	
		
	}
	
	public static void setData(By locator,String data,String name)
	{
		DriverManager.getDriver().findElement(locator).sendKeys(data);
		ExtentReport.logInReport(Status.INFO, "Entered : "+data+ " in "+name);
	
	}
	
	public static void selectValue(By locator,String value)
	{
		Select select = new Select(DriverManager.getDriver().findElement(locator));
		select.selectByValue(value);
		ExtentReport.logInReport(Status.INFO, "Selected : "+value+ " from dropdown.");
	}
	
	
	
	
    


	
	
	
	
	public static void captureScreenShot()
	{
		 String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenShot =((TakesScreenshot)DriverManager.getDriver());
	    File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);
	    screenShotPath = System.getProperty("user.dir")+"\\"+"screenShot"+date+".png";
	    File finalDestination = new File(screenShotPath);
	    try {
			FileUtils.copyFile(SrcFile, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static String getScreenShotPath() {
		return screenShotPath;
	}

	
	@DataProvider
	public Object[][] getData(Method method) {

		ExcelManager excel = new ExcelManager(method.getName());
		HashMap<String, String> dataMap;

		int rowCount = excel.getRowCount();
		int cellCount = excel.getColumnCount();
		Object[][] dataPro = new Object[rowCount - 1][1];

		for (int i = 1; i < rowCount; i++) {
			dataMap = new HashMap<String, String>();
			for (int j = 0; j < cellCount; j++) {

				String key = excel.readExcel(0, j);

				String value = excel.readExcel(i, j);
				dataMap.put(key, value);

			}
			dataPro[i - 1][0] = dataMap;
		}
		return dataPro;
	}

}
