package org.chorus.practice;

import org.Chor.objectRepository.CommonPage;
import org.Chor.objectRepository.CreateNewProductPage;
import org.Chor.objectRepository.ProductInformationPage;
import org.Chor.objectRepository.ProductsPage;
import org.Chorus.genericUtility.BaseClass;
import org.Chorus.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class TC3Test extends BaseClass {
@Test
public void deleteproductTest() {
	String productName = excelUtility.getDataFromExcel("Product",7, 0 )+randomNumber;
	System.out.println(productName);
	
	CommonPage commonPage=new CommonPage(driver);
	ProductsPage productsPage=new ProductsPage(driver);
ProductInformationPage productInformationPage=new ProductInformationPage(driver);
//	CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
	commonPage.clickProductsTab();
	productsPage.clickOneProduct();
productInformationPage.deleteAction();
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	webDriverUtility.alertPopUp(driver);
	webDriverUtility.waitTillPageLoad(driver,randomNumber);
	//commonPage.clickProductsTab();

}
}
