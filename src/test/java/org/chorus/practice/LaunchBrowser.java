package org.chorus.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType;

public class LaunchBrowser {
public static void main(String[] args) {
	String browser="firefox";
	WebDriver driver=null;
	if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else {
		System.out.println("pls enter valid key");
	}
}
  

}
