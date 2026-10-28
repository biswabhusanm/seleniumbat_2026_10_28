package testngdem;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {
    public static Object[][] getTestData(String filePath, String sheetName) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getLastRowNum(); // Total rows minus header
            int totalCols = sheet.getRow(0).getLastCellNum(); // Columns in header row

            data = new Object[totalRows][totalCols];//Object data[]=new Object[5][5];
            DataFormatter formatter = new DataFormatter(); // Normalizes numbers/dates to Strings

            // Outer loop starts at 1 to skip the header row
            for (int i = 1; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalCols; j++) {
                    Cell cell = row.getCell(j);
                    // Map data to the 0-indexed Object array
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
        return data;
    }



}
