package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "orderinfo")
public class OrdersInfo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int oid;
private String emailid;
@ManyToMany
@JoinTable(name = "productorderinfo")
private List<Product> products;
private int totalamount;
private LocalDateTime orderdate;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public int getTotalamount() {
	return totalamount;
}
public void setTotalamount(int totalamount) {
	this.totalamount = totalamount;
}
public LocalDateTime getOrderdate() {
	return orderdate;
}
public void setOrderdate(LocalDateTime orderdate) {
	this.orderdate = orderdate;
}

}
