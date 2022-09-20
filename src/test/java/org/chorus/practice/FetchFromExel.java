package org.chorus.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchFromExel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step 1--->convert the physical file into java readable format
	FileInputStream fis=new FileInputStream("src/test/resources/TestData.xlsx");
	//step 2--->open the exel workbook
	Workbook wb = WorkbookFactory.create(fis);
	//step 3--->get the control on sheet
	Sheet sheet = wb.getSheet("CommonData");
	//step 4--->get the control on row
	 Row row = sheet.getRow(3);
	 //step 5---->control on cell
	Cell cell = row.getCell(0);
	//step 6--->fetch the data
	String data = cell.getStringCellValue();
	 
	System.out.println(data);
	//close the workbook
	wb.close();
	
}
}
