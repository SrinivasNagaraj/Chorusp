package org.Chorus.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * This class consists reusable method to handle property file
 * @author srinivas nagaraju
 *
 */
public class FileUtility {
	Properties properties;
	

public String getDataFromPropertyFile( String key) {
return properties.getProperty(key).trim();
}
//changes done by eng-1
public void initializePropertyFile(String PropertyfilePath) throws IOException {
	FileInputStream fis=new FileInputStream(PropertyfilePath);
	properties=new Properties();
	properties.load(fis);
}
	


}
