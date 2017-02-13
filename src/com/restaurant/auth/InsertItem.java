package com.restaurant.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

@WebServlet("/insert")
public class InsertItem extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String itemName=req.getParameter("item");
		String itemValue=req.getParameter("price");
		System.out.println(itemName+" "+itemValue);
		

		
		String qry="Insert into restaurant.items values(?,?)";
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Connect.getConnect();
			ps=con.prepareStatement(qry);
			ps.setString(1, itemName);
			ps.setString(2, itemValue);
			ps.executeUpdate();
			System.out.println("Item Entry Made");
			res.sendRedirect("InsertAnother.html");
			
			
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
