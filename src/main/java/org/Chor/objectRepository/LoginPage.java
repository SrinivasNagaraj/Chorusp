package org.Chor.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//declaration
	@FindBy(name = "user_name") private WebElement userNameTextfield;
	@FindBy(name = "user_password") private WebElement passWordTextfield;
	@FindBy(id = "submitButton") private WebElement loginButton;
	//initialization 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//buisness library
	public void loginAction(String username,String password) {
		userNameTextfield.sendKeys(username);
		passWordTextfield.sendKeys(password);
		loginButton.click();
	}
}
