package org.chorus.practice;

import java.io.IOException;
import java.util.List;

import org.Chor.objectRepository.CommonPage;
import org.Chor.objectRepository.CreateNewProductPage;
import org.Chor.objectRepository.LoginPage;
import org.Chor.objectRepository.ProductInformationPage;
import org.Chor.objectRepository.ProductsPage;
import org.Chorus.genericUtility.DataType;
import org.Chorus.genericUtility.ExcelUtility;
import org.Chorus.genericUtility.FileUtility;
import org.Chorus.genericUtility.IConstantPath;
import org.Chorus.genericUtility.JavaUtility;
import org.Chorus.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProductWithPartNumber {
	public static void main(String[] args) throws IOException {
		
		WebDriverUtility web=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		ExcelUtility ex=new ExcelUtility();
		JavaUtility jv=new JavaUtility();
		
		
		fu.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String browser = fu.getDataFromPropertyFile( "browser");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		String url = fu.getDataFromPropertyFile("url");
		String timeout = fu.getDataFromPropertyFile("timeout");
		String productName = ex.getDataFromExcel(IConstantPath.EXCEL_PATH,3, 0 )+jv.getRandomNumber(1000);
		String partNumber = ex.getDataFromExcel(IConstantPath.EXCEL_PATH,3, 1 )+jv.getRandomNumber(1000);
		long longtimeout=(long)jv.convertStringintoAnyDataType(timeout,DataType.LONG);
		WebDriver driver=web.openBrowserWithApplication(browser, (long) 10,url );
		
		LoginPage loginPage=new LoginPage(driver);
		CommonPage commonPage=new CommonPage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		
		loginPage.loginAction(username, password);
		commonPage.clickProductsTab();
		productsPage.clickAction();
	
		createNewProductPage.CreateNewProductPage(productName);
		createNewProductPage.PartNum(partNumber);
		createNewProductPage.saveAction();
		commonPage.clickProductsTab();
		String actualProduct = productInformationPage.getproductNameText();

		
		

		List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']"));
		for(        WebElement product    :productList) {
			  
				if (product.getText().contains(partNumber)) {
					System.out.println("pass");
					break;
				}
	}
	}
}
	



