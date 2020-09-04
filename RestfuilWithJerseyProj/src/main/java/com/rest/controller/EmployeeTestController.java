package com.rest.controller;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.serviceimpl.EmployeeServiceImpl;

@Path("/Employee")
public class EmployeeTestController {

	@Autowired
	EmployeeServiceImpl employeeServiceimpl;

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("id") Long id) {
		return employeeServiceimpl.getEmployee(id);
	}

	@GET
	@Path("/getAllEmp")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllEmployee() {
		return employeeServiceimpl.getEmployee();
	}

	@DELETE
	@Path("Delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") Long id) {
		return employeeServiceimpl.deleteEmployee(id);
	}

	@POST
	@Path("Add/addEmp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmp(Map<String, String> body) {
		System.out.println("From Controller"+body.get("empId"));
		return employeeServiceimpl.addEmployee(body);

	}
}
