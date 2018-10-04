package goalPlantestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.ourGoalPlan.GoalPlanHomePage;
import pages.ourGoalPlan.GoalPlanLoginPage;
import testUtils.Utility;

public class GoalByDate {

	
	
	
	
	
	
	
	
	@Test
	public void getGoals(String date)
	{
		GoalPlanLoginPage loginPage = GoalPlanLoginPage.gotoGoalPlan();
		GoalPlanHomePage homePage = loginPage.login("shashwatc", "lenovoLAP2016#");
		
		
		if(date.split("/")[0].equals("09"))
			Utility.clickElement(By.xpath("//a[contains(@title,'previous')]"), "previous button");
		
	}
}
