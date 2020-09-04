package com.rest.jersey.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rest.client.EmployeeTestClient;
import com.rest.jersey.model.Employee;

public class EmployeeClientTest {

	@Test
	public void getEmp() {
		EmployeeTestClient empClient = new EmployeeTestClient();
		Employee emp = empClient.getEmployee((long) 4);
		assertNotNull(emp);
	}

	@Test
	public void getAllEmp() {
		EmployeeTestClient empClient = new EmployeeTestClient();
		empClient.getAllEmp();
		assertNotNull(empClient);
	}

	@Test
	public void testDelete() {
		long id = 4;
		EmployeeTestClient empClient = new EmployeeTestClient();
		empClient.delete(id);
		assertNotNull(empClient);
	}

	@Test
	public void testAdd() {
		Employee emp = new Employee();

		long id = 7;
		emp.setEmpId(id);

		emp.setEmployeeName("Somthing");
		emp.setEmployeeMobileno("9090909191");
		emp.setEmployeeSalary((float) 30000.00);

		EmployeeTestClient empClient = new EmployeeTestClient();
		empClient.add(emp);
		assertNotNull(empClient);
	}

}
