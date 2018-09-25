package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.Utility;

public class SearchItemPage extends PageBase {

	By searchCount = By.cssSelector("#s-result-count");
	String searchedItem;
	

	public SearchItemPage(String searchedItem) {
		this.searchedItem = searchedItem;
		waitForPageLoad(pageLoadCondition(), 10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		return ExpectedConditions.presenceOfElementLocated(searchCount);
	}

	

	
	
}
