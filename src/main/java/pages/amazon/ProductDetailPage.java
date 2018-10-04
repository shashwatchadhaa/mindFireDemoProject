package pages.amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class ProductDetailPage extends PageBase {

	private By productTitle = By.xpath("//span[@id='productTitle']");

	private By rating = By.xpath("//div[@id='averageCustomerReviews_feature_div']//span[@id='acrPopover']//span[@class='a-icon-alt']");
	private By ratingTable = By.xpath("//div[@class='a-popover-inner']//table[@id='histogramTable']//tr//td[2]/a");

	public ProductDetailPage() {
		Utility.switchtoLatestWindow(HomePage.homeWindowHAndle);
		waitForPageLoad(pageLoadCondition(), 10);
		ExtentReport.logInReport(Status.INFO,"Product name is : "+Utility.getElement(productTitle).getText());
	}

	public void getRating() {
		
		if (Utility.isElementPresent(rating)) {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(Utility.getElement(rating)).build().perform();
			
			//Utility.clickElement(rating, "Star rating");
			List<WebElement> ratingtTableList = Utility.getElements(ratingTable);
			for (WebElement ratings : ratingtTableList) {
				ExtentReport.logInReport(Status.INFO, ratings.getAttribute("title"));
			}
		}
		else
			ExtentReport.logInReport(Status.FAIL,"NO customer rating is present for this  product");
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(productTitle);
	}

}
