package com.restaurant.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
	public static Connection getConnect() throws SQLException, ClassNotFoundException
	{
		Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Class Loaded");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			 System.out.println(con);
			 System.out.println("Connection done");
	
		return con;
		
	}
}
