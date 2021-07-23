package com.excel.operations;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BasicExcelOperations {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("G:\\DanishTesting\\SeleniumRepo\\SeleniumPractice\\ExcelFiles\\ExcelOperations.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet module1 = wb.getSheet("module1");
			Row record = module1.getRow(1);
			Cell userName = record.getCell(0);
			
			System.out.println("Get number of sheet = "+wb.getNumberOfSheets());
			System.out.println("cell value (1,0) = "+userName.getStringCellValue()+"\n");
			
			System.out.println("last index of row getLastRowNum = "+module1.getLastRowNum());
			System.out.println("total number of rows getPhysicalNumberOfRows = "+module1.getPhysicalNumberOfRows()+"\n");
			
			System.out.println("last index of cell(0) getLastRowNum = "+module1.getRow(0).getLastCellNum());
			System.out.println("total number of cell(1) getLastRowNum = "+module1.getRow(1).getPhysicalNumberOfCells()+"\n");

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
