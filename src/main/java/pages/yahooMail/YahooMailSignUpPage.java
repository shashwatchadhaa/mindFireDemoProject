package pages.yahooMail;

import org.openqa.selenium.By;

import utilities.Utility;

public class YahooMailSignUpPage {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setName(String fName,String lName)
	{
		Utility.setData(firstName, fName, "First Name Textbox");
		Utility.setData(lastName, lName, "Last Name Textbox");
		
	}
	public void setEmail(String mail,String pass)
	{
		Utility.setData(mailId, mail, "Email Textbox");
		Utility.setData(password, pass, "Password Textbox");
		
	}
	
	public void setDOB(String dob)
	{
		String[] dobArray= dob.split("/");
		Utility.setData(birthDay, dobArray[0], "Date of birth");
		
		Utility.selectValue(birthMonth, dobArray[1]);
		Utility.setData(birthYear, dobArray[2], "year of birth");
	}
	public void setPhoneNumber(long number)
	{
		Utility.selectValue(countryCode, "+91");
		Utility.setData(setMobileNumber, Long.toString(number), "Mobile number textbox.");
	}
	
	public void clickContinue()
	{
		Utility.clickElement(continueButton, "Continue button");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
