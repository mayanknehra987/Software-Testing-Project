package Assured.restAssuredFramework.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class UtilsExcel {
	
	// It will be used by dataprovider testng
	// read from the xlsx file and give data in 2D matrix
	 static Workbook wb;
	 static Sheet sheet;
	public static Object[][] getTestData(String sheetname){
		
		FileInputStream file= null;
		
		try{
			file= new FileInputStream("src/test/java/resources/TD.xlsx");
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
		wb= WorkbookFactory.create(file);
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		sheet= wb.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = data[i+1];
			}
		}
		return data;
	}
	@DataProvider
	public static Object[][] getData(){
		return getTestData("sheet1");
	}

}
