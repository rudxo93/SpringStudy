package com.spring.study.model;

public class CustomerModel {
	
	private String customer_name;
	private String customer_addr;
	private String customer_phone;
	private String customer_etc;
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_addr() {
		return customer_addr;
	}
	public void setCustomer_addr(String customer_addr) {
		this.customer_addr = customer_addr;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_etc() {
		return customer_etc;
	}
	public void setCustomer_etc(String customer_etc) {
		this.customer_etc = customer_etc;
	}
}