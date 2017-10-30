package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
 public static Connection getConnection() throws ClassNotFoundException, SQLException
 {
	 Connection cnn = null;
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 System.out.println("Driver connected");
	 String url = "jdbc:oracle:thin:@Aniket:1521:XE";

	 cnn = DriverManager.getConnection(url, "system", "system");
	 System.out.println("connection established");
	 return cnn;
 }

}
