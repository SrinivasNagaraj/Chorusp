package org.chorus.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
  
public class SetDtaToExel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Product");
	Row row = sheet.getRow(2);
	Cell cell = row.createCell(2);
	cell.setCellValue("pass");
	 FileOutputStream fos = new FileOutputStream("src/test/resources/TestData.xlsx");
	 wb.write(fos);
	 System.out.println("data updated");
	
}
}
