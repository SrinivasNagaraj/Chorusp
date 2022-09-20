  package org.chorus.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {
public static void main(String[]args) throws SQLException
{
	//step 1---->create object for Driver
	Driver dbdriver=new Driver();
	//step 2--->register the driver instance to the jdbc
	DriverManager.registerDriver(dbdriver);
	//step 3---->get/establish the database connection
	    Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/tyss", "root","root");
	    try {
	    	//step 4---->create the statement
	    	       Statement statement = connection.createStatement();
	    	       //step 5--->execute the query
	    	       ResultSet result  = statement.executeQuery("select emp_name from employees;");
	    	           //step 6--->fetch the data
	    	  
					while(result.next())
	    	           {
						System.out.println(result.getString("emp_name"));
	    	           }
	    }
	    	           
	    finally {
	    	//step 7---->close the connection
	    	connection.close();//mandatory
	    	System.out.println("connection closed succesfully");
	    }
	             
}
}
