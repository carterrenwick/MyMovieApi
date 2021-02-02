package com.mymovie.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mymovie.model.Movie;
import com.mymovie.service.MovieService;

@Path("/movie")
public class MovieController {
	
	private MovieService movieService;

	public MovieController() {
		movieService = new MovieService();
	}
	
	@GET
	@Path("/getAllMovies")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@PUT
	@Path("/createMovie")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Movie createMovie(Movie movie) {
		return movieService.createMovie(movie);
	}
	
	@POST
	@Path("/updateMovie")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateMovie(Movie movie) {
		movieService.updateMovie(movie);
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/deleteMovie/{id}")
	public Response deleteMovie(@PathParam("id") int id) {
		movieService.deleteMovie(id);
		return Response.status(200).build();
	}

}
