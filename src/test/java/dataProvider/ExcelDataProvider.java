package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		File src = new File("./Application Test Data/ApplicationTestData.xlsx");
		
		try
		{
			
		FileInputStream fis = new FileInputStream(src);
		
		
		wb = new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception is occured");
		}
		
	}
	
	public String getData(int sheetIndex,int row,int column)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).toString();
		return data;
	}
	
	public String getData(String sheetIndex,int row,int column)
	{
		String data = wb.getSheet(sheetIndex).getRow(row).getCell(column).toString();
		return data;
	}

}
