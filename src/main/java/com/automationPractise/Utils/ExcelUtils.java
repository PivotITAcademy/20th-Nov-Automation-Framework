package com.automationPractise.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automationPractise.BasePackage.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell wc;

	public static int getRowCount(String filePath, String sheetName) throws IOException {
		int rowCount = 0;
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		logger.info("The Row count is " + rowCount);

		return rowCount;
	}
	
	public static int getCellCount(String xFile, String xSheet, int rowno) throws IOException {

		int colCount;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		wr = ws.getRow(rowno);

		colCount = wr.getLastCellNum();

		wb.close();

		fi.close();
		
		System.out.println("Column count is  : " + colCount);

		return colCount;

	}

	@SuppressWarnings("deprecation")
	public static String getCellData(String xFile, String xSheet, int rowno, int colno) throws IOException {

		String data;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		wr = ws.getRow(rowno);
		
		
		wc = wr.getCell(colno);

		wc.setCellType(wc.CELL_TYPE_STRING);

		data = wc.getStringCellValue();

		return data;

	}

}
