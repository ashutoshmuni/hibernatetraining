package com.hibernate.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud_Opr {

	public static void main(String[] args) throws Exception {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session_1 = sessionFactory.openSession();
		Product product = new Product("Chairs", 400); //Transient
		Transaction t1 = session_1.beginTransaction();
		session_1.save(product);
		long p_id = product.getId(); //Managed
		System.out.println("Product id = " + p_id);
		t1.commit();
		session_1.close();
		
		Session session_2 = sessionFactory.openSession();
		Transaction t2 = session_2.beginTransaction();
		Product product_2 = session_2.load(Product.class, p_id); // Managed
		product_2.setPrice(700);
		t2.commit();
		session_2.close();
		
		Session session_3 = sessionFactory.openSession();
		Query query = session_3.createQuery("from Product");
		
		List<Product> products = query.list();
		for(Product pd: products) {
			System.out.println("pd = " + pd);
		}
		session_3.close();
		
		Session session_4 = sessionFactory.openSession();
		Transaction t4 = session_4.beginTransaction();
		Query query_2 = session_4.createQuery("delete from Product");
		int updates = query_2.executeUpdate();
		System.out.println("Deleted " + updates + " record/s");
		t4.commit();
		session_4.close();
		
		sessionFactory.close();


	}

}
