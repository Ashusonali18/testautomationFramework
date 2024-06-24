package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Readexceldata {
	@DataProvider(name="logindata")
	public String[][] getData()  {
		String[][] data =null;
		try 
		{
		File excelFile = new File("C:\\Users\\Shree\\eclipse-workspace\\Project\\testautomationFramework\\src\\test\\resources\\testData\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		 data = new String[noOfRows-1][noOfColumns];
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		
 		for (String[] dataArr : data) {
 			System.out.println(Arrays.toString(dataArr));
 		}
		}
		catch(Exception ex)
		{
			
		}
		return data;
	}
}
