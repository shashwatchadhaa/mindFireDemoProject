package amazonTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.amazon.HomePage;
import pages.amazon.SearchItemPage;

public class AddItemToCart extends TestBase{
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(enabled = false)
	public void addItemToCartAndVerify()
	{
		HomePage homePageObj = HomePage.navigateToHomePage();
		SearchItemPage searchPage = homePageObj.setSearchBar("Kindle");
	
		
		

	}
	

	
	
	
	
	
	
	
	
	

}
