package goalPlantestCases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseSetup.DatabaseManager;
import baseSetup.TestBase;
import pages.ourGoalPlan.GoalPlanHomePage;
import pages.ourGoalPlan.GoalPlanLoginPage;
import testUtils.ExtentReport;

public class GoalPlanJdbc extends TestBase {

	@Test(enabled = false)
	public void getGoalDetails() throws SQLException {
		GoalPlanLoginPage loginPage = GoalPlanLoginPage.gotoGoalPlan();
		GoalPlanHomePage homePage = loginPage.login("shashwatc", "lenovoLAP2016#");
		HashMap<String, String>[] goalDetails = homePage.getGoalDetails();
		boolean isPresent = false;
		ResultSet rs = DatabaseManager.sendQuery("Select * from GoalsGp where D='10/3/2018'");
		while (rs.next()) {
			for (int i = 0; i < goalDetails.length; i++) {
				HashMap<String, String> goal = goalDetails[i];
				if (rs.getString("goal").contains(goal.get("Goals"))) {
					ExtentReport.logInReport(Status.INFO, "Goal : " + rs.getString("goal") + " is present in DB");
					isPresent = true;
					break;
				}

			}
			if (!isPresent)
				ExtentReport.logInReport(Status.INFO, "Goal : " + rs.getString("goal") + " is not present.");

			// System.out.println("######"++"@@@@@@" + rs.getString(2)+"!!!!!!!!!!" +
			// rs.getString(3));

		}

	}

	@Test(enabled = true)
	public void insertGoalDetailsinDB() throws SQLException, ParseException {
		GoalPlanLoginPage loginPage = GoalPlanLoginPage.gotoGoalPlan();
		GoalPlanHomePage homePage = loginPage.login("shashwatc", "lenovoLAP2016#");
		int goalCount = homePage.getGoalCout();
		for (int i = 1; i < goalCount; i++) {
			HashMap<String, String> goalDetails = homePage.getGoalDateStatus(i + 1);
			System.out.println(
					"Insert into goalsTable values (DATE_FORMAT('" + goalDetails.get("Date") + "','%y-%m-%d'),'"
							+ goalDetails.get("Goals") + "'," + Boolean.parseBoolean(goalDetails.get("Status")) + ")");

			String query = "insert into goalsTable values (goalDate,goalDetail,goalStatus)" + "values (?, ?, ?)";
			PreparedStatement preparedStmt = DatabaseManager.getConnection().prepareStatement(query);

			String startDate = goalDetails.get("Date");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-ddd");
			java.util.Date date = sdf1.parse(startDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

			preparedStmt.setDate(1, sqlStartDate);
			preparedStmt.setString(2, goalDetails.get("Goals"));

			preparedStmt.setBoolean(3, false);
			DatabaseManager.insertData(
					"Insert into goalsTable values (DATE_FORMAT('" + goalDetails.get("Date") + "','%y-%m-%d'),'"
							+ goalDetails.get("Goals") + "'," + Boolean.parseBoolean(goalDetails.get("Status")) + ")");
		}

//		HashMap<String, String>[] goalDetails = homePage.getGoalDetails();
//		for (int i = 0; i < goalDetails.length; i++) {
//			HashMap<String, String> goalMap = goalDetails[i];
//			System.out.println(goalMap.get("Date") + goalMap.get("Status") + goalMap.get("Goals") + goalMap.get("Notes")
//					+ goalMap.get("Public"));
//
//			System.out.println("Insert into goalsGp values('" + goalMap.get("Date") + "','" + goalMap.get("Status")
//					+ "','" + goalMap.get("Goals") + "','" + goalMap.get("Notes") + "','" + goalMap.get("Public")
//					+ "')");
//			DatabaseManager.insertData("Insert into goals values('" + goalMap.get("Date") + "','"
//					+ goalMap.get("Status") + "','" + goalMap.get("Goals") + "','" + goalMap.get("Notes") + "','"
//					+ goalMap.get("Public") + "')");
//
//		}

	}
}
