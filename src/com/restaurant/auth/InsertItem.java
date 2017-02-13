package com.restaurant.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/insert")
public class InsertItem extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String itemName=req.getParameter("item");
		String itemValue=req.getParameter("price");
		System.out.println(itemName+" "+itemValue);
		
		PrintWriter pw=res.getWriter();
		
		String qry="Insert into restaurant.items values(?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Done");
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setString(1, itemName);
			ps.setString(2, itemValue);
			ps.executeUpdate();
			System.out.println("Item Entry Made");
			pw.println("<html><body><h2>"+itemName+" Entry Successful </h2> <br> <br> <a href='/RestaurantBilling/insertitem.html'>Click here to add another item</a> <br> <a href='/RestaurantBilling/login.html'>Click here to go back to the login page");
			
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
