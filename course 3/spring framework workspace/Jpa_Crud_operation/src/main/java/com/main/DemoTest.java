package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.bean.Product;
public class DemoTest {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa_Crud_operation");
		System.out.println("unit name is ready");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		
		// Insert Query 
//		Product p1 = new Product();
//		p1.setPid(102);
//		p1.setPname("Mobile");
//		p1.setPrice(65000);
//		
//		tran.begin();
//			manager.persist(p1);     // save object in db like insert query 
//		//tran.rollback();
//		tran.commit();
//		System.out.println("record inserted...");
		
//		// update query 
//		
//		Product p = manager.find(Product.class, 100);
//		if(p==null) {
//			System.out.println("record not present");
//		}else {
//			p.setPrice(58000);
//			tran.begin();
//			manager.persist(p);    // update query 
//			tran.commit();
//			System.out.println("Record updated...");
//		}
		
//		// delete query 
//		Product p = manager.find(Product.class, 101);
//		if(p==null) {
//			System.out.println("record not present");
//		}else {
//			tran.begin();
//			manager.remove(p);		// delete query 
//			tran.commit();
//			System.out.println("Record deleted...");
//		}
		// find record using id 
				Product p = manager.find(Product.class, 102);
				if(p==null) {
					System.out.println("record not present");
				}else {
					System.out.println("pid "+p.getPid()+" name "+p.getPname()+" price "+p.getPrice());
				}
		
	}

}

