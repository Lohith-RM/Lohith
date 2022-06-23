package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Admin
 *
 */
/**
 * its used to read the data from Excel-Workbook based on below 
 * @author Admin
 *
 */
public class ExcelUtility {
	
	public String readDataFromExcel(String sheetname, int rowNum,int cellnum ) throws Throwable
	
	{
		FileInputStream fileinputstream = new FileInputStream(".\\src/test/resources/assignment attachments/weekend1assignment/ass1.xlsx");
		Workbook book=WorkbookFactory.create(fileinputstream);
		Sheet s = book.getSheet(sheetname);
		Row r = s.getRow(rowNum);
		Cell cell = r.getCell(cellnum);
		
		DataFormatter data = new DataFormatter();
	    String cellvalue = data.formatCellValue(cell);
	    return cellvalue;
	    
	}
	
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */		
		
	public void writeDataIntoExcel(String sheetName,int rowNum, int cellNum,String data ) throws Throwable
	
	{
		
        FileInputStream fileinputstream = new FileInputStream(".\\src\\test\\resources\\assignment attachments\\weekend1assignment\\ass1.xlsx");
		Workbook book = WorkbookFactory.create(fileinputstream);
		Sheet s = book.getSheet(sheetName);
		Row r = s.getRow(rowNum);
		Cell cell = r.createCell(cellNum);
		cell.setCellValue(data);	
		
		FileOutputStream fileoutputStream = new FileOutputStream(".\\src\\test\\resources\\assignment attachments\\weekend1assignment\\ass1.xlsx");
		book.write(fileoutputStream);
		
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\assignment attachments\\weekend1assignment\\ass1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();

}
}
