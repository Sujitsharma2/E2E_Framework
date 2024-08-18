package com.E2E_FrameWrok.utiities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet; 
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static File file;
	
	public static String getData(String xlfile,String sheetName,int row,int col) throws IOException {
		
		 openFileAndSheet(xlfile,sheetName); 
		 String daata = sheet.getRow(row).getCell(col).getStringCellValue();
		 
		 System.out.println(daata);
		return daata;
		 
		 
	}
	
	
	/**
	 * @param xlfile
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public static int getRowCount(String xlfile,String sheetName) throws IOException {
		
		// openFileAndSheet(xlfile,sheetName);	
		try {
			file = new File(xlfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 workbook= new XSSFWorkbook(fis);
		 sheet = workbook.getSheet(sheetName);
		 
		
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	
	public static int getColCount(String xlfile,String sheetName) throws IOException {
		
		 //openFileAndSheet(xlfile,sheetName);	
		 
		try {
			file = new File(xlfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 workbook= new XSSFWorkbook(fis);
		 sheet = workbook.getSheet(sheetName);
		
		
		
		int colCount = sheet.getRow(0).getLastCellNum();
		return colCount;
	}
	

	public static void openFileAndSheet(String xlfile, String sheetName) throws IOException {
		
		 try {
			file = new File(xlfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 workbook= new XSSFWorkbook(fis);
		 sheet = workbook.getSheet(sheetName);
		 
	}
	
	
}
