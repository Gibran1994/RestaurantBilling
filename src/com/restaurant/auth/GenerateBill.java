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

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

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
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Connect.getConnect();
			ps=con.prepareStatement(qry);
			ps.setString(1, itemName);
			ps.setString(2, quantity);
			ps.executeUpdate();
			System.out.println("Item Entry Made");
			res.sendRedirect("EntrySuccess.html");

			
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