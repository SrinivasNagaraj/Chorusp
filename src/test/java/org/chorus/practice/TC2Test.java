package org.chorus.practice;

import org.Chor.objectRepository.CommonPage;
import org.Chor.objectRepository.CreateNewProductPage;
import org.Chor.objectRepository.ProductInformationPage;
import org.Chor.objectRepository.ProductsPage;
import org.Chorus.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class TC2Test extends BaseClass {
@Test
public void createProductPart(){
	String product = excelUtility.getDataFromExcel("Product",3,0)+randomNumber;
	String partNumber = excelUtility.getDataFromExcel("product",3,1)+randomNumber;
	System.out.println(product);
	CommonPage commonPage=new CommonPage(driver);
	ProductsPage productsPage=new ProductsPage(driver);
	ProductInformationPage productInformationPage=new ProductInformationPage(driver);
	CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
	commonPage.clickProductsTab();
	productsPage.clickAction();
	createNewProductPage.CreateNewProductPage(product);
	createNewProductPage.PartNum(product);
	createNewProductPage.saveAction();
	commonPage.clickProductsTab();
	String actualProductName = productInformationPage.getproductNameText();
	if(actualProductName.equals(product)) {
		System.out.println("product created");
	}
	else {
		System.out.println("not created");
	}
}
}
