package com.sims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	public static Connection getConnect() { 
		 Connection con = null;   
	  try {  
	   // registers the specified driver class into memory  
	   Class.forName("com.mysql.jdbc.Driver");  
	  } catch (ClassNotFoundException e) {System.out.println("Driver loaded..:: \n");  
	   e.printStackTrace();  
	  }  
	  
	  try {  
	   // returns a connection object by selecting an appropriate driver  
	   // for specified connection URL  
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sims14082015", "root", "root");  
	  } catch (SQLException e) {System.out.println(" Connection Established..:: \n");  
	   e.printStackTrace();  
	  }  
	  return con;  
	 }


}
