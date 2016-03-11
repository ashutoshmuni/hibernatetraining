package com.test;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@DiscriminatorValue(value="labour")
public class Labour extends Employee {

	@Column(name="OVERTIME")
	private double overtime;

	public Labour() {
		
	}
	
	public Labour(double overtime) {
		this.overtime = overtime;
	}

	public String toString() {
		return overtime + " - " + super.toString();
	}
	
}
/*
CREATE TABLE EMPLOYEE (ID NUMBER(4) PRIMARY KEY, NAME VARCHAR2(15), SAL NUMBER(7,2), 
	DEPARTMENT_ID NUMBER(4) NOT NULL,
	CONSTRAINT FK_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID))
	 
*/