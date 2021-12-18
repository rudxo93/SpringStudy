package com.spring.study.model.dao;

import com.spring.study.model.dto.UserDto;

public interface UserDao {
	
	public UserDto getUser(String email);

}
