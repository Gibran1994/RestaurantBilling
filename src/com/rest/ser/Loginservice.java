package com.rest.ser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

public class Loginservice
{
	public static void loginService(String username,String password,HttpServletRequest req, HttpServletResponse res)
	{
		//validate
		 
		Connection con=null;
		PreparedStatement ps=null;
		String qry="Select username from restaurant.users where username=? and password=?";
		
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
				 HttpSession session=req.getSession();
				 session.setAttribute("userName", username);
				 System.out.println("session started");
					
				 System.out.println("This is a test for checking git");
					
				 String user=rs.getString("username");
				 System.out.println("Welcome " + user);
				 res.sendRedirect("WelcomeUser.html");
				 
				 
			 }
			 else
			 {
				 System.out.println("Invalid User");
				res.sendRedirect("InvalidUser.html");
			 }
			 
		 }
		 catch(ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 } catch (IOException e) {
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
	
		
	}
}
