package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.entity.Orders;
import com.entity.Product;

@Service
public class OrdersService {

	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	ProductDao productDao;
	
	public String placeOrder(Orders order) {		// pid and qty 
		
		
//		if(productDao.existsById(order.getPid())) {
//			ordersDao.save(order);
//			return "Order placed successfully";
//		}else {
//			return "Product details not present";
//		}
		
		order.setOrderdate(LocalDateTime.now()); // set current date and time.
		Optional<Product> result = productDao.findById(order.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			if(p.getQty() >=  order.getQty()) {		// 10  12
				ordersDao.save(order);
				p.setQty(p.getQty()-order.getQty());
				productDao.saveAndFlush(p);
				return "Order placed successfully";
			}else {
				return "Qty > Available Qty";
			}
		}else {
			return "Product details not present";
		}
	}
	
	public List<Orders> viewAllOrders() {
		return ordersDao.findAll();
	}
	
	public List<Orders> viewOrderByProductId(int pid){
		return ordersDao.findOrdersByProductId(pid);
	}
	
	public Orders searchOrdersByOrderId(int oid) {
		
		Optional<Orders> result = ordersDao.findById(oid);		//oid is pk 
		if(result.isPresent()) {
			Orders oo = result.get();
			return oo;
		}else {
			return null;
		}
	}
}
