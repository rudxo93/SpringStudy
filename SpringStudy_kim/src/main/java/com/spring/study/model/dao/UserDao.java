package com.spring.study.model.dao;

import com.spring.study.model.dto.UserDto;

public interface UserDao {
	
	public UserDto getUser(String email);
	public int login(UserDto userDto); // 로그인
	public int idCheck(String user_email);  // id중복확인
	public int signUp(UserDto userDto);

}
  