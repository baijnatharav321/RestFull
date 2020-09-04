package com.rest.jersey.service;

import java.util.Map;

import javax.ws.rs.core.Response;


public interface EmployeeService {

	public Response getEmployee();
	
	public Response getEmployee(Long id);
	
	public Response addEmployee(Map<String,String> data);
	
	public Response deleteEmployee(Long id);
	
	
	
}
