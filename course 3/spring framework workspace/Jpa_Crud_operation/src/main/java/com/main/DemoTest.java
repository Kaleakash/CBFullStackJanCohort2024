package com.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bean.Product;
public class DemoTest {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa_Crud_operation");
		System.out.println("unit name is ready");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		
		// Insert Query 
//		Product p1 = new Product();
//		p1.setPid(101);
//		p1.setPname("Laptop");
//		p1.setPrice(97000);
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
//				Product p = manager.find(Product.class, 102);
//				if(p==null) {
//					System.out.println("record not present");
//				}else {
//					System.out.println("pid "+p.getPid()+" name "+p.getPname()+" price "+p.getPrice());
//				}
		
		// retreive more than one records like select query 
		
//			Query qry= manager.createQuery("select p from Product p");
//			List<Product> listOfProuct = qry.getResultList();
//			System.out.println("Number of records "+listOfProuct.size());
//			Iterator<Product> li = listOfProuct.iterator();
//			while(li.hasNext()) {
//				Product p = li.next();
//				System.out.println(p);  // it call toString method
//			}
//				
				
		// retriving with conditions 
		//Query qry= manager.createQuery("select p from Product p where p.pid=100");
		//Query qry= manager.createQuery("select p from Product p where p.price>60000");
		// dynamic value using label query 
//		Query qry= manager.createQuery("select p from Product p where p.price> :p_price");
//		float price = 60000;
//		qry.setParameter("p_price", price);
//		List<Product> listOfProuct = qry.getResultList();
//		System.out.println("Number of records "+listOfProuct.size());
//		Iterator<Product> li = listOfProuct.iterator();
//		while(li.hasNext()) {
//			Product p = li.next();
//			System.out.println(p);  // it call toString method
//		}
			
		
		//retrieve partial object ie pid 
		
//		Query qry= manager.createQuery("select p.pid from Product p");
//		List<Integer> listOfProuct = qry.getResultList();
//		Iterator<Integer> li = listOfProuct.iterator();
//		while(li.hasNext()) {
//			int pid = li.next();
//			System.out.println(pid);  
//		}
		
		//retrieve partial object ie pname
		
//		Query qry= manager.createQuery("select p.pname from Product p");
//		List<String> listOfProuct = qry.getResultList();
//		Iterator<String> li = listOfProuct.iterator();
//		while(li.hasNext()) {
//			String pname = li.next();
//			System.out.println(pname);  
//		}
		
		// retrieve partial object more than property pname,price 

		// join query 
		Query qry= manager.createQuery("select p.pname,p.price from Product p");
		List<Object[]> listOfProuct = qry.getResultList();
		Iterator<Object[]> li = listOfProuct.iterator();
		while(li.hasNext()) {
			Object obj[]=li.next();
			System.out.println("PName "+obj[0]+" Price "+obj[1]);
		}
	}

}

