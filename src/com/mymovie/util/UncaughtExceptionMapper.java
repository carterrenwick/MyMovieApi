package com.mymovie.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UncaughtExceptionMapper extends Throwable implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 1L;

	@Override
	public Response toResponse(Throwable e) {
		String errMsg = e.getMessage() == null ? "Internal Server Error" : "Server error: " + e.getMessage();
		return Response.status(500).entity(errMsg).type("text/plain").build();
	}
}
