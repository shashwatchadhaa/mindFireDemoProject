package testUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;

public class Utility extends DriverManager {

	
	
	private static String screenShotPath;
	
	
	public static void clickElement(By locator,String name)
	{
		
		getDriver().findElement(locator).click();
		if(name!="")
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
		select.selectByVisibleText(value);
		ExtentReport.logInReport(Status.INFO, "Selected : "+value+ " from dropdown.");
	}
	
	
	public static List<WebElement> getElements(By locator)
	{
		return DriverManager.getDriver().findElements(locator);
	}
	
	

	
	
	public static WebElement getElement(By locator)
	{
		return DriverManager.getDriver().findElement(locator);
	}
	
    
	
	
	public static boolean isElementPresent(By locator)
	{
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			
		DriverManager.getDriver().findElement(locator);
		return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		finally {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
	}
	
	public static void captureScreenShot()
	{
		 String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenShot =((TakesScreenshot)DriverManager.getDriver());
	    File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);
	 screenShotPath = "./extentreport/screenShot"+date+".png";
	 //   screenShotPath = System.getProperty("user.dir")+"\\test-output\\extentreport\\screenShot\\"+date+".png";
	    File finalDestination = new File(screenShotPath);
	    try {
			FileUtils.copyFile(SrcFile, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    screenShotPath = "./screenShot"+date+".png";
	}
	
	
	

	public static void switchtoLatestWindow(String homeWindow)
	{
		Set<String> windowHandles=DriverManager.getDriver().getWindowHandles();
		for(String window:windowHandles)
		{
			if(!window.equals(homeWindow))
			DriverManager.getDriver().switchTo().window(window);
		}
		
	}
	

	public static String getScreenShotPath() {
		return screenShotPath;
	}

	
	
	public static String dateFormatter(String format,String date,String resultDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat(resultDate);
		String resultingDate="";
		try {
			resultingDate= dateFormat2.format(dateFormat.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultingDate;
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
