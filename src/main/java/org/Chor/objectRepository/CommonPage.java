package org.Chor.objectRepository;

import org.Chorus.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
//declaration
	@FindBy(linkText = "Products") private WebElement productsTab;
	@FindBy(xpath = "//img[@src='thems/softed/images/user.PNG']") private WebElement administrator;
	@FindBy(xpath = "//a[.='Sign Out']") private WebElement signOutLink;
	@FindBy(xpath = "//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']") private WebElement productNameList;
	//initialization
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//	buisness library
	public void clickProductsTab() {
		productsTab.click();
	}
	public void signOutAction(WebDriverUtility driver) {
		signOutLink.click();
	}

	}
 
