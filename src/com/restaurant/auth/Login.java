package com.restaurant.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		System.out.println(username + " " + password);
		
		
		
		PrintWriter pw=res.getWriter();
		//validate
		 String qry="Select username from restaurant.users where username=? and password=?";
		 
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Class Loaded");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			 System.out.println("Connection done");
			 PreparedStatement ps=con.prepareStatement(qry);
			 ps.setString(1, username);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 System.out.println("Executed");
			 if(rs.next())
			 {
				 HttpSession session=req.getSession();
				 session.setAttribute("userName", username);
				 System.out.println("session started");
					
				 System.out.println("This is a test for checking git");
					
				 String user=rs.getString("username");
				 System.out.println("Welcome " + user);
				 pw.println("<html><body><h1>Welcome "+ username +"</h1><h3>Select a task to be performed: <br> <a href='/RestaurantBilling/insertitem.html'>Insert Item</a><br><a href='/RestaurantBilling/generatebilll.html'>Generate Bill</a></h3></body></html>");
				 
				 
			 }
			 else
			 {
				 System.out.println("Invalid User");
				 pw.println("<html><body><h1>Invalid User</h1><br> <h3><a href='/RestaurantBilling/login.html'> Click here to try again</a></h3></body></html>");
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
	
	
	}
}