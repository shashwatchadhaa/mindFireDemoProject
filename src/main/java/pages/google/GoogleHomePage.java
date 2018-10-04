package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import pages.flipkart.FlipkartHomePage;
import testUtils.PropertiesFileManager;
import testUtils.Utility;

public class GoogleHomePage extends PageBase {

	private By googleLogo = By.xpath("//div[@id='hplogo']");
	
	private By  googleBar = By.id("lst-ib");
	
	public GoogleHomePage()
	{
		//waitForPageLoad(pageLoadCondition(), 10);
	}
	
	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		
		return ExpectedConditions.presenceOfElementLocated(googleLogo);
	}

	public static GoogleHomePage gotoGoogle()
	{
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("googleUrl"));
		return new GoogleHomePage();
	}
	
	public GoogleSearchPage setGoogleSearchBar(String data)
	{
		Utility.setData(googleBar, data, "Google search bar");
		Utility.getElement(googleBar).sendKeys(Keys.ENTER);
		return new GoogleSearchPage();
	}
	
	
	
	
}
