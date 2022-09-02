package com.mmit;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmployeeBean {

	private Employee employee;
	
	@PostConstruct
	private void init() {
		employee = new Employee();
	}

	public void register() {
		System.out.println("this is register method");
	}
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
