package com.restaurant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ser.InsertItemService;

@WebServlet("/insert")
public class InsertItemServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String itemName=req.getParameter("item");
		String itemValue=req.getParameter("price");
		System.out.println(itemName+" "+itemValue);
		

		
		
		
		InsertItemService.insertItemService(itemName, itemValue, req, res);
				}

}
