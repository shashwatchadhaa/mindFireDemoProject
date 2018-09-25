package baseSetup;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import testUtils.ExcelManager;
import testUtils.ExtentReport;
import testUtils.PropertiesFileManager;



@Listeners(testUtils.Listners.class)
public class TestBase {

	private String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\TestData.xls";
	private String configFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\propertiesFiles\\config.properties";

	private String testCaseRepoPath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\propertiesFiles\\testCaseRepository.properties";

	@BeforeSuite
	public void beforeSuite() {
		ExcelManager.setExcelPath(excelFilePath);
		PropertiesFileManager.setConfigFilePath(configFilePath);
		PropertiesFileManager.setTestCaseRepoPath(testCaseRepoPath);
		PropertiesFileManager.loadTestCaseRepository();
		PropertiesFileManager.loadConfigProperties();
		ExtentReport.startExtent();

	}fggfsd

	@BeforeTest
	public void beforeTest() {

	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		DriverManager.setBrowser(browser);
		System.out.println("before class" + browser);
	}

	// PropertiesFileManager.getConfigProperty("browser")

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {

		ExtentReport.createTest(PropertiesFileManager.getTestCaseProperty(method.getName()), "");

		DriverManager.launchBrowser();

	}

	@AfterMethod
	public synchronized void afterMethod() {
		DriverManager.quitBrowser();
		ExtentReport.flushReport();

	}

	@AfterClass()
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuite() {

	}

}
