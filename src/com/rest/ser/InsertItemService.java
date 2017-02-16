package com.rest.ser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.restaurant.connect.CloseCon;
import com.restaurant.connect.Connect;

public class InsertItemService 
{
	public static void insertItemService(String itemName,String itemValue)
	{

		Connection con=null;
		PreparedStatement ps=null;
		
		String qry="Insert into restaurant.items values(?,?)";
		try
		{
			con=Connect.getConnect();
			ps=con.prepareStatement(qry);
			ps.setString(1, itemName);
			ps.setString(2, itemValue);
			ps.executeUpdate();
			System.out.println("Item Entry Made");
			//res.sendRedirect("InsertAnother.html");
			
			
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
