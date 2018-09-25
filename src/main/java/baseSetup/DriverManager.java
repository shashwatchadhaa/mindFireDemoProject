package baseSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;

import testUtils.ExtentReport;


public class DriverManager {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

		
	private static String browser;
	private static String driverPath=System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\";

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	public static void setThreadDriver(WebDriver webDriver) {
		threadDriver.set(webDriver);
	}

	
	
	
	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		DriverManager.browser = browser;
	}

	public static void launchBrowser() {

		
	 WebDriver driver=null;

	
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			setThreadDriver(driver);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			setThreadDriver(driver);
		

		}
		ExtentReport.logInReport(Status.INFO, "Launched <b>"+browser.toUpperCase()+"</b> browser.");
	}
	

	
	public static void quitBrowser()
	{
		getDriver().quit();
	
		ExtentReport.logInReport(Status.INFO,"Closed browser");
	}
	
	
	public static void navigateTo(String url)
	{
		getDriver().navigate().to(url);
		ExtentReport.logInReport(Status.INFO,"Navigated to url : <b>"+url+"</b>");
	}
	
	
	
	
	
}
