package googleTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.google.GoogleHomePage;
import pages.google.GoogleSearchPage;

public class GoogleLinks extends TestBase {

	@Parameters({ "searchKeyword" })
	@Test(enabled = true)
	public void googleLinksScenario(String searchKeyword) {
		GoogleHomePage homePage = GoogleHomePage.gotoGoogle();
		GoogleSearchPage searchPage = homePage.setGoogleSearchBar(searchKeyword);
		List<WebElement> linksList = searchPage.getLinkDetails();
		searchPage.openLinkInNewTab(linksList.get(0));
		searchPage.openLinkInNewTab(linksList.get(1));
		searchPage.getWindowsTitle();
		

	}
}
