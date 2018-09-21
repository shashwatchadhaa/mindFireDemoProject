package yahooTestCases;

import java.util.HashMap;

import org.testng.annotations.Test;



import baseSetup.TestBase;
import utilities.Utility;

public class RoughTestCase extends TestBase {
	
	
	
	
	
	
	@Test(dataProvider="getData",dataProviderClass=Utility.class)
	public void test1(HashMap<String,String> testData)
	{
		System.out.println(testData.get("name"));
		
	}

}
