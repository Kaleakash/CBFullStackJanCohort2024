package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orders;
import com.service.OrdersService;

@RestController
@RequestMapping("order")		// http://localhost:8080/order/*
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping(value = "place",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String placerOrder(@RequestBody Orders order) {
		return ordersService.placeOrder(order);
	}
	
	@GetMapping(value = "viewall",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> viewAllOrders() {
		return ordersService.viewAllOrders();
	}
	
	@GetMapping(value = "viewbyorderid/{oid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders viewOrderInfo(@PathVariable("oid") int oid) {
		return ordersService.searchOrdersByOrderId(oid);
	}
	@GetMapping(value = "viewbyproductid/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> viewOrderByProductId(@PathVariable("pid") int pid){
		return ordersService.viewOrderByProductId(pid);
	}
	
}
