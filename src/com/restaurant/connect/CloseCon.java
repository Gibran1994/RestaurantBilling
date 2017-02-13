package com.restaurant.connect;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class CloseCon
{
	public static void close(Connection con,PreparedStatement ps) throws SQLException
	{
		con.close();
		System.out.println("Connection Closed");
		ps.close();
		System.out.println("prepared Statement Closed");
	}
}
