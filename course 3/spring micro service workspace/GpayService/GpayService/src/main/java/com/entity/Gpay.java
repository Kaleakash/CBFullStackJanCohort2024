package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gpay {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int gpayid;
private String emailid;
private int accno;
public int getGpayid() {
	return gpayid;
}
public void setGpayid(int gpayid) {
	this.gpayid = gpayid;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}

}
