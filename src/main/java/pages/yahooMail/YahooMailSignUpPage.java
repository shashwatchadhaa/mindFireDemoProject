package pages.yahooMail;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseSetup.DriverManager;
import pages.PageBase;
import utilities.Utility;

public class YahooMailSignUpPage extends PageBase {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private By firstName = By.id("usernamereg-firstName");
	private By lastName = By.id("usernamereg-lastName");
	private By  mailId = By.id("usernamereg-yid");
	private By password = By.id("usernamereg-password");
	private By countryCode = By.xpath("//select[@name='shortCountryCode']");
	private By setMobileNumber = By.id("usernamereg-phone");
	private By birthMonth = By.id("usernamereg-month");
	private By birthDay = By.id("usernamereg-day");
	private By birthYear = By.id("usernamereg-year");
	private By continueButton = By.id("reg-submit-button");
	private By signUpLabel = By.xpath("//h1[contains(@class,'header') and contains(text(),'Sign')]");	
	private By suggestions = By.xpath("//ul[@id='desktop-suggestion-list']//li[1]");
	
	
	
	
	
	
	public YahooMailSignUpPage()
	{
		waitForPageLoad(pageLoadCondition(), 10);
	}
	
	
	
	public void setName(String fName,String lName)
	{
		Utility.setData(firstName, fName, "First Name Textbox");
		Utility.setData(lastName, lName, "Last Name Textbox");
		
	}
	public void setEmail(String mail,String pass)
	{
		Utility.setData(mailId, mail, "Email Textbox");
		Utility.clickElement(mailId, "");
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),2);
			WebElement drop = wait.until(ExpectedConditions.presenceOfElementLocated(suggestions));
			drop.click();
			}
			catch(TimeoutException e)
			{
				
			}
		Utility.setData(password, pass, "Password Textbox");
		
	}
	
	public void setDOB(String dob)
	{
		String[] dobArray= dob.split("/");
		Utility.setData(birthDay, dobArray[0], "Date of birth");
		
		Utility.selectValue(birthMonth, dobArray[1]);
		Utility.setData(birthYear, dobArray[2], "year of birth");
	}
	public void setPhoneNumber(String number)
	{
		
		Utility.setData(setMobileNumber, number, "Mobile number textbox.");
	}
	
	public void clickContinue()
	{
		Utility.clickElement(continueButton, "Continue button");
	}
	
	
	
	
	public void setEmail()
	{
		
		
		
	}
	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		return ExpectedConditions.presenceOfElementLocated(signUpLabel);
	}
	
	
	
	
	
	
	

}
