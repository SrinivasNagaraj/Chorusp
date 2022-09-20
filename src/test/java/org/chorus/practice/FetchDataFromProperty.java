package org.chorus.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperty {
public static void main(String[] args) throws IOException {
	//step---1>convert the physical file into java readble object
	  FileInputStream fis = new FileInputStream("src/test/resources/CommonData.properties");
	  //step 2--->create the object for properties
	Properties property = new Properties();
	//step 3--->load all the keys
	property.load(fis);
	//step 4---->fetch the data
	String url = property.getProperty("url").trim();
	String username = property.getProperty("username").trim();
	
	System.out.println(url);   
	System.out.println(username);
}
}
