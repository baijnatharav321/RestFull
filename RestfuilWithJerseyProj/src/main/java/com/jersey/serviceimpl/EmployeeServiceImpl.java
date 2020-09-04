package com.jersey.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.repository.EmployeeRepository;
import com.rest.builder.EmployeeTestBuilder;
import com.rest.exception.BadRequestExceptionClass;
import com.rest.exception.EmployeeNotFoundExceptionClass;
import com.rest.exception.InternalServerErrorClass;
import com.rest.jersey.model.Employee;
import com.rest.jersey.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	public EmployeeRepository employeeRepo;

	@Override
	public Response getEmployee() {
		List<Employee> listofEmp = employeeRepo.findAll();
		if (listofEmp.isEmpty()) {
			logger.info("No records found");
			throw new EmployeeNotFoundExceptionClass("404", "Not Found");
		}
		return Response.status(200).entity(listofEmp).build();
	}

	@Override
	public Response getEmployee(Long id) {
		if (id == null) {
			logger.info("Bad Request");
			throw new BadRequestExceptionClass("400", "Bad Request");
		} else {
			Optional<Employee> optionalEmp = employeeRepo.findById(id);
			if (optionalEmp.isPresent()) {
				if (optionalEmp.get().equals(null)) {
					logger.info("Employee Recored not Found");
					throw new EmployeeNotFoundExceptionClass("404", "Not Found");
				}
				logger.info("Employee Record has successfully fetched");
				return Response.status(200).entity(optionalEmp).build();
			}
		}
		logger.info("Server error");
		throw new InternalServerErrorClass("500", "Server Error");
	}

	@Override
	public Response addEmployee(Map<String,String> data) {
		Employee emp = EmployeeServiceImpl.employeeBuilder(data);
		if (emp.getEmployeeName() == null) {
			logger.info("No data to Save");
			throw new EmployeeNotFoundExceptionClass("404", "No Data to Save");
		} else if (emp.getEmployeeName() != null) {
			logger.info("Add employee data successfully");
			employeeRepo.save(emp);
			return Response.status(200).entity(emp).build();
		}
		throw new InternalServerErrorClass("500", "Server Error");
	}

	@Override
	public Response deleteEmployee(Long id) {
		if (id == null) {
			logger.info("Invalid data");
			throw new BadRequestExceptionClass("400", "Bad Request");
		}
		try {
			employeeRepo.deleteById(id);
			return Response.status(200).build();
		} catch (EmployeeNotFoundExceptionClass ex) {
			ex.printStackTrace();
		}
		throw new InternalServerErrorClass("500", "Server Error");
	}

	public static Employee employeeBuilder(Map<String, String> body) {
		EmployeeTestBuilder empBuilder = new EmployeeTestBuilder();
		Long empId;
		String empName;
		String empMobileNo;
		float empSalary;

		empId = Long.parseLong(body.get("empId"));
		empName = body.get("employeeName");
		empMobileNo = body.get("employeeMobileno");
		empSalary = Float.parseFloat(body.get("employeeSalary"));
		return empBuilder.setEmpId(empId).setEmpMobileNo(empMobileNo).setEmpName(empName).setEmpSalary(empSalary)
				.build();
	}

	
}
