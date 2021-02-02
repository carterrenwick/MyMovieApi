package com.mymovie.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mymovie.model.Person;

@Path("/test")
public class TestController {
	
	@GET
	@Path("/ping")
	public String getPing() {
		return "PONG";
	}

	@GET
	@Path("/jsonTest")
	@Produces({ MediaType.APPLICATION_JSON })
	public Person getJson() {
		return new Person(1, "Carter", "Taylor");
	}

}
