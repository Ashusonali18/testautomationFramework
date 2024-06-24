package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Readexceldata {

    @DataProvider(name = "logindata")
    public String[][] getData() {
        String[][] data = null;
        XSSFWorkbook workbook = null;
        FileInputStream fis = null;
        try {
            File excelFile = new File("C:\\Users\\Shree\\eclipse-workspace\\Project\\testautomationFramework\\src\\test\\resources\\testData\\testdata.xlsx");
            fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("login");
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfColumns = sheet.getRow(0).getLastCellNum();

            data = new String[noOfRows - 1][noOfColumns];
            DataFormatter df = new DataFormatter();

            for (int i = 0; i < noOfRows - 1; i++) {
                for (int j = 0; j < noOfColumns; j++) {
                    data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the Excel file: " + e.getMessage());
            }
        }

        if (data != null) {
            for (String[] dataArr : data) {
                System.out.println(Arrays.toString(dataArr));
            }
        }
        return data;
    }
}
