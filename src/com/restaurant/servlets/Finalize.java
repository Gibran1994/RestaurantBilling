package com.restaurant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ser.FinalizeService;

@WebServlet("/finalize")
public class Finalize extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String custName=req.getParameter("custName");
		
		
		
		FinalizeService.finalizeService(custName,req,resp);
		
						 
	}
}
