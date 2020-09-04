package com.jersey.ExceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.jersey.response.CustomError;
import com.rest.exception.EmployeeNotFoundExceptionClass;

public class EmployeeNotFoundExceptonMapper implements ExceptionMapper<EmployeeNotFoundExceptionClass> {

	@Override
	public Response toResponse(EmployeeNotFoundExceptionClass exception) {
		CustomError error = new CustomError();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		return Response.status(404).entity(error).type(MediaType.APPLICATION_JSON_PATCH_JSON).build();
	}

}
