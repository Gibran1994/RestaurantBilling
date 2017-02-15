package com.restaurant.servlets;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.ser.Loginservice;

@Path("login")
public class LoginServlet
{

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public static Response loginJersey(@FormParam("user") String username,@FormParam("password") String password)
	{
		
		System.out.println(username + " " + password);
		Boolean res=Loginservice.loginService(username,password);
				
		java.net.URI location;
		if(res)
		{
		try {
			location = new java.net.URI("../WelcomeUser.html");
			return Response.temporaryRedirect(location).build();

			} catch (URISyntaxException e) {
			e.printStackTrace();
			
			}
		}
		else
		{
			try {
				location = new java.net.URI("../InvalidUser.html");
				return Response.temporaryRedirect(location).build();

				} catch (URISyntaxException e) {
				e.printStackTrace();
				}
		}
		return null;
	    }
}