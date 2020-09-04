package com.rest.builder;

import com.rest.jersey.model.Employee;

public class EmployeeTestBuilder {
	private Long empId;
	private String employeeName;
	private String employeeMobileNo;
	private Float employeeSalary;

	public EmployeeTestBuilder setEmpId(Long empId) {
		this.empId = empId;
		return this;
	}

	public EmployeeTestBuilder setEmpName(String empName) {
		this.employeeName = empName;
		return this;
	}

	public EmployeeTestBuilder setEmpMobileNo(String empMobileNo) {
		this.employeeMobileNo = empMobileNo;
		return this;
	}

	public EmployeeTestBuilder setEmpSalary(Float empSalary) {
		this.employeeSalary = empSalary;
		return this;
	}

	public Employee build() {
		Employee emp = new Employee(empId, employeeName, employeeSalary, employeeMobileNo);
		return emp;
	}
}
