package com.restaurant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ser.GenerateBillService;

@WebServlet("/bill")
public class GenerateBillServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String itemName=req.getParameter("itemName");
		String quantity=req.getParameter("quantity");
		
		System.out.println(itemName+" "+quantity);
		
		
		
		GenerateBillService.generateBillService(itemName, quantity, req, res);
		
				
	}
}