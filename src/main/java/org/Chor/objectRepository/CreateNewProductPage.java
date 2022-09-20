package org.Chor.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
@FindBy(name ="productname") private WebElement productNameText;
@FindBy(id = "productcode") private WebElement partNumberText;
@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveButton;

public CreateNewProductPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void  CreateNewProductPage (String productName) {
	productNameText.sendKeys(productName);
	//partNumberText.sendKeys(partNumber);
}
	public void PartNum(String partNumber) {
		partNumberText.sendKeys(partNumber);
	}
	
	
	
	
	
//public String getpartNumberText() {
	//return partNumberText.getText();
//}

public void saveAction() {
saveButton.click();
}
public void createProduct(String productName) {
	// TODO Auto-generated method stub
	
}

}