package org.chorus.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPop2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String requriredDate = "20";
		String requiredMonth = "February";
		String requiredYear = "2021";
		int requiredMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		
	}
}