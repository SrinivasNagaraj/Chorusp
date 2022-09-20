package org.chorus.practice;

import org.Chorus.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class MavenPract {
@Test
public void mavenPract() {
	String browser=System.getProperty("b");
	String url=System.getProperty("u");
	
	System.out.println("browser name is------>>>"+browser);
	System.out.println("url name is------>>>"+url);
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	webDriverUtility.openBrowserWithApplication(browser,10l,url);
}
}
