package pages.ourGoalPlan;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pages.PageBase;
import testUtils.ExtentReport;
import testUtils.Utility;

public class GoalPlanHomePage extends PageBase {

	private By mindFireLogo = By.xpath("//img[@alt='mindfire logo']");
	private By todaysDate = By.id("lblGoalDate");
	private By lastSunday = By.xpath("//table[@id='calendar']//a[contains(@style,'White')]/../..//td[1]");
	private By presentMonth = By.xpath("//table[@id='calendar']//table//tr/td[2]");
	private By userName = By.id("hyplinkMember");
	private By previousSunday = By
			.xpath("//table[@id='calendar']//a[contains(@style,'White')]/../..//preceding-sibling::tr[1]//td[1]/a");
	private By firstSunday = By.xpath("//table[@id='calendar']//tr[4]//td[1]/a");
	private By previousMonth = By.xpath("//a[contains(@title,'previous')]");
	private By previousMSunday = By.xpath("//table[@id='calendar']//tr[7]//td[1]/a");

	private By goalsCount = By.xpath("//table[@id='dgGoals']//tr");

	public GoalPlanHomePage() {
		waitForPageLoad(pageLoadCondition(), 10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(mindFireLogo);
	}

	public int getGoalCout() {
		return Utility.getElements(goalsCount).size();
	}

	public HashMap<String, String> getGoalDateStatus(int index) {

		HashMap<String, String> goalMap = new HashMap<String, String>();
		goalMap.put("Date",
				Utility.dateFormatter("E, MMMM dd, yyyy", Utility.getElement(todaysDate).getText(), "yyyy-MM-dd"));
		goalMap.put("Goals",
				Utility.getElement(
						By.xpath("//table[@id='dgGoals']//tr[" + index + "]//span[contains(@id,'lblGoals')]"))
						.getText());
		goalMap.put("Status",
				Boolean.toString(Utility
						.getElement(
								By.xpath("//table[@id='dgGoals']//tr[" + index + "]//input[contains(@id,'chkStatus')]"))
						.isSelected()));
	
	return goalMap;
	}

	public HashMap<String, String>[] getGoalDetails() {
		int goalCount = Utility.getElements(goalsCount).size();
		HashMap<String, String>[] goalArray = new HashMap[goalCount - 1];
		for (int i = 2; i <= goalCount; i++) {
			HashMap<String, String> goalMap = new HashMap<String, String>();
			goalMap.put("Date", Utility.getElement(By.id("ucAddGoal_dtGoalDate_label")).getText());
			goalMap.put("Status",
					Boolean.toString(Utility
							.getElement(
									By.xpath("//table[@id='dgGoals']//tr[" + i + "]//input[contains(@id,'chkStatus')]"))
							.isSelected()));
			goalMap.put("Goals",
					Utility.getElement(
							By.xpath("//table[@id='dgGoals']//tr[" + i + "]//span[contains(@id,'lblGoals')]"))
							.getText());
			goalMap.put("Notes",
					Utility.getElement(
							By.xpath("//table[@id='dgGoals']//tr[" + i + "]//input[contains(@id,'txtNotes')]"))
							.getAttribute("value"));
			goalMap.put("Public",
					Utility.getElement(
							By.xpath("//table[@id='dgGoals']//tr[" + i + "]//input[contains(@id,'chkGoalVisibility')]"))
							.getAttribute("checked"));
			goalArray[i - 2] = goalMap;
		}

		return goalArray;

	}

	public String getToday() {
		return Utility.getElement(todaysDate).getText();
	}

	public void getDateInDiffFormats(String date) {
		ExtentReport.logInReport(Status.INFO, Utility.dateFormatter("E, MMMM dd, yyyy", date, "MM/dd/yy"));
		ExtentReport.logInReport(Status.INFO, Utility.dateFormatter("E, MMMM dd, yyyy", date, "E, dd,MM,yyyy"));
		ExtentReport.logInReport(Status.INFO, Utility.dateFormatter("E, MMMM dd, yyyy", date, "dd-MMMM-yy"));
		ExtentReport.logInReport(Status.INFO, Utility.dateFormatter("E, MMMM dd, yyyy", date, "yyyy, dd MM"));
		ExtentReport.logInReport(Status.INFO, Utility.dateFormatter("E, MMMM dd, yyyy", date, "MMMM-dd-yyyy"));

	}

	public void getLastSundayDate() {

		String lastSundayDate = "";
		String currentDayDate = "";
		String classStyle = "";
		currentDayDate = Utility.getElement(firstSunday).getText();
		if (currentDayDate.equals("1")) {
			Utility.clickElement(previousMonth, "Go to previous month");
			lastSundayDate = Utility.getElement(previousMSunday).getText() + " "
					+ Utility.getElement(presentMonth).getText();
		}
		try {
			classStyle = Utility.getElement(lastSunday).getAttribute("style");
		} catch (Exception e) {
		}
		if (classStyle.contains("white"))
			lastSundayDate = Utility.getElement(previousSunday).getText() + " "
					+ Utility.getElement(presentMonth).getText();
		else
			lastSundayDate = Utility.getElement(lastSunday).getText() + " "
					+ Utility.getElement(presentMonth).getText();
		ExtentReport.logInReport(Status.INFO, "Last sunday was on: " + lastSundayDate);

	}

	public void checkUserName(String expectedName) {
		String actualUsername = Utility.getElement(userName).getText();
		ExtentReport.logInReport(Status.INFO, "User name of logged in user is : " + actualUsername);
		Assert.assertEquals(actualUsername, expectedName);
	}

}
