package yahooTestCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.yahooMail.LoginPage;
import pages.yahooMail.YahooMailSignUpPage;
public class SignUpTestCases extends TestBase{
	
	
	
	
	
	private YahooMailSignUpPage signUpPage ;
	private LoginPage loginObj;
	
	
	
	@Test(dataProvider="getData",dataProviderClass=utilities.Utility.class)
	public void SignUpToYahoo(HashMap<String, String> dataMap)
	{loginObj = new LoginPage();
		signUpPage = loginObj.clickOnSignUp();
		signUpPage.setName(dataMap.get("firstName"), dataMap.get("lastName"));
		signUpPage.setEmail(dataMap.get("email"),dataMap.get("password"));
		signUpPage.setDOB(dataMap.get("dob"));
		signUpPage.setPhoneNumber(Long.parseLong(dataMap.get("phone")));
		signUpPage.clickContinue();

	}
	
	
	
	

}
