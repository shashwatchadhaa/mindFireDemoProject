package yahooTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetup.TestBase;
import utilities.Utility;
public class SignUpTestCases extends TestBase{
	
	
	
	
	
	
	
	
	
	@Test
	public void SignUpToYahoo()
	{
		Utility.clickElement(By.id("createacc"), "Sign up link");
	Assert.fail();
	
	}
	
	
	
	

}
