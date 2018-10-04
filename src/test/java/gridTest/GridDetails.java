package gridTest;

import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.gridPage.GridHomePage;

public class GridDetails extends TestBase{

	@Test
	public void getGridDetails()
	
	{
		GridHomePage homePage =GridHomePage.gotogridPage();
		homePage.writeGridText();
		
	}
}
