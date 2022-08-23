package com.mmit.beans;

import java.util.ArrayList;
import java.util.List;

import com.mmit.entities.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmployeeBean {

	private Employee employee;
	
	@Inject
	private EmployeeListBean listBean;
	

	public EmployeeBean() {
		employee = new Employee();
		System.out.println("this is constructor");
	}
	
	
	public String save() {
		listBean.getEmployees().add(employee);
		
		return "/index?faces-redirect=true";
	}
	
	


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String[] getPositions() {
		return new String[] {
				"Developer", "Project Manager", "Customer Support"
		};
	}
	
}
