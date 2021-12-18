package com.spring.study.model.dto;

public class UserDto {
	
	private String user_email;
	private String user_password;
	private String user_name;
	private String user_phoneNumber;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phoneNumber() {
		return user_phoneNumber;
	}
	public void setUser_phoneNumber(String user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}
	
	@Override
	public String toString() {
		return "UserDto [user_email=" + user_email + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_phoneNumber=" + user_phoneNumber + "]";
	}

}
