package org.chorus.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expList = null;
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']"));

		for(        WebElement productName    :productList) {
			String list = productName.getText();
			

			if(list.equals(expList)) {
driver.findElement(By.xpath("//a[text()='telecom products']/parent::td/preceding-sibling::td/input")).click();
break;
		}
	}
	driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	driver.switchTo().alert().accept();
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.invisibilityOf(driver.findElement((By.xpath("//div[@id='status']/img")))));
	 List<WebElement> latestList = driver.findElements(By.xpath("//table[@class='lvt small']//a[contains(text(),'Product Name')]/ancestor::tr/following-sibling::tr//a[@title='Products']"));
	 for(WebElement  lis:latestList ) {
		 String prolist = lis.getText();
		 if(prolist.equals(expList)) {
			 System.out.println("tc fail---product not deleted");
				
				

			
			
			}
		 }
	 }
	}


