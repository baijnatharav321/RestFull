package com.jersey.ExceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.jersey.response.CustomError;
import com.rest.exception.BadRequestExceptionClass;

public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestExceptionClass> {

	@Override
	public Response toResponse(BadRequestExceptionClass exception) {
		CustomError error = new CustomError();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		return Response.status(400).entity(error).type(MediaType.APPLICATION_JSON).build();
	}
}
