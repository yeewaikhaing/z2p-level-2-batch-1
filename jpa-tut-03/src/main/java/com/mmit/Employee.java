package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
   
	
}
