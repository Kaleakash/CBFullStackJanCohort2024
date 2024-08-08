package com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.OrdersInfo;
import com.repository.OrdersInfoRepository;

@Service
public class OrdersInfoService {

	@Autowired
	OrdersInfoRepository ordersInfoRepository;
	
	public String placeOrder(OrdersInfo order) {
		order.setOrderdate(LocalDateTime.now());
		ordersInfoRepository.save(order);
		return "Order Placed successfully";
	}
	
	
	public Object[] viewAllOrderInfo() {
		return ordersInfoRepository.viewAllOrdersInfo();
	}
	
	public Object[] viewOrdersInfoByCustomer(String emailid) {
		return ordersInfoRepository.viewOrdersInfoByCustomer(emailid);
	}
}
