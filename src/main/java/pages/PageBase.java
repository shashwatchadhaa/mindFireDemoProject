package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseSetup.DriverManager;

public abstract class PageBase {
	
	
	
	public abstract  ExpectedCondition<WebElement> pageLoadCondition();

	public void waitForPageLoad(ExpectedCondition<WebElement>  expectedCondition,int timeOutInSeconds)
	{
		try {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
	wait.until(expectedCondition);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Page is not loaded.");
		}
	}
	
	
}
