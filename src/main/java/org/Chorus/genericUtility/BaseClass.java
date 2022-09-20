package org.Chorus.genericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.Chor.objectRepository.CommonPage;
import org.Chor.objectRepository.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
//public static final WebDriver sdriver = null;
//public static final JavaUtility sjavaUtility = null;
	//	private static final DataType DataType = null;
	@SuppressWarnings("unused")
	//private static final String Long = null;
	//private static final DataType DataType = null;
	private LoginPage loginPage;
	private String username;
	private String password;
	protected CommonPage commonPage;
	protected WebDriver  driver ;
	protected WebDriverUtility webdriverUtility;
	protected ExcelUtility excelUtility;
	protected int randomNumber;
protected FileUtility fileUtility;
public static WebDriver sdriver;
public static JavaUtility sjavaUtility;
//public static WebDriver sdriver1;



	/**
	 * initialize all utility class
	 * open excel, property file
	 * read the common data
	 * create the instance of browser(launch browser)
	 * maximize , implicitwait
	 * open the application
	 * initialize jsexecutor, action, webDriverwait
	 * create yhe instance of common object repo
	 * @throws IOException
	 * 
	 */

	@BeforeClass
	public void classSetup() throws IOException {
		//create insnce of Generic Utility
		fileUtility= new FileUtility();
		excelUtility= new ExcelUtility();
		JavaUtility javaUtility= new JavaUtility();
		sjavaUtility=javaUtility;
		webdriverUtility= new WebDriverUtility();


		//initialize the property file and excel file
		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);

		//fetch data from property file
		String url= fileUtility.getDataFromPropertyFile("url");
		String browser= fileUtility.getDataFromPropertyFile("browser");
		username= fileUtility.getDataFromPropertyFile("username");
		password= fileUtility.getDataFromPropertyFile("password");
		String timeouts= fileUtility.getDataFromPropertyFile("timeout");
		long longtimeout=(long) javaUtility.convertStringintoAnyDataType(timeouts, DataType.LONG);
		randomNumber= javaUtility.getRandomNumber(1000);

		//launching the browser and doing some browser setting
		driver= webdriverUtility.openBrowserWithApplication(browser, longtimeout, url);
		sdriver=driver;
		webdriverUtility.jsIntiallization(driver);
		webdriverUtility.intiallizeAction(driver);
//webdriverUtility.verifyWebpage(driver.findElement(By.xpath("//input[@name='user_name']/preceding::div[@class='label']")),   , longTimeout, timeouts);
		//create object to common pom repo
		loginPage= new LoginPage(driver);
		commonPage= new CommonPage(driver);


	}
	//login to application
	/**
	 * whenever we create the testScript class for module and test annotation mothod for testcase
	 * create the instance for browser(openBrowser)
	 * maximize, implicit wait
	 * create the instance foe common object repo(driver)
	 * login to the app
	 * 
	 * 
	 */
	@BeforeMethod
	public void methodsetup1() {
		loginPage.loginAction(username, password);

	}
//	@AfterMethod
//	public void methodTearDown() throws FileNotFoundException, IOException {
//		//logout from application
//		commonPage.signOutAction(webdriverUtility);

	//	//save the excel data
	//	excelUtility.saveDataInToExcel(IConstantPath.EXCEL_PATH);
//	}

	//@AfterClass
	//public void classTearDown() throws IOException {
	//	webdriverUtility.closeBrowser(driver);
	//	excelUtility.closeExcel();
//	}
}
