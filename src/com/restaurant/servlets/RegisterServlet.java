package com.restaurant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ser.RegisterService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		System.out.println(username + " " + password);
		
		
		
		RegisterService.registerService(username,password,req,res);
			
	}
}