package com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.entity.Orders;

@Service
public class OrdersService {

	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	ProductDao productDao;
	
	public String placeOrder(Orders order) {
		order.setOrderdate(LocalDateTime.now()); // set current date and time.
		
		if(productDao.existsById(order.getPid())) {
			ordersDao.save(order);
			return "Order placed successfully";
		}else {
			return "Product details not present";
		}
		
	}
}
