package com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrdersDao;
import com.entity.Orders;

@Service
public class OrdersService {

	@Autowired
	OrdersDao ordersDao;
	
	public String placeOrder(Orders order) {
		order.setOrderdate(LocalDateTime.now()); // set current date and time.
		ordersDao.save(order);
		return "Order placed successfully";
	}
}
