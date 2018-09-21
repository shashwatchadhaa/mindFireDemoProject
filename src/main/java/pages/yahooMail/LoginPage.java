package pages.yahooMail;

import org.openqa.selenium.By;

import utilities.Utility;

public class LoginPage {
	
	
		private By signUpButton = new By.ById("createacc");
		
		
		
		
		public YahooMailSignUpPage clickOnSignUp()
		{
			Utility.clickElement(signUpButton, "Sign up button.");
			return new YahooMailSignUpPage();
		}

}
