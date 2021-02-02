package com.mymovie.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.mymovie.filter.CorsFilter;


@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("com.mymovie");
		register(CorsFilter.class);
	}
}
