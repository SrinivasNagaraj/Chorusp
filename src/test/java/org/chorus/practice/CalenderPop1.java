package org.chorus.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPop1 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String requrireddate = "20";
	String requiredmonth = "February";
	String requiredyear = "2023";
	
	
	driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
	driver.findElement(By.id("datepicker")).click();
	String actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText()	;
	 String[] str = actualmonthyear.split(" ");
	 String actualmonth = str[0];
	 String actualyear = str[1];
	 
	while(!(actualmonth.equals(requiredmonth) && actualyear.equals(requiredyear))) {
		driver.findElement(By.xpath("//span[text()='Next']")) .click();
		actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText()	;
		 str = actualmonthyear.split(" ");
		  actualmonth = str[0];
		 actualyear = str[1];
	 }
	driver.findElement(By.xpath("//a[text()='20']")).click();
	
}
}
