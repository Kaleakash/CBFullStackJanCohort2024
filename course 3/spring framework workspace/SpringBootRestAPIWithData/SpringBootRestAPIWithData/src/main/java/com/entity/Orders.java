package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)   // mysql start with 1 increment by 1
private int oid;
private LocalDateTime orderdate;
private Integer pid;		//FK it can hold null value.
private int qty;

@Override
public String toString() {
	return "Orders [oid=" + oid + ", orderdate=" + orderdate + ", pid=" + pid + ", qty=" + qty + "]";
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public LocalDateTime getOrderdate() {
	return orderdate;
}
public void setOrderdate(LocalDateTime orderdate) {
	this.orderdate = orderdate;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}

}
