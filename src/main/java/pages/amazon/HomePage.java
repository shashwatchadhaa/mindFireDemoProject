package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import utilities.PropertiesFileManager;
import utilities.Utility;

public class HomePage extends PageBase{

	
	
	
	
	
	
	
	By searchBar = By.id("twotabsearchtextbox");
	By amazonLogo = By.xpath("//span[contains(@class,'logo') and text()='Amazon']");
	
	
	
	public HomePage()
	{
		waitForPageLoad(pageLoadCondition(), 10);
	}
	
	
	public static HomePage navigateToHomePage()
	{
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("amazonUrl"));
		return new HomePage();
		
	}
	
	public void setSearchBar(String searchItem)
	{
		Utility.setData(searchBar,searchItem, "Search textbox");
		DriverManager.getDriver().findElement(searchBar).sendKeys(Keys.ENTER);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		return ExpectedConditions.presenceOfElementLocated(amazonLogo);
	}
	
	

	
	

	
}
