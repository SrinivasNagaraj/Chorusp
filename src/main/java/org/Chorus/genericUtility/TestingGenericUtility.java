package org.Chorus.genericUtility;

public class TestingGenericUtility {
public static void main(String[]args) {
	int randomNumber=new JavaUtility().getRandomNumber(100);
     String data = new ExcelUtility().getDataFromExcel(IConstantPath.EXCEL_PATH, 2,1)+randomNumber;
	System.out.println(data);
	System.out.println(data);
String browser = new FileUtility().getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
System.out.println(browser);
}
}