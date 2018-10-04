package pages.google;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class GoogleSearchPage extends PageBase {

	private By googleLogo = By.id("logocont");

	private By links = By.xpath("//div[@id='ires']//h3//a");
	private By links2 = By.xpath("//div[@id='ires']//a//h3");
private	String currentWindow ;

	public GoogleSearchPage() {
		waitForPageLoad(pageLoadCondition(), 10);
		currentWindow = DriverManager.getDriver().getWindowHandle();
	}

	public List<WebElement> getLinkDetails() {
		List<WebElement> linkList = Utility.getElements(links);
		if (linkList.size() == 0) {
			// ExtentReport.logInReport(Status.FAIL, "No search record is present for the
			// searched keyword.");
			linkList = Utility.getElements(links2);
		}
		if (linkList.size() == 0)
			ExtentReport.logInReport(Status.FAIL, "No search record is present for the searched keyword.");
		ExtentReport.logInReport(Status.INFO, "Number of links present  are : " + linkList.size());

		for (WebElement link : linkList) {
			if(link.isDisplayed())
			ExtentReport.logInReport(Status.INFO, "LinkText: " + link.getText());
		}
		return linkList;
	}

	public void openLinkInNewTab(WebElement linksList) {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		linksList.sendKeys(selectLinkOpeninNewTab);
	}

	public void getWindowsTitle() {
		
		Set<String> openWindows = DriverManager.getDriver().getWindowHandles();
		for (String openWindow : openWindows) {
			if (!openWindow.equals(currentWindow)) {
				DriverManager.getDriver().switchTo().window(openWindow);

				ExtentReport.logInReport(Status.INFO, "Title of  link is : " + DriverManager.getDriver().getTitle());
				DriverManager.getDriver().close();
				DriverManager.getDriver().switchTo().window(currentWindow);
			}
		}

	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOfElementLocated(googleLogo);
	}

}
