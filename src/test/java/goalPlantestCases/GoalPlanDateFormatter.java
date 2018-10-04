package goalPlantestCases;

import org.testng.annotations.Test;

import baseSetup.TestBase;
import pages.ourGoalPlan.GoalPlanHomePage;
import pages.ourGoalPlan.GoalPlanLoginPage;

public class GoalPlanDateFormatter extends TestBase{

	
	
	@Test
	public void dateFormat()
	{
		GoalPlanLoginPage loginPage=GoalPlanLoginPage.gotoGoalPlan();
	GoalPlanHomePage homePage=	loginPage.login("shashwatc", "lenovoLAP2016#");
	homePage.checkUserName("Shashwat Chadha");
	String today = homePage.getToday();
	homePage.getDateInDiffFormats(today);
	homePage.getLastSundayDate();

		
	}
	
	
	
	
	
}
