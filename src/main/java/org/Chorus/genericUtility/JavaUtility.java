package org.Chorus.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists all java reusable actions
 * 
 * @author srinivas nagaraju
 *
 */
public class JavaUtility {
public int getRandomNumber(int limit) {
	return new Random().nextInt(limit); 
}

public static Object convertStringintoAnyDataType(String data, DataType strategy) {
	Object obj=null;
	if(strategy.toString().equalsIgnoreCase("long")) {
		obj=Long.parseLong(data);
	}
	else if(strategy.toString().equalsIgnoreCase("Int")) {
		obj=Integer.parseInt(data);
		
	}
	return obj;
	}
/**
 * this method is used to convert the current date and time into "dd_MM_yyyy_hh_mm_sss" format 
 * @return
 */


public String currentTime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
	String actualDate = sdf.format(date);
	return actualDate;
}

}

	


