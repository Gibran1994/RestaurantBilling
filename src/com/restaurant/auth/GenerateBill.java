package com.restaurant.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill")
public class GenerateBill extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String itemName=req.getParameter("itemName");
		String quantity=req.getParameter("quantity");
		
		System.out.println(itemName+" "+quantity);
		
		PrintWriter pw=res.getWriter();
		
		String qry="Insert into restaurant.calc values(?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Done");
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setString(1, itemName);
			ps.setString(2, quantity);
			ps.executeUpdate();
			System.out.println("Item Entry Made");
			pw.println("<html><body><h2>"+itemName+" Entry Successful </h2> <br> <br> <a href='/RestaurantBilling/generatebilll.html'>Click here to add another item</a> <br> <a href='/RestaurantBilling/Finalize.html'>Click here to Finalize");
			
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