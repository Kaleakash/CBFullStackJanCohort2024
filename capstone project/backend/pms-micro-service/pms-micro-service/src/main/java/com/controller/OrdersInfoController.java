package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.OrdersInfo;
import com.service.OrdersInfoService;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class OrdersInfoController {

	@Autowired
	OrdersInfoService ordersInfoService;
	
	@PostMapping(value = "placeorder",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String placeOrder(@RequestBody OrdersInfo orders) {
		return ordersInfoService.placeOrder(orders);
	}
	
	@GetMapping(value = "viewallorders",produces = MediaType.APPLICATION_JSON_VALUE)
	public Object[] viewAllOrders() {
		return ordersInfoService.viewAllOrderInfo();
	}
	
	@GetMapping(value = "vieworderbycustomer/{emailid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Object[] viewOrdersInfoByCustomer(@PathVariable("emailid") String emailid) {
		return ordersInfoService.viewOrdersInfoByCustomer(emailid);
	}
}








