package org.Chor.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createProductIcon;
	@FindBy(xpath = "//a[text()='airtel764']") private WebElement clickProduct;
	//@FindBy(xpath = "")
	//@FindBy(id ="311") private WebElement clickCheckBox;
	@FindBy(xpath = "//input[@class='crmbutton small delete']") private WebElement deleteButton;
	@FindBy(xpath = "//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']") private WebElement productList;
	//intialize
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	//buisness lib
	public void clickAction() {
		createProductIcon.click();
	}
	//public void clickCheckBox() {
	//	clickCheckBox.click();
	//}
	public void clickDelete() {
		deleteButton.click();
	}
	public void productNameList() {
		productList.click();
	}
	public void clickOneProduct() {
		clickProduct.click();
	}
}
