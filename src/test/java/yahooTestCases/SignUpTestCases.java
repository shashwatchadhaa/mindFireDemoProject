package yahooTestCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import baseSetup.DriverManager;
import baseSetup.TestBase;
import pages.yahooMail.LoginPage;
import pages.yahooMail.YahooMailSignUpPage;
import testUtils.PropertiesFileManager;
import testUtils.Utility;

public class SignUpTestCases extends TestBase {

	private YahooMailSignUpPage signUpPage;
	private LoginPage loginObj;

	@Test(dataProvider = "getData", dataProviderClass = Utility.class,enabled=false)
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


}
