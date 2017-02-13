package com.rest.ser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

public class RegisterService
{
	public static void registerService(String username,String password,HttpServletRequest req, HttpServletResponse res)
	{

		Connection con=null;
		PreparedStatement ps=null;
		String qry="insert into restaurant.Users values(?,?)";
		
		try
		{
			con=Connect.getConnect();
			ps=con.prepareStatement(qry);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("User Registered");
			res.sendRedirect("login.html");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
