package yahooTestCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import baseSetup.DriverManager;
import baseSetup.TestBase;
import pages.yahooMail.LoginPage;
import pages.yahooMail.YahooMailSignUpPage;
import utilities.PropertiesFileManager;
import utilities.Utility;

public class SignUpTestCases extends TestBase {

	private YahooMailSignUpPage signUpPage;
	private LoginPage loginObj;

	@Test(dataProvider = "getData", dataProviderClass = Utility.class, groups = { ("yahooa") })
	public void SignUpToYahoo(HashMap<String, String> dataMap) {
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("url"));
		loginObj = new LoginPage();
		signUpPage = loginObj.clickOnSignUp();
		signUpPage.setName(dataMap.get("firstName"), dataMap.get("lastName"));
		signUpPage.setEmail(dataMap.get("email"), dataMap.get("password"));
		signUpPage.setPhoneNumber(dataMap.get("phone"));
		signUpPage.setDOB(dataMap.get("dob"));
		signUpPage.clickContinue();

	}

	@Test(groups = { ("yahoo") })
	public void demoTest() {
		System.out.println("demo test");
	}

}
