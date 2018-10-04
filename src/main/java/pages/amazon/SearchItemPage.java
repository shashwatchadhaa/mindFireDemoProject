package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.Utility;

public class SearchItemPage extends PageBase {

	private By searchCount = By.cssSelector("#s-result-count");
	private By firstProduct = By.xpath("//li[@id='result_0']//a[contains(@class,'access')]");
	String searchedItem;

	public SearchItemPage(String searchedItem) {
		this.searchedItem = searchedItem;
		waitForPageLoad(pageLoadCondition(), 10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		return ExpectedConditions.presenceOfElementLocated(searchCount);
	}

	public ProductDetailPage selectFirstProduct()
	{
		Utility.clickElement(firstProduct, "First searched  product");
		return new ProductDetailPage();
	}

}
