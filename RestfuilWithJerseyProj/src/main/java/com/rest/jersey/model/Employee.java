package com.rest.jersey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String employeeName;

	private Float employeeSalary;

	private String employeeMobileNo;
	
	public Employee() {
		
	}

	public Employee(Long empId, String employeeName, Float employeeSalary, String employeeMobileNo) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeMobileNo = employeeMobileNo;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeMobileno() {
		return employeeMobileNo;
	}

	public void setEmployeeMobileno(String employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", employeeSalary=" + employeeSalary
				+ ", employeeMobileno=" + employeeMobileNo + "]";
	}

}
