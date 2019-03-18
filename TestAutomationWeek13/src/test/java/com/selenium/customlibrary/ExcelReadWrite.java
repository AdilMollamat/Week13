package com.selenium.customlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReadWrite {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow	Row;
	private static String excelFile;
	
	
	public ExcelReadWrite(String excelFilePath)
	{
		excelFile = excelFilePath;
	}
	
	public String[][] getExcelData(String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(excelFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);
			//DataFormatter formatter = new DataFormatter(Locale.US);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	
	public static void setExcelFile(String sheetName) 
	{
		try{
		FileInputStream file = new FileInputStream(excelFile);
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getCellData(int RowNum, int ColNum)
	{		
		String cellData = null;
		try{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		cellData = Cell.getStringCellValue();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cellData;	
	}
	
	public static void setCellData(String data, int RowNum, int ColNum)
	{
		try{
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if(Cell == null)
			{
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(data);
				
				FileOutputStream fileOut = new FileOutputStream(excelFile);
				ExcelWBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
