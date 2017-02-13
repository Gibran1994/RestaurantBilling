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

@WebServlet("/finalize")
public class Finalize extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String custName=req.getParameter("custName");
		
		String queryGetAll="Select Rate from restaurant.items where Item=?";
		
		String insertCustomer="Insert into restaurant.bill values(?,?)";
		
		String cal="Select * from restaurant.calc";
		
		String clearTable="Delete from restaurant.calc";
		
		double total=0;
		
		
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Class Loaded");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			 System.out.println("Connection done");
			 PreparedStatement ps=con.prepareStatement(cal);
			 ResultSet rs=ps.executeQuery();
			 System.out.println("Executed1");
			 ResultSet rs1;
			 while(rs.next())
			 {
				 int price=0;
				 String name=rs.getString("Item Name");
				 int qty=rs.getInt("Quantity");
				 
				 ps=con.prepareStatement(queryGetAll);
				 ps.setString(1, name);
				 rs1=ps.executeQuery();
				 System.out.println("Executed2");
				 
				 if(rs1.next())
				 {
					 price=rs1.getInt("Rate");
				 }
				 total=total+(qty*price);
			 }
			 ps=con.prepareStatement(insertCustomer);
			 ps.setString(1, custName);
			 ps.setDouble(2, total);
			 ps.executeUpdate();
			 System.out.println("Executed3");
			 
			 
			 ps=con.prepareStatement(clearTable);
			 ps.executeUpdate();
			 System.out.println("Executed4");
			 
			 PrintWriter pw=resp.getWriter();
			 
			 pw.println("<html><body><h1> Customer Name:" + custName +"<br>Total Bill Generated:"+total+"</h1><br><a href='/RestaurantBilling/login.html'> Click here to go to login page </a></body></html>");
			 
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