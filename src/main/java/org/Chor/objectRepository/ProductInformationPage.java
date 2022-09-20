package org.Chor.objectRepository;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
@FindBy(xpath = " //a[text()='Product Name']") private WebElement productNameText;
@FindBy(xpath = "//input[@name='button' and @class='crmbutton small save'][2]") private WebElement saveButton;
@FindBy(xpath = "//input[@name='productcode']") private WebElement partNumberText;
@FindBy(xpath = "//input[@title='Delete [Alt+D]']") private WebElement delete;
//@FindBy(xpath = "//a[text()='Products']") private WebElement productsLink;
//initialization
public ProductInformationPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
}
	//buisness library
	public String getproductNameText() {
		
	return productNameText.getText();
	}
public void saveAction() {
	saveButton.click();
}

public String getpartNumberText() {
	return partNumberText.getText();
}
	public void deleteAction() {
		delete.click();
	}
	
}
	

