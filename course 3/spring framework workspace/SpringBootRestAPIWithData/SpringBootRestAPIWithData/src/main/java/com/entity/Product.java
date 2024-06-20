package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
@Id
private int pid;
private String pname;
private float price;
private int qty;
@OneToMany
@JoinColumn(name = "pid")		// refer to fk in orders table. 
private List<Orders> orderinfo;		

@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", orderinfo=" + orderinfo
			+ "]";
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public List<Orders> getOrderinfo() {
	return orderinfo;
}
public void setOrderinfo(List<Orders> orderinfo) {
	this.orderinfo = orderinfo;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}
