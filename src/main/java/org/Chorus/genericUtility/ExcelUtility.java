package org.Chorus.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is consists all common action on excel
 * @author srinivas nagaraju
 *
 */


/**  
 * This method is used to fetch the data from the excel
 * @param excelPath
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @author srinivas nagaraju
 *
 */
public class ExcelUtility {
	 Workbook workbook=null;
	 public void openExcel(String excelPath) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(excelPath);
	workbook=WorkbookFactory.create(fis);
	 }
  public String getDataFromExcel(String excelPath, int rowNumber, int cellNumber) {
	//  Workbook workbook=null;
	  FileInputStream fis=null;
	try {
	 fis=new FileInputStream("src/test/resources/TestData.xlsx");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	//  Workbook workbook=null;
	try {
		 workbook = WorkbookFactory.create(fis);
	} catch (IOException e) {
			e.printStackTrace();
	}
	Sheet sheet = workbook.getSheet("Product");
	String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	
	try {
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
 

  }
  public void closeExcel() throws IOException {
	//	FileInputStream workbook = null;
		workbook.close();
	}

	public void setDataInExcel(String sheetName, int row, int cell, String text) {
//	Workbook workbook = null;
	Sheet sheet = workbook.getSheet(sheetName);
	sheet.getRow(row).createCell(cell).setCellValue(text);
	}

	public void saveDataInToExcel(String outputPath) throws FileNotFoundException, IOException {
	//	Workbook wb = null;
		workbook.write(new FileOutputStream(outputPath));

}
	
		
	
		
	}
