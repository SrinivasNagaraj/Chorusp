package org.chorus.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.Chorus.genericUtility.DataType;
import org.Chorus.genericUtility.ExcelUtility;
import org.Chorus.genericUtility.FileUtility;
import org.Chorus.genericUtility.IConstantPath;
import org.Chorus.genericUtility.JavaUtility;
import org.Chorus.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateProductDelete {
	public static void main(String[] args) throws InterruptedException, IOException {


		//create object for properties class
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		//fetch data
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String url = fileUtility.getDataFromPropertyFile("url");
		String timeout = fileUtility.getDataFromPropertyFile("timeout");
		long time = 0;
		try {
			time = (long)JavaUtility.convertStringintoAnyDataType(timeout,DataType.LONG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver = webDriverUtility.openBrowserWithApplication("chrome", time,"http://rmgtestingserver:8888/" );
		String partNum = excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, 2 ,1);

		//WebDriverManager.chromedriver().setup();
		//	WebDriver driver = new ChromeDriver();
		//	driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/images/findduplicates.gif']")).click();
		driver.findElement(By.xpath("//option[text()='Part Number' and @value='176']")).click();
		driver.findElement(By.name("Button")).click();

		driver.findElement(By.xpath("//input[@value='Find Duplicates']")).click();
		driver.findElement(By.xpath("//input[@value='129' and @ name='del']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/following::a[text()='Part Number']"));
		for(             WebElement product : productList) {
			String	list=product.getText();
			//	System.out.println(list);
			Object expList = "129";
			if(list.equals(expList)) {
				System.out.println("fail");
			}
			else {
				System.out.println("pass");

			}

		}


	}
}
