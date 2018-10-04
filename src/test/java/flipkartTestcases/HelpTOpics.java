package flipkartTestcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseSetup.TestBase;
import pages.flipkart.FlipkartHomePage;
import pages.flipkart.HelpCentrePage;
import testUtils.ExtentReport;

public class HelpTOpics extends TestBase {

	@Test(enabled = true)
	public void getHelpTopics() {
		FlipkartHomePage homePAgeObj = FlipkartHomePage.navigateToHomePage();
		homePAgeObj.closeLoginForm();
		HelpCentrePage helpPage = homePAgeObj.gotoCustomerCare();
		HashMap<String, Integer> queryList = helpPage.getTopicQuery();

		Set<Entry<String, Integer>> topicDetails = queryList.entrySet();

		for (Entry<String, Integer> topic : topicDetails) {
			ExtentReport.logInReport(Status.INFO, topic.getKey() + "  " + topic.getValue());

		}

	}
}
