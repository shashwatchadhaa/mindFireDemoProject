package pages.flipkart;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class SearchItemsPage extends PageBase {

	private By ratingList = By.xpath("//span[contains(@id,'productRating')]//div");
	private By ratingNumber = By.xpath("//span[@class='_38sUEc']/span/span[1]");

	private By productGrid = By.xpath("//div[contains(@class,'bhgxx2')]");
	private By selectedItem = By.xpath("//div[@class='_3wU53n']");

	// private By compareCheckBox =
	// By.xpath("//a[@class='_31qSD5']//input[@class='_3uUUD5' and
	// @type='checkbox']");
	private By compareCheckBox = By.cssSelector("._1iHA1p");
	private By compareButton = By.xpath("//span[text()='COMPARE']");

	public SearchItemsPage() {
		waitForPageLoad(pageLoadCondition(), 10);
	}

	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(productGrid);
	}

	
	public List<WebElement> getRatingNumber()
	{
		List<WebElement> ratingNumberList = Utility.getElements(ratingNumber);
		if (ratingNumberList.size() == 0)
			Assert.fail("No Items found for this searched product.");

		return ratingNumberList;
	}
	public List<WebElement> getRatingList() {
		List<WebElement> ratingLists = Utility.getElements(ratingList);
		if (ratingLists.size() == 0)
			Assert.fail("No Items found for this searched product.");

		return ratingLists;

	}
	
	
	
	
	public void getHighestNumberRating(List<WebElement> ratingNumberList)
	{
	int highest=0;
	int index=0;
	for (int i=0;i<ratingNumberList.size();i++) {
		int ratingText = Integer.parseInt(ratingNumberList.get(i).getText().replaceAll("[a-zA-Z ,]",""));
		if(ratingText>highest) {
		
			highest=ratingText;
			index=i;
		}
	}
	ExtentReport.logInReport(Status.INFO,"Product with highest number of rating is: "+Utility.getElement(By.xpath("//div[contains(@class,'_1HmYoV hCUpcT')]/div[2]/div["+(index+2)+"]//div[@class='_3wU53n']")).getText()+" with rating :"+Utility.getElement(By.xpath("//div[contains(@class,'_1HmYoV hCUpcT')]/div[2]/div["+(index+1)+"]//span[@class='_38sUEc']/span/span[1]")).getText());

	}

	public float getHighestRating(List<WebElement> ratingList)

	{

		float tempNumber = 0;
		float highest = 0;
		
	//	Float.parseFloat(ratingList.get(0).getText().substring(0, 3).replace("?", "").replace(" ", ""));

		for (WebElement rating : ratingList) {
			String ratingText = rating.getText();

			if (ratingText.contains("."))
				tempNumber = Float.parseFloat(rating.getText().substring(0, 3));
			else
				tempNumber = Float.parseFloat(rating.getText().substring(0, 1));
			if (tempNumber > highest) {
				highest = tempNumber;
			}
		}

		return highest;

	}
	
	
	

	public void getHighestratedItemDetails(float highestRating) {

		List<WebElement> itemList = Utility
				.getElements(
						By.xpath("//div[contains(text(),'" + highestRating + "')]/../../..//div[@class='_3wU53n']"));
		for (WebElement item:itemList) {
			//String productName = Utility
				//	.getElement(
					//		By.xpath("//div[contains(text(),'" + highestRating + "')]/../../..//div[@class='_3wU53n']"))
					//.getText();
			ExtentReport.logInReport(Status.INFO,
					"HIghest rated product is : " + item.getText() + " with rating as : " + highestRating);
		}

	}

	public ComparePage clickCompare() {
		List<WebElement> compareCheckboxList = Utility.getElements(compareCheckBox);
		List<WebElement> productNameList = Utility.getElements(selectedItem);
		// HashMap<Integer, String> productDetails = new HashMap<>();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		if (compareCheckboxList.size() == 0) {
			Assert.fail("Compare checkbox is not present.");
		}

		for (int i = 0; i < 3; i++) {
//productDetails.put(i, productNameList.get(i).getText().replaceAll("...",""));
//System.out.println(productNameList.get(i).getText());
			compareCheckboxList.get(i).click();
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(compareButton));
			} catch (TimeoutException e)

			{
				Assert.fail("Compare button is not visible after checking add to compare checkbox");
			}
		}

		Utility.clickElement(compareButton, "Compare button.");

		return new ComparePage();

	}
}