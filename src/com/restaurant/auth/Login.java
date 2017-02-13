package com.restaurant.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

@WebServlet("/login")
public class Login extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		System.out.println(username + " " + password);
		
		Connection con=null;
		PreparedStatement ps=null;
		
		//validate
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