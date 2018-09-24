package amazonTestCases;

import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.amazon.HomePage;

public class AddItemToCart extends TestBase{
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(groups= {"amazon"})
	public void addItemToCartAndVerify()
	{
		HomePage homePageObj = HomePage.navigateToHomePage();
		homePageObj.setSearchBar("kindle");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
