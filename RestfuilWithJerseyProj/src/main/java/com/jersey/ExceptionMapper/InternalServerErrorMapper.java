package com.jersey.ExceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.jersey.response.CustomError;
import com.rest.exception.InternalServerErrorClass;

public class InternalServerErrorMapper implements ExceptionMapper<InternalServerErrorClass> {

	@Override
	public Response toResponse(InternalServerErrorClass exception) {
		CustomError error = new CustomError();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		return Response.status(500).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
