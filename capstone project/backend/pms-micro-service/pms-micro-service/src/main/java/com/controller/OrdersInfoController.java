package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
