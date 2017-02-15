package com.rest.ser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

public class Loginservice
{
	public static Boolean loginService(String username,String password)
	{
		//validate
		 
		Connection con=null;
		PreparedStatement ps=null;
		String qry="Select username from restaurant.users where username=? and password=?";
		Boolean result=false;
		 try
		 {
			con=Connect.getConnect();
			 ps=con.prepareStatement(qry);
			 ps.setString(1, username);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 System.out.println("Executed");
			 System.out.println(con);
			 if(rs.next())
			 {
			
					
				 System.out.println("This is a test for checking git");
					
				 String user=rs.getString("username");
				 System.out.println("Welcome " + user);
				// res.sendRedirect("WelcomeUser.html");
				 result=true;
				 
				 
			 }
			 else
			 {
				 System.out.println("Invalid User");
				// res.sendRedirect("InvalidUser.html");
				 result=false;
			 }
			 return result;
			 
		 }
		 catch(ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
			 
			 try {
				CloseCon.close(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		return result;
	
		
	}
}
