package com.test;


import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
//savePerson(session);
saveDepartment(session);

		session.getTransaction().commit();
		session.close();
		
		sf.close();
		System.exit(0);
	}
	
	public static void savePerson(Session session) {
		Address address = new Address("Pune", 411001L);
		Person person = new Person("Tom", address);
		session.persist(person);
		System.out.println("Person saved!!");
	}
	
	public static void saveDepartment(Session session) {
		Department department = new Department();
		department.setDepartmentName("Sales");

		Employee emp1 = new Employee("Nina", 20000);
		Employee emp2 = new Employee("Tony", 30000.85);
		
		department.setEmployees(new HashSet<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		session.save(department);
		System.out.println("department saved!!");
		
	}
}
