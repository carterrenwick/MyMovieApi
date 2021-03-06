package com.mymovie.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;

@Priority(1)
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

	public void filter(ContainerRequestContext request) throws IOException {
		if (isPreflightRequest(request)) {
			request.abortWith(Response.ok().build());
			return;
		}
	}

	private static boolean isPreflightRequest(ContainerRequestContext request) {
		return request.getHeaderString("Origin") != null && request.getMethod().equalsIgnoreCase("OPTIONS");
	}

	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		// if there is no Origin header, then it is not a cross origin request.
		if (request.getHeaderString("Origin") == null) {
			return;
		}

		// If it is a pre-flight request, then we add CORS headers
		if (isPreflightRequest(request)) {
			response.getHeaders().add("Access-Control-Allow-Credentials", "true");
			response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
			response.getHeaders().add("Access-Control-Allow-Headers",
					"X-Requested-With, Authorization, " + "Accept-Version, Content-MD5, CSRF-Token, Content-Type");
		}

		response.getHeaders().add("Access-Control-Allow-Origin", "*");
	}
}
