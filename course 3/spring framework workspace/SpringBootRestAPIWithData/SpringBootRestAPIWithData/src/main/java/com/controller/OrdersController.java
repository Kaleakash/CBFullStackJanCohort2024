package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orders;
import com.service.OrdersService;

@RestController
@RequestMapping("order")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping(value = "place",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String placerOrder(@RequestBody Orders order) {
		return ordersService.placeOrder(order);
	}
	
}
