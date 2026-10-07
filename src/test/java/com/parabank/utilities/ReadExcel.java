package com.parabank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

		XSSFWorkbook workbook;
		XSSFSheet sheet; 
		XSSFRow row; 
		XSSFCell cell;
		
		FileInputStream input;
		
		public ReadExcel() {
			try {
				input=new FileInputStream("src/test/resources/Source.csv");
				workbook=new XSSFWorkbook(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sheet=workbook.getSheetAt(0);
		}
		
		public int getLastRowNum() {
			return sheet.getLastRowNum();
		}
		
		public int getLastCellNum() {
			return sheet.getRow(0).getLastCellNum();
		}
		
		
		
		public String getCellData(int rowNum,int cellNum) {
			
			row=sheet.getRow(rowNum);
			cell=row.getCell(cellNum);
		
			String data;
			
			try {
				DataFormatter formatter=new DataFormatter();
				String cellData=formatter.formatCellValue(cell);
				return cellData;
			}catch(Exception e) {
				return data=" ";
			}
			
		}
}
