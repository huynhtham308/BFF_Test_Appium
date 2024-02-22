package helper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
public class ExcelHelper {
    public static Object[][] readJsonFromExcel(String filePath) {
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
            Sheet sheet = workbook.getSheetAt(0);

            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[numRows - 1][numCols]; // Exclude the header row

            for (int i = 1; i < numRows; i++) { // Start from row 1 to skip the header
                Row row = sheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    data[i - 1][j] = row.getCell(j).getStringCellValue();
                }
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
