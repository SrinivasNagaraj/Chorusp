package org.chorus.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioPrct {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	 ChromeOptions options=new ChromeOptions();
	 options.addArguments("--disable-notifications");
	 WebDriver driver=new ChromeDriver(options);
	 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.ajio.com/");
		 driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		 driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		 driver.findElement(By.xpath("//div[text()='Puma']/parent::div[@class='contentHolder']//span[text()='₹368']")).click();
		 
		 
	 
}
}
