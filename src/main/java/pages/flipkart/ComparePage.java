package pages.flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class ComparePage extends PageBase {

	
	
	private By compareLabel = By.xpath("//span[text()='Compare']");
	
	private By productPrice =By.xpath("//div[contains(@class,'_1k1axX ')]//div[@class='_1vC4OE']");
	
	
	 public ComparePage() {
		waitForPageLoad(pageLoadCondition(),10);
	}
	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(compareLabel);
	}

	
	public void selectBestProduct()
	{
		List<WebElement> priceList=Utility.getElements(productPrice);
		int priceMin =Integer.parseInt(priceList.get(0).getText().substring(1).replace(",",""));
		int index=0;
		for(int i=1;i<=2;i++)
		{
			if(priceMin>Integer.parseInt(priceList.get(0).getText().substring(1).replace(",",""))) {
				priceMin = Integer.parseInt(priceList.get(0).getText().substring(1).replace(",",""));
				index=i;}
		}
		
		ExtentReport.logInReport(Status.INFO, "Best product is :"+Utility.getElement(By.xpath("//div[contains(@class,'_1SVp3c')]/div[@class='_1k1axX _1DLH7w']//div[@class='col-4-5']/div/div["+(index+2)+"]/a")).getText());
		ExtentReport.logInReport(Status.INFO,"Price for the product is : Rs."+priceMin);
		ExtentReport.logInReport(Status.INFO,"Product will get  delivered by : "+Utility.getElement(By.xpath("//div[@class='_3bNYmG']/div[4]/div["+(index+2)+"]//span")).getText());
		
		
	}
	
}
