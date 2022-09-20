package org.Chorus.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all webdriver common actions
 * @author srinivas nagaraju
 * @return 
 *
 */
public class WebDriverUtility {
	
public WebDriver launchBrowser(String browser) {
	WebDriver driver=null;
	switch(browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	case "ie":
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		default:
			System.out.println("you enterd wrong browser key in the property file");
			break;
	}
	return driver;
}
/**
 * this method is used to maximize the browser
 * 
 */
public void maximizeBrowser(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * this method is used to wait the controller implicitly till load
 * @param driver
 * @param longTimeout
 */
public void waitTillPageLoad(WebDriver driver, long longTimeout) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
}
/**
 * this method is used to open the application
 * @param driver
 * @param url
 */
public void navigateApplication(WebDriver driver, String url) {
	driver.get(url);
	}
/**
 * this method is used to launch browser,maximize,wait page implicitly and navigate
 * @param browser
 * @param timeout
 * @param url
 * @return
 */
public WebDriver openBrowserWithApplication(String browser, Long timeout, String url) {
	WebDriver driver = launchBrowser(browser);
	maximizeBrowser(driver);
	waitTillPageLoad(driver,timeout);
	navigateApplication(driver,url);
	return driver;
}
/**
 * this method is used to mouse hover action
 * @param driver
 * @param element
 
 */
public void mouseHoverAction(WebDriver driver, WebElement element) {
	new Actions(driver).moveToElement(element).perform();
}
/**
 * this method is used to double click on Webelement
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver, WebElement element) {
	new Actions(driver).doubleClick(element).perform();
}
/**
 * this method is used to close the browser instance
 * @param driver
 */
public void closeBrowser(WebDriver driver) {
	driver.quit();
}

private JavascriptExecutor jsExecutor;
public void jsIntiallization(WebDriver driver) {
	  jsExecutor = (JavascriptExecutor)driver;
}
public void openApplicationJS(String url) {
	jsExecutor.executeScript("window.location=argument{0}", url);
}
public void sendkeysUsingJS(WebElement element, String data) {
	jsExecutor.executeScript("argument[0].value=argument[1]", element, data);
	
}
public void clickUsingJS(WebElement element) {
	jsExecutor.executeScript("argument[0].value=argument[1]", element);
		
	}
public void scrollTitleElementusingJS(WebElement element) {
	jsExecutor.executeScript("argument[0].value=argument[1]", element);
}
public void intiallizeAction(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void screenShot(WebDriver driver, JavaUtility javaUtility,String className) throws IOException {
	String currentTime = javaUtility.currentTime();
TakesScreenshot ts = (TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
FileUtils.copyFile(src, dst);
}
	
public void verifyWebpage(WebElement element,WebDriver driver,long longTimeout, String expectedText) {
	for(;;) {
		try {
	
	Assert.assertEquals(element.getText(),expectedText);
	break;
		}
		catch (Exception e) {
			waitTillElementVisible(driver,longTimeout,element);
		}
	
}
}
private void waitTillElementVisible(WebDriver driver, long longTimeout, WebElement element) {
	// TODO Auto-generated method stub
	
}
public void alertPopUp(WebDriver driver) {
	driver.switchTo().alert().accept();
}
}
