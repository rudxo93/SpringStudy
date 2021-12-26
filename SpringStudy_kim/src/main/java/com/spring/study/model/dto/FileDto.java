package com.spring.study.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	
	private String user_id;
	private String user_password;
	private MultipartFile[]  user_photo;
	private String name;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public MultipartFile[] getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(MultipartFile[] user_photo) {
		this.user_photo = user_photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "FileDto [user_id=" + user_id + ", user_password=" + user_password + ", user_photo=" + user_photo
				+ ", name=" + name + "]";
	}

}
