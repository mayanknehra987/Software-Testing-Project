package Eretail.FrameworkEretail.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static FileInputStream fis = null;
	static XSSFWorkbook wb = null;
	static Sheet sheet = null;

	public static Object[][] readExcelData(String filepath, String sheetname) {
		try {
			fis = new FileInputStream(filepath);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetname);
			if (sheet == null) {
	            throw new RuntimeException("Sheet '" + sheetname + "' not found in Excel file.");
	        }
			int rowCount = sheet.getLastRowNum();// number of data rows(excluding header)
			int colCount = sheet.getRow(0).getLastCellNum();// number of columns

			Object[][] data = new Object[rowCount][colCount];

			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i + 1); // data starts from second row(index 1)
				for (int j = 0; j < colCount; j++) {
					//Cell cell = row.getCell(j);
					data[i][j] = row.getCell(j).toString();
				}
			}
			return data;

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (wb != null)
					wb.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
