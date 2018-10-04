package pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.PropertiesFileManager;
import testUtils.Utility;

public class FlipkartHomePage extends PageBase {

	private By flipkartLogo = By.xpath("//img[@title='Flipkart']");

	private By searchTextBox = By.xpath("//input[contains(@title,'Search')]");

	private By submitButton = By.xpath("//button[@type='submit']");
	private By closeButton = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By electronicsMenu = By.xpath("//header//span[contains(text(),'Electronics')]");
	private By canon = By.xpath("//div[@class='EstLIe']//p[text()='Canon']");
	private By dslrMenu = By.xpath("//a[@title='DSLR']");
private By moreHower = By.xpath("//span[text()='More']");
private By customerCare = By.xpath("//div[text()='24x7 Customer Care']");
	public FlipkartHomePage() {
		waitForPageLoad(pageLoadCondition(), 10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(flipkartLogo);
	}

	public SearchItemsPage clickSearch() {
		Utility.clickElement(submitButton, "Search button");
		return new SearchItemsPage();

	}

	public void setSearchBox(String item) {
		Utility.setData(searchTextBox, item, "Search item textbox");
	}

	public void closeLoginForm() {
		Utility.clickElement(closeButton, "Close login form button");
	}

	public static FlipkartHomePage navigateToHomePage() {
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("flipkartUrl"));
		return new FlipkartHomePage();

	}

	public SearchItemsPage gotoDslr() {
		Actions action = new Actions(DriverManager.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),5);
		action.moveToElement(Utility.getElement(electronicsMenu)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(dslrMenu));
		Utility.clickElement(dslrMenu, "Dslr menu link");
		return new SearchItemsPage();
	}

	
	public HelpCentrePage gotoCustomerCare()
	{
		Actions action = new Actions(DriverManager.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),5);
		action.moveToElement(Utility.getElement(moreHower)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(customerCare));
		Utility.clickElement(customerCare, "24x7 Customer Care menu link");
		return new HelpCentrePage();
	}
	
	
	
	
	
}
