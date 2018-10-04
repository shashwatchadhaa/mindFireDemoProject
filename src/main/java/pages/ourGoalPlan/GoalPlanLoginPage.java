package pages.ourGoalPlan;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.PropertiesFileManager;
import testUtils.Utility;

public class GoalPlanLoginPage extends PageBase {

	private By goalPlanLogo = By.id("Image1");
	private By userId = By.id("txtName");
	private By password = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");
	
	
	
	
	
	
	
	
	public GoalPlanLoginPage()
	{
		waitForPageLoad(pageLoadCondition(),10);
	}

	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(goalPlanLogo);
	}

	public GoalPlanHomePage login(String userName, String pass) {
		Utility.setData(userId, userName, "Username textbox");
		Utility.setData(password, pass, "Password textbox");
		Utility.clickElement(loginButton, "Login button");
		return new GoalPlanHomePage();
	}
	
	public static GoalPlanLoginPage gotoGoalPlan()
	{
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("goalPlanUrl"));
//		BasicConfigurator.configure();
//		PropertyConfigurator.configure("C:\\Users\\Shashwat Chadha\\eclipse-workspace\\YahooMail\\src\\main\\resources\\propertiesFiles\\log4j.properties");
//		Logger log = Logger.getLogger("C:\\Users\\Shashwat Chadha\\eclipse-workspace\\YahooMail\\src\\main\\resources\\propertiesFiles\\log4j.properties");
//		log.debug("navigated");
		return new GoalPlanLoginPage();
	}

}
