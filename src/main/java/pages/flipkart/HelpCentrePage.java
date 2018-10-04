package pages.flipkart;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class HelpCentrePage extends PageBase {

	private By helpText = By.xpath("//span[text()='How can we help you?']");

	private By helpTopics = By.xpath("//span[text()='Help Topics']//following-sibling::div//span");
	private By queryList = By.xpath("//div[contains(@class,'_1zQAJA')]//div[@class='_3aS5mM']");
	private By topicName = By.xpath("//div[@class='_2Srbv0']");
	private By extendedList = By.xpath("//span[@class='_1r1MfC']");
	private By subTopic = By.xpath("//div[@class='_1P245N']");

	private By showMore = By.xpath("//span[text()='View More']");

	public HelpCentrePage() {
		waitForPageLoad(pageLoadCondition(), 10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(helpText);
	}

	public HashMap<String, Integer> getTopicQuery() {

		HashMap<String, Integer> topicDetails = new HashMap<String, Integer>();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 5);
		String topicN = "";
		
	
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(helpTopics));

		List<WebElement> topicLists = Utility.getElements(helpTopics);
		if (topicLists.size() == 0)
			ExtentReport.logInReport(Status.FAIL, "NO help topics are present.");
		for (WebElement topic : topicLists) {
			wait.until(ExpectedConditions.elementToBeClickable(topic));
			topicN = topic.getText();
			topic.click();
			
			if (Utility.isElementPresent(showMore))
				Utility.clickElement(showMore, "Show  more button for : " + topicN);
			topicDetails.put(topicN, Utility.getElements(queryList).size());

			if (Utility.isElementPresent(subTopic)) {
				List<WebElement> subTopicList = Utility.getElements(subTopic);
				for (WebElement subTopic : subTopicList) {
					wait.until(ExpectedConditions.elementToBeClickable(subTopic));
					subTopic.click();
					if (Utility.isElementPresent(showMore))
						Utility.clickElement(showMore, "Show  more button for : " + topic);
					topicDetails.put(topicN, Utility.getElements(queryList).size() + topicDetails.get(topicN));

				}
			}
		}
		return topicDetails;
	}

}
