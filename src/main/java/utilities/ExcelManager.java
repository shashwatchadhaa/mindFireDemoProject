package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


public class ExcelManager {

	private File file;
	private FileInputStream fis;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private Row row;
	private Cell cell;
	private String sheetName;
	private static String excelPath;
	

	public ExcelManager(String sheetName) {
		file = new File(excelPath);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workbook = new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
this.sheetName=sheetName;
	}
	
	
	





	public static void setExcelPath(String path) {
		excelPath = path;
	}




	public int getRowCount() {

		sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum()+1;

	}

	
	
	
	public int getColumnCount()
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	
	
	
	
	
	
	
	
	public String readExcel( int rowNumber, int columnNumber) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);
		if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		return cell.getStringCellValue();

	}

}
