package com.restaurant.servlets;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.ser.InsertItemService;

@Path("/insert")
public class InsertItemServlet
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public static Response loginJersey(@FormParam("item") String itemName,@FormParam("price") String itemValue)
	{
	
		
		System.out.println(itemName+" "+itemValue);
		InsertItemService.insertItemService(itemName, itemValue);
		try {
			java.net.URI location;
			location = new java.net.URI("../InsertAnother.html");
			return Response.temporaryRedirect(location).build();

			} catch (URISyntaxException e) {
			e.printStackTrace();
			
			}
		return null;
	}

}
