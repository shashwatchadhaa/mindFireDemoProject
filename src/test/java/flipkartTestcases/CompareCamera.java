package flipkartTestcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.flipkart.ComparePage;
import pages.flipkart.FlipkartHomePage;
import pages.flipkart.SearchItemsPage;

public class CompareCamera extends TestBase {

	@Test(enabled = true)
	public void compareCameraTestCase() {
		FlipkartHomePage homePAgeObj = FlipkartHomePage.navigateToHomePage();
		homePAgeObj.closeLoginForm();
		SearchItemsPage itemPage = homePAgeObj.gotoDslr();
		ComparePage comparePage = itemPage.clickCompare();
		comparePage.selectBestProduct();

	}
}
