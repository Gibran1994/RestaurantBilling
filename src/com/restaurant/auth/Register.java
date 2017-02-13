package com.restaurant.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class Register extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		System.out.println(username + " " + password);
		
		Connection con=null;
		
		String qry="insert into restaurant.Users values(?,?)";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Done");
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("User Registered");
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