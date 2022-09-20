package org.chorus.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateData {
public static void main(String[]args) throws SQLException
{
	//create object for driver
	    Driver dbdriver = new Driver();
	    //step--->2 register the driver instance to the jdbc
	    DriverManager.registerDriver(dbdriver);
	    //step 3--->establish the database connection
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root","root");
	    try {
	    	//step 4--->create the statement
	    	     Statement statement = connection.createStatement();
	    	     //step 5----> execute the query
	    	      int result = statement.executeUpdate( "insert into employees values(102,'fati',21345,'barca');");
	    	      //step 6--->fetch the data
	    	      System.out.println(result+"data updated succesfully");
	    }
	    finally {
	    	//step 7---->close the execution
	    	connection.close();//mandatory
	    	System.out.println("connection closed");
	    	       
	    }
	    
	    
}
}
