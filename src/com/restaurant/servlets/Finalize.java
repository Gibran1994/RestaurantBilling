package com.restaurant.servlets;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.ser.FinalizeService;

@Path("finalize")
public class Finalize
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public static Response loginJersey(@FormParam("custName") String custName)
	{
		
	
		FinalizeService.finalizeService(custName);
		java.net.URI location;
		
		try {
			location = new java.net.URI("../Bill.jsp");
			return Response.temporaryRedirect(location).build();

			} catch (URISyntaxException e) {
			e.printStackTrace();
			
			}
		return null;
						 
	}
}
