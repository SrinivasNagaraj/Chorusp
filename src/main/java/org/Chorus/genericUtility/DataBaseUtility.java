package org.Chorus.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author srinivas nagaraju
 *
 */
public class DataBaseUtility {
	
	Connection connection;
	public List<String> getDataFromdatabase(String query, String columnname) throws SQLException {
		
		Statement statement= connection.createStatement();
		ResultSet result= statement.executeQuery(query);
		List<String> list= new ArrayList<>();
		while(result.next()) {
			 list.add(result.getString(columnname));
			 
		}
		return list;
		
	}
	public void openDBConnection(String dburl,String dbUserName,String dbPassword) throws SQLException {
		Driver dbdriver= new Driver();
		DriverManager.registerDriver(dbdriver);
		connection=DriverManager.getConnection(dburl, dbUserName, dbPassword);
		
		
		
	}
	public void closeDB() throws SQLException {
		connection.close();
	}
	public void modifyDataIntoDB(String query) throws SQLException {
		Statement statement= connection.createStatement();
		statement.executeUpdate(query);
		System.out.println("Data updated");
		
	}

	
}	
	
	
