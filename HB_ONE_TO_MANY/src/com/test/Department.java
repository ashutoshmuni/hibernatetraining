package com.test;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private int department_id;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@OneToMany(cascade={CascadeType.ALL})
	private Set<Employee> employees;

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String toString() {
		return department_id + " - " + departmentName + " - " + employees;
	}
}

/*
CREATE TABLE DEPARTMENT (DEPARTMENT_ID NUMBER(4) PRIMARY KEY, DEPARTMENT_NAME VARCHAR2(15))
*/