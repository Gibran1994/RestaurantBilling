package com.restaurant.servlets;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.ser.GenerateBillService;

@Path("bill")
public class GenerateBillServlet
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public static Response loginJersey(@FormParam("itemName") String itemName,@FormParam("quantity") String quantity)
	{
	
		
		System.out.println(itemName+" "+quantity);
		GenerateBillService.generateBillService(itemName, quantity);
		
		java.net.URI location;
		
		try {
			location = new java.net.URI("../EntrySuccess.html");
			return Response.temporaryRedirect(location).build();

			} catch (URISyntaxException e) {
			e.printStackTrace();
			
			}
		return null;
		
				
	}
}