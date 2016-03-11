package com.test;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long employeeId;

	@Column(name="name")
	private String name;
	
	@Column(name="sal")
	private double sal;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	public Employee() {
		
	}
	
	public Employee(String name, double sal) {
		this.name = name;
		this.sal = sal;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	public String toString() {
		return employeeId + " - " + name + " - " + sal;
	}
	
}
/*
CREATE TABLE EMPLOYEE (ID NUMBER(4) PRIMARY KEY, NAME VARCHAR2(15), SAL NUMBER(7,2), 
	DEPARTMENT_ID NUMBER(4) NOT NULL,
	CONSTRAINT FK_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID))
	 
*/