package com.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.jersey.model.Employee;

public class EmployeeTestClient {

	private Client client;

	public EmployeeTestClient() {
		client = ClientBuilder.newClient();
	}

	public List<Employee> getAllEmp() {
		WebTarget target = client.target("http://localhost:9091/Employee/");
		List<Employee> emp = target.path("getAllEmp/").request(MediaType.APPLICATION_JSON).get(List.class);
		return emp;
	}

	public void delete(Long empId) {

		WebTarget target = client.target("http://localhost:9091/Employee/");
		Response response = target.path("Delete/" + empId).request(MediaType.APPLICATION_JSON).delete();

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ":there was an error in the server");
		}
	}

	public Employee add(Employee employee) {
		WebTarget target = client.target("http://localhost:9091/Employee/");
		Response response = target.path("Add/addEmp").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + "Server Error");
		}
		return employee;
	}

	public Employee getEmployee(Long id) {
		WebTarget target = client.target("http://localhost:9091/Employee/");
		Employee response = target.path("get/" + id).request(MediaType.APPLICATION_JSON).get(Employee.class);
		return response;
	}

}
