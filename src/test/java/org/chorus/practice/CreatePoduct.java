package org.chorus.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.Chor.objectRepository.CommonPage;
import org.Chor.objectRepository.CreateNewProductPage;
import org.Chor.objectRepository.LoginPage;
import org.Chor.objectRepository.ProductInformationPage;
import org.Chor.objectRepository.ProductsPage;
import org.Chorus.genericUtility.BaseClass;
import org.Chorus.genericUtility.DataType;
import org.Chorus.genericUtility.ExcelUtility;
import org.Chorus.genericUtility.FileUtility;
import org.Chorus.genericUtility.IConstantPath;
import org.Chorus.genericUtility.JavaUtility;
import org.Chorus.genericUtility.WebDriverUtility;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePoduct {
	@Test
	public static void main(String[]args ) throws EncryptedDocumentException, IOException {
		//fetch data from excel
	//String expectedProductName = excelUtility.getDataFromExcel("Products",3 ,0);
	//System.out.println(expectedProductName);
		ExcelUtility excelUtility = new ExcelUtility();
		FileUtility fileUtility = new FileUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility driverUtility = new WebDriverUtility();

		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		// fetch data from propertyfile
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String username = fileUtility.getDataFromPropertyFile("username");

		String password = fileUtility.getDataFromPropertyFile("password");
		String url = fileUtility.getDataFromPropertyFile("url");
		String timeout = fileUtility.getDataFromPropertyFile("timeout");
//fetch data from excel
		String productName = excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, 3, 0)
				+ javaUtility.getRandomNumber(1000);
		System.out.println(productName);
		// convert string to long

		long longtimeout = (long) javaUtility.convertStringintoAnyDataType(timeout, DataType.LONG);
		WebDriver driver = driverUtility.openBrowserWithApplication("chrome", longtimeout,
				"http://rmgtestingserver:8888/");

		LoginPage loginpage = new LoginPage(driver);
		CommonPage commonpage = new CommonPage(driver);
		ProductsPage productspage = new ProductsPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		loginpage.loginAction(username, password);
		commonpage.clickProductsTab();
		productspage.clickAction();
		createNewProductPage.CreateNewProductPage(productName);
		
		createNewProductPage.saveAction();
		commonpage.clickProductsTab();
		String actualProduct = productInformationPage.getproductNameText();

		List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']"));
		for (WebElement product : productList) {
			
			if (product.getText().contains(productName)) {
				
				System.out.println("pass");
				break;
			}
		}

		
//commonpage.signOutAction(driverUtility, driver);
//excelUtility.closeExcelWorkBook();
//WebDriverUtility webDriverUtility = new WebDriverUtility();
//webDriverUtility.closeBrowser(driver);
	}

}
