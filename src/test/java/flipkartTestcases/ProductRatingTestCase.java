package flipkartTestcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.flipkart.FlipkartHomePage;
import pages.flipkart.SearchItemsPage;

public class ProductRatingTestCase extends TestBase {

	
	
	@Parameters({"searchedItem"})
	@Test(enabled = true)
	public void getHighestRatedProduct(String searchedItem)
	{
		FlipkartHomePage homePAgeObj =FlipkartHomePage.navigateToHomePage();
		homePAgeObj.closeLoginForm();
		homePAgeObj.setSearchBox(searchedItem);
		SearchItemsPage searchPage= homePAgeObj.clickSearch();
		float highestRating = searchPage.getHighestRating(searchPage.getRatingList());
		searchPage.getHighestratedItemDetails(highestRating);
		
	}
	
	
	@Test
	public void highestNumberRating()
	{
		FlipkartHomePage homePAgeObj =FlipkartHomePage.navigateToHomePage();
		homePAgeObj.closeLoginForm();
		homePAgeObj.setSearchBox("camera");
		SearchItemsPage searchPage= homePAgeObj.clickSearch();
		searchPage.getHighestNumberRating(searchPage.getRatingNumber());
	}
	
}
