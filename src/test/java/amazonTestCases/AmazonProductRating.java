package amazonTestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.amazon.HomePage;
import pages.amazon.ProductDetailPage;
import pages.amazon.SearchItemPage;

public class AmazonProductRating extends TestBase{
	
	
	
	
	@Parameters({"productAmazon"})
	
	@Test(enabled=true)
	public void getCustomerRating(String productAmazon)
	{
		HomePage homePageObj = HomePage.navigateToHomePage();
		SearchItemPage searchPage = homePageObj.setSearchBar(productAmazon);	
		ProductDetailPage detailsPage = searchPage.selectFirstProduct();
		detailsPage.getRating();
		
	}

}
