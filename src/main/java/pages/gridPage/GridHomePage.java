package pages.gridPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseSetup.DriverManager;
import pages.PageBase;
import testUtils.ExcelManager;
import testUtils.PropertiesFileManager;
import testUtils.Utility;

public class GridHomePage extends PageBase{

	
	
	
	private By  about = By.id("about");
	private By  gridRows = By.xpath("//div[@id='grid']/div[3]//tr");
	
	private By column = By.xpath("//div[@id='grid']/div[3]//tr[1]/td");
	
	
	
	
	
	
	
	
	
	
	
	
	public void writeGridText()
	{
		int rows = Utility.getElements(gridRows).size();
		int col = Utility.getElements(column).size();
		String value ="";
		ExcelManager excel = new ExcelManager("GridTest");
		int initialRow = excel.getRowCount();
		if(initialRow>0)
			initialRow+=3;
		for(int i=0;i<=rows;i++)
		{
			for(int j=1;j<=col;j++)
			{
				if(i==0) 
				{
					value = Utility.getElement(By.xpath("//table[@role='grid']//thead/tr/th["+j+"]")).getText();
					excel.writeInExcel(initialRow,j, value);
				}
				else {
				 if(j==1)
					value = Utility.getElement(By.xpath("//div[@id='grid']/div[3]//tr["+i+"]/td/div[2]")).getText();
				else
					value = Utility.getElement(By.xpath("//div[@id='grid']/div[3]//tr["+i+"]/td["+j+"]")).getText();
				excel.writeInExcel(i+initialRow,j, value);
				}
			}
			
////div[@id='grid']/div[3]//tr[1]/td[2]
			
		}
		
		excel.closeAfterWrite();
	}
	
	public static GridHomePage gotogridPage()
	{
		DriverManager.navigateTo(PropertiesFileManager.getConfigProperty("gridUrl"));
		return new GridHomePage();
	}
	
	
	@Override
	public ExpectedCondition<WebElement> pageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.presenceOfElementLocated(about);
	}
	
	
	
	
	
	

}
