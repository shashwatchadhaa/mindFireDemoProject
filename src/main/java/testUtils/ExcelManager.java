package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
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
	private static HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private Row row;
	private Cell cell;
	private String sheetName;
	private static String excelPath;
	private FileOutputStream fos;

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
		this.sheetName = sheetName;
	}

	public static void setExcelPath(String path) {
		excelPath = path;
	}

	public int getRowCount() {

		sheet = workbook.getSheet(sheetName);
		if(sheet==null)
		sheet=workbook.createSheet(sheetName);
		return sheet.getLastRowNum() + 1;

	}

	public int getColumnCount() {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}

	public void writeInExcel(int rowNumber, int colNumber, String value) {
		
		
		if(sheet==null)
		sheet=workbook.getSheet(sheetName);
		
		
		if(sheet==null)
		sheet=workbook.createSheet(sheetName);
		row=sheet.getRow(rowNumber);
		if(row==null)
		row = sheet.createRow(rowNumber);
		cell = row.createCell(colNumber);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		
		
		System.out.println("done");
	}

	
	public void closeAfterWrite()
	{
		try {
			fos	= new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("done");
	}
	public String readExcel(int rowNumber, int columnNumber) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);
		if (cell.getCellTypeEnum() == CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		return cell.getStringCellValue();

	}

}
